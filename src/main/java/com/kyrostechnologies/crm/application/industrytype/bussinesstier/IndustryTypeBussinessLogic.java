package com.kyrostechnologies.crm.application.industrytype.bussinesstier;

import com.kyrostechnologies.crm.application.industrytype.datatier.IndustryTypeDataTier;
import com.kyrostechnologies.crm.application.industrytype.interfaceclass.IndustryTypeInterface;
import com.kyrostechnologies.crm.model.IndustryTypeModel;
import com.kyrostechnologies.crm.response.IndustryTypeResponse;
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
public class IndustryTypeBussinessLogic implements IndustryTypeInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public IndustryTypeResponse getIndustryType() {
        String query="CALL `Settings.IndustryType_GetIndustryType`();\n";
        System.out.println("Query : "+query);
        List<IndustryTypeModel>industryTypeModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new IndustryTypeDataTier());
        if(industryTypeModelList!=null&&industryTypeModelList.size()!=0){
            return getIndustryTypeResponse(true,"Success",industryTypeModelList);
        }
        return getIndustryTypeResponse(false,"List is empty or null",null);
    }

    @Override
    public IndustryTypeResponse insertIndustryType(IndustryTypeModel model) {
        String query="CALL `Settings.IndustryType_InsertIndustryType`(?)";
        System.out.println("Query : "+query);
        int isInserted = jdbcTemplate.execute(query, (PreparedStatementCallback<Integer>) preparedStatement -> {
            preparedStatement.setString(1, model.getTypeName());
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getIndustryType();
        }
        return getIndustryTypeResponse(false,"industry type is not inserted",null);
    }

    @Override
    public IndustryTypeResponse updateIndustryType(IndustryTypeModel model) {
        String query="CALL `Settings.IndustryType_UpdateIndustryType`(?,?,?,?)";
        System.out.println("Query : "+query);
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String ModifiedDate=dateFormat.format(date);
            preparedStatement.setInt(1,model.getIndustryTypeId() );
            preparedStatement.setString(2, model.getTypeName());
            preparedStatement.setBoolean(3, model.getIsActive());
            preparedStatement.setString(4, ModifiedDate);
            return preparedStatement.executeUpdate();
        });
        if(isUpdated!=0){
            return getIndustryType();
        }
        return getIndustryTypeResponse(false,"industry type is not updated",null);
    }

    @Override
    public IndustryTypeResponse deleteIndustryType(IndustryTypeModel model) {
        String query="CALL `Settings.IndustryType_DeleteIndustryType`(?);";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getIndustryTypeId());
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return getIndustryType();
        }
        return getIndustryTypeResponse(false,"industry type is not deleted",null);
    }
    private IndustryTypeResponse getIndustryTypeResponse(boolean value, String message, List<IndustryTypeModel> industryTypeModelList){
        IndustryTypeResponse response=new IndustryTypeResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setIndustryType(industryTypeModelList);
        return response;
    }
}
