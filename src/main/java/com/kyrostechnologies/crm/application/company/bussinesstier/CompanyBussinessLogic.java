package com.kyrostechnologies.crm.application.company.bussinesstier;

import com.kyrostechnologies.crm.application.company.interfaceclass.CompanyInterface;
import com.kyrostechnologies.crm.application.company.datatier.CompanyDataTier;
import com.kyrostechnologies.crm.model.CompanyModel;
import com.kyrostechnologies.crm.response.CompanyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class CompanyBussinessLogic implements CompanyInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public CompanyResponse getCompanyByUserProfileId(int UserProfileId) {
        String query="CALL  `UserSettings.Company_GetCompanybyUserProfileId`("+UserProfileId+");";
        System.out.println("Query : "+query);
        List<CompanyModel>companyModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new CompanyDataTier());
        if(companyModelList!=null &&companyModelList.size()!=0){
            return getCompanyResponse(true, "Success",companyModelList);
        }
        return getCompanyResponse(false,"List is empty or null",null);
    }

    @Override
    public CompanyResponse getCompanyByCompanyId(int CompanyId) {
        String query="CALL  `UserSettings.Company_GetCompanybyCompanyId`("+CompanyId+");";
        System.out.println("Query : "+query);
        List<CompanyModel>companyModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new CompanyDataTier());
        if(companyModelList!=null &&companyModelList.size()!=0){
            return getCompanyResponse(true, "Success",companyModelList);
        }
        return getCompanyResponse(false,"List is empty or null",null);
    }

    @Override
    public CompanyResponse insertCompany(CompanyModel model) {
        String query="CALL `UserSettings.Company_InsertCompany`(?,?,?)";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getUserProfileId() );
            preparedStatement.setString(2, model.getCompanyCode());
            preparedStatement.setString(3, model.getCompanyName());
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getCompanyByUserProfileId(model.getUserProfileId());
        }
        return getCompanyResponse(false,"Company is not inserted",null);
    }

    @Override
    public CompanyResponse updateCompany(CompanyModel model) {
        String query="CALL `UserSettings.Company_UpdateCompany`(?,?,?,?,?)";
        System.out.println("Query : "+query);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ModifiedDate=dateFormat.format(new Date());
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getCompanyId() );
            preparedStatement.setInt(2, model.getUserProfileId());
            preparedStatement.setString(3, model.getCompanyName());
            preparedStatement.setBoolean(4, model.getIsActive());
            preparedStatement.setString(5, ModifiedDate);
            return preparedStatement.executeUpdate();
        });
        if(isUpdated!=0){
            return getCompanyByUserProfileId(model.getUserProfileId());
        }
        return getCompanyResponse(false,"company is not updated",null);
    }

    @Override
    public CompanyResponse deleteCompany(CompanyModel model) {
        String query="CALL `UserSettings.Company_DeleteCompany`(?);";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getCompanyId());
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return getCompanyByUserProfileId(model.getUserProfileId());
        }
        return getCompanyResponse(false,"company is not deleted",null);
    }
    private CompanyResponse getCompanyResponse(boolean value, String message, List<CompanyModel>companyModelList){
        CompanyResponse response=new CompanyResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setCompanyList(companyModelList);
        return response;
    }
}
