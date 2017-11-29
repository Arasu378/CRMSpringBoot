package com.kyrostechnologies.crm.application.activitytype.bussinesstier;

import com.kyrostechnologies.crm.application.activitytype.interfaceclass.ActivityTypeInterface;
import com.kyrostechnologies.crm.application.activitytype.datatier.ActivityTypeDataTier;
import com.kyrostechnologies.crm.model.ActivityTypeModel;
import com.kyrostechnologies.crm.response.ActivityTypeResponse;
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
public class ActivityTypeBussinessLogic implements ActivityTypeInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public ActivityTypeResponse getActivityType() {
        String query="Call `UserSettings.ActivityType_GetActivityTypes`(); ";
        System.out.println("Query : "+query);
        List<ActivityTypeModel>activityTypeModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new ActivityTypeDataTier());
        if(activityTypeModelList!=null && activityTypeModelList.size()!=0){
            return getActivityTypeResponse(true,"Success",activityTypeModelList);
        }
        return getActivityTypeResponse(false,"List is empty or null",null);
    }

    @Override
    public ActivityTypeResponse insertActivityType(ActivityTypeModel model) {
        String query="CALL `UserSettings.ActivityType_InsertActivityType`(?,?,?,?,?,?)";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            int orderNr=model.getOrderNr();
            preparedStatement.setInt(1, orderNr);
            String name=model.getName();
            preparedStatement.setString(2, name);
            String keyString=model.getKeyString();
            preparedStatement.setString(3, keyString);
            String iconKey=model.getIconKey();
            preparedStatement.setString(4, iconKey);
            boolean activeFlag=model.getActiveFlag();
            preparedStatement.setBoolean(5, activeFlag);
            boolean isCustomFlag=model.getIsCustomFlag();
            preparedStatement.setBoolean(6, isCustomFlag);
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getActivityType();
        }

        return getActivityTypeResponse(false,"Activity type is not inserted",null);
    }

    @Override
    public ActivityTypeResponse updateActivityType(ActivityTypeModel model) {
        String query="CALL `UserSettings.ActivityTypes_UpdateActivityType`(?,?,?,?,?,?,?,?)";
        System.out.println("Query : "+query);
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String modifiedDate=dateFormat.format(date);
            int orderNr=model.getOrderNr();
            preparedStatement.setInt(1, orderNr);
            String name=model.getName();
            preparedStatement.setString(2, name);
            String keyString=model.getKeyString();
            preparedStatement.setString(3, keyString);
            String iconKey=model.getIconKey();
            preparedStatement.setString(4, iconKey);
            boolean activeFlag=model.getActiveFlag();
            preparedStatement.setBoolean(5, activeFlag);
            boolean isCustomFlag=model.getIsCustomFlag();
            preparedStatement.setBoolean(6, isCustomFlag);
            preparedStatement.setString(7, modifiedDate);
            int activityTypeId=model.getActivityTypeId();
            preparedStatement.setInt(8, activityTypeId);
            return preparedStatement.executeUpdate();
        });
        if(isUpdated!=0){
            return getActivityType();
        }
        return getActivityTypeResponse(false,"activity type is not updated",null);
    }

    @Override
    public ActivityTypeResponse deleteActivityType(ActivityTypeModel model) {
        String query="CALL `UserSettings.ActivityTypes_DeleteActivityType`(?)";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1, model.getActivityTypeId());
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return getActivityType();
        }
        return getActivityTypeResponse(false,"activity type is not deleted",null);
    }

    @Override
    public ActivityTypeResponse getActivityTypeByUserProfileId(int UserProfileId) {
        String query="CALL `UserSettings.ActivityTypes_GetActivityTypeByUserProfileId` ("+UserProfileId+");";
        System.out.println("Query : "+query);
        List<ActivityTypeModel>activityTypeModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new ActivityTypeDataTier());
        if(activityTypeModelList!=null && activityTypeModelList.size()!=0){
            return getActivityTypeResponse(true,"Success",activityTypeModelList);
        }
        return getActivityTypeResponse(false,"List is empty or null",null);
    }
    private  ActivityTypeResponse getActivityTypeResponse(boolean value, String message, List<ActivityTypeModel>activityTypeModelList){
        ActivityTypeResponse response=new ActivityTypeResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setActivityTypeList(activityTypeModelList);
        return response;
    }
}
