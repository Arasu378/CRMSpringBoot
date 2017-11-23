package com.kyrostechnologies.crm.application.userinterface.businesstier;

import com.kyrostechnologies.crm.application.remindertype.datatier.ReminderTypeDataTier;
import com.kyrostechnologies.crm.application.userinterface.datatier.UserInterfaceDataTier;
import com.kyrostechnologies.crm.application.userinterface.interfaceclass.UserInterface;
import com.kyrostechnologies.crm.model.ReminderTypeModel;
import com.kyrostechnologies.crm.model.UserInterfaceModel;
import com.kyrostechnologies.crm.response.ReminderTypeResponse;
import com.kyrostechnologies.crm.response.UserInterfaceResponse;
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
public class UserInterfaceBussinessLogic implements UserInterface {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public UserInterfaceResponse getUserInterfaceByUserProfileId(int UserProfileId) {
        String query="CALL  `UserSettings.UserInterface.GetUserInterfaceByUserProfileId`("+UserProfileId+");";
        System.out.println("Query : "+query);
        List<UserInterfaceModel> userInterfaceModelList= namedParameterJdbcTemplate.query(query, new MapSqlParameterSource(),new UserInterfaceDataTier());
        for(UserInterfaceModel model:userInterfaceModelList){
            System.out.println("UserProfileId : "+model.getUserProfileId());
        }

        if(userInterfaceModelList!=null && userInterfaceModelList.size()!=0){
            return getUserInterfaceResponse(true,"Success",userInterfaceModelList);
        }else{
            return getUserInterfaceResponse(false,"list size is zero or null!",null);

        }

    }

    @Override
    public UserInterfaceResponse getUserInterfaceByUserInterfaceId(int UserInterfaceId) {
        String query="CALL `UserSettings.UserInterface.GetUserInterfaceByUserInterfaceId`("+UserInterfaceId+");";
        System.out.println("Query : "+query);
        List<UserInterfaceModel> userInterfaceModelList= namedParameterJdbcTemplate.query(query, new MapSqlParameterSource(),new UserInterfaceDataTier());
        for(UserInterfaceModel model:userInterfaceModelList){
            System.out.println("UserProfileId : "+model.getUserProfileId());
        }
        if(userInterfaceModelList!=null && userInterfaceModelList.size()!=0){
            return getUserInterfaceResponse(true,"Success",userInterfaceModelList);
        }else{
            return getUserInterfaceResponse(false,"list size is zero or null!",null);
        }

    }

    @Override
    public UserInterfaceResponse insertUserInterface(UserInterfaceModel model) {
        String query="CALL `UserSettings.UserInterface_InsertUserInterface`(?,?,?,?,?);";
        System.out.println("Query : "+query);
        int isInserted=   jdbcTemplate.execute(query, (PreparedStatementCallback<Integer>) preparedStatement -> {
            int value;
            preparedStatement.setInt(1,model.getUserProfileId());
            preparedStatement.setBoolean(2,model.getIsDeal());
            preparedStatement.setBoolean(3, model.getIsPerson());
            preparedStatement.setBoolean(4, model.getIsOrganization());
            preparedStatement.setBoolean(5, model.getIsActive());
            value= preparedStatement.executeUpdate();
            return value;
        });
        if(isInserted==1){
            return getUserInterfaceByUserProfileId(model.getUserProfileId());
        }else{
            return getUserInterfaceResponse(false,"UserInterface is not inserted",null);
        }
    }

    @Override
    public UserInterfaceResponse updateUserInterface(UserInterfaceModel model) {
        String query="CALL `UserSettings.UserInterface_UpdateUserInterface`(?,?,?,?,?,?);";
        System.out.println("Query : "+query);
        int isInserted=   jdbcTemplate.execute(query, (PreparedStatementCallback<Integer>) preparedStatement -> {
            int value;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String modifiedDate=dateFormat.format(date);
            preparedStatement.setInt(1,model.getUserInterfaceId() );
            preparedStatement.setBoolean(2,model.getIsDeal());
            preparedStatement.setBoolean(3, model.getIsPerson());
            preparedStatement.setBoolean(4, model.getIsOrganization());
            preparedStatement.setBoolean(5, model.getIsActive());
            preparedStatement.setString(6, modifiedDate);

            value= preparedStatement.executeUpdate();
            return value;
        });
        if(isInserted==1){
            return getUserInterfaceByUserProfileId(model.getUserProfileId());
        }else{
            return getUserInterfaceResponse(false,"UserInterface is not updated",null);
        }

    }

    @Override
    public UserInterfaceResponse deleteUserInterface(UserInterfaceModel model) {
        String query="CALL `UserSettings.UserInterface_DeleteUserInterface`(?);";
        System.out.println("Query : "+query);
        int isInserted=   jdbcTemplate.execute(query, (PreparedStatementCallback<Integer>) preparedStatement -> {
            int value;
            preparedStatement.setInt(1,model.getUserInterfaceId() );
            value= preparedStatement.executeUpdate();
            return value;
        });
        if(isInserted==1){
            return getUserInterfaceByUserProfileId(model.getUserProfileId());
        }else{
            return getUserInterfaceResponse(false,"UserInterface is not deleted",null);
        }

    }
    private UserInterfaceResponse getUserInterfaceResponse(boolean success, String message, List<UserInterfaceModel> userInterfaceModelList){
        UserInterfaceResponse response=new UserInterfaceResponse();
        response.setIsSuccess(success);
        response.setMessage(message);
        response.setUserInterfaceList(userInterfaceModelList);
        return response;
    }
}
