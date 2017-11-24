package com.kyrostechnologies.crm.application.userlocale.bussinesstier;

import com.kyrostechnologies.crm.application.userlocale.interfaceclass.UserLocaleInterface;
import com.kyrostechnologies.crm.application.userlocale.datatier.UserLocaleDataTier;
import com.kyrostechnologies.crm.model.UserLocaleModel;
import com.kyrostechnologies.crm.response.UserLocaleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
public class UserLocaleBussinessLogic implements UserLocaleInterface {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public UserLocaleResponse getUserLocale() {
        String query="CALL `Settings.UserLocale_GetUserLocale`();";
        System.out.println("Query : "+query);
        List<UserLocaleModel>userLocaleModelList= namedParameterJdbcTemplate.query(query, new MapSqlParameterSource(),new UserLocaleDataTier());
        if(userLocaleModelList!=null && userLocaleModelList.size()!=0){
            return getUserLocaleResponse(true,"Success",userLocaleModelList);
        }
            return getUserLocaleResponse(false,"list size is zero or null!",null);


    }

    @Override
    public UserLocaleResponse insertUserLocale(UserLocaleModel model) {
        String query="CALL `Settings.UserLocale_InsertUserLocale`(?,?);";
        System.out.println("Query : "+query);
        int isInserted=   jdbcTemplate.execute(query, (PreparedStatementCallback<Integer>) preparedStatement -> {
            int value;
            preparedStatement.setString(1,model.getLocaleCode());
            preparedStatement.setString(2,model.getUserLocale());
            value= preparedStatement.executeUpdate();
            return value;
        });
        if(isInserted==1){
            return getUserLocale();
        }
            return getUserLocaleResponse(false,"UserLocale is not inserted",null);


    }

    @Override
    public UserLocaleResponse updateUserLocale(UserLocaleModel model) {
        String query="CALL `Settings.UserLocale_UpdateUserLocale`(?,?,?,?,?);";
        System.out.println("Query : "+query);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String modifiedDate=dateFormat.format(date);

        int isUpdated=   jdbcTemplate.execute(query, (PreparedStatementCallback<Integer>) preparedStatement -> {
            int value;
            preparedStatement.setInt(1,model.getUserLocaleId());
            preparedStatement.setString(2,model.getLocaleCode());
            preparedStatement.setString(3,model.getUserLocale());
            preparedStatement.setBoolean(4,model.getIsActive());
            preparedStatement.setString(5,modifiedDate);
            value= preparedStatement.executeUpdate();
            return value;
        });
        if(isUpdated==1){
            return getUserLocale();
        }
            return getUserLocaleResponse(false,"UserLocale is not updated",null);


    }

    @Override
    public UserLocaleResponse deleteUserLocale(UserLocaleModel model) {
        String query="CALL `Settings.UserLocale_DeleteUserLocale`(?);";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            int value;
            preparedStatement.setInt(1,model.getUserLocaleId());
            value=preparedStatement.executeUpdate();
            return value;
        });
        if(isDeleted==1){
            return getUserLocale();
        }
            return getUserLocaleResponse(false,"UserLocale is not Deleted",null);

    }
    private UserLocaleResponse getUserLocaleResponse(boolean success, String message, List<UserLocaleModel> userLocaleModelList){
        UserLocaleResponse response=new UserLocaleResponse();
        response.setIsSuccess(success);
        response.setMessage(message);
        response.setUserLocaleList(userLocaleModelList);
        return response;
    }
}
