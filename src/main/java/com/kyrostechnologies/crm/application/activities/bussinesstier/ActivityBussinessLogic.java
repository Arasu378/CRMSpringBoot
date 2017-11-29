package com.kyrostechnologies.crm.application.activities.bussinesstier;

import com.kyrostechnologies.crm.application.activities.interfaceclass.ActivityInterface;
import com.kyrostechnologies.crm.application.activities.datatier.ActivityDataTier;
import com.kyrostechnologies.crm.model.ActivityModel;
import com.kyrostechnologies.crm.response.ActivityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ActivityBussinessLogic implements ActivityInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public ActivityResponse getActivityByUserProfileId(int UserProfileId) {
        String query="CALL `UserSettings.Activity_GetAllActivityByUserProfileId`("+UserProfileId+");";
        System.out.println("Query : "+query);
        List<ActivityModel>activityModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new ActivityDataTier());
        if(activityModelList!=null &&activityModelList.size()!=0){
            return getActivityResponse(true,"Success",activityModelList);
        }
        return getActivityResponse(false,"List is emtpty or null",null);
    }

    @Override
    public ActivityResponse getActivityByActivityId(int ActivityId) {
        String query="CALL `UserSettings.Activity_GetActivityByActivityId`("+ActivityId+");";
        System.out.println("Query : "+query);
        List<ActivityModel>activityModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new ActivityDataTier());
        if(activityModelList!=null && activityModelList.size()!=0){
            return getActivityResponse(true,"Success",activityModelList);
        }
        return getActivityResponse(false,"List is empty or null",null);
    }

    @Override
    public ActivityResponse insertActivity(ActivityModel model) {
        String query="CALL `UserSettings.Activity_InsertAcitvity`(?,?,?,?,?)";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            int companyId=model.getCompanyId();
            preparedStatement.setInt(1,companyId);
            int userProfileId=model.getUserProfileId();
            preparedStatement.setInt(2, userProfileId);
            String type=model.getType();
            preparedStatement.setString(3,type);
            String subject=model.getSubject();
            preparedStatement.setString(4,subject);
            int orgId=model.getOrgId();
            preparedStatement.setInt(5,orgId);
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getActivityByUserProfileId(model.getUserProfileId());
        }
        return getActivityResponse(false,"Activity is not inserted",null);
    }

    @Override
    public ActivityResponse updateActivity(ActivityModel model) {
        String query="CALL `UserSettings.Activity_UpdateActivity`(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println("Query : "+query);
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)callableStatement->{
            int userProfileId=model.getUserProfileId();
            boolean done=model.getDone();
            callableStatement.setBoolean(1, done);
            String type=model.getType();
            callableStatement.setString(2, type);
            String referenceType=model.getReferenceType();
            callableStatement.setString(3, referenceType);
            String referenceId=model.getReferenceId();
            callableStatement.setString(4, referenceId);
            String dueDate=model.getDueDate();
            callableStatement.setString(5, dueDate);
            String dueTime=model.getDueTime();
            callableStatement.setString(6, dueTime);
            String duration=model.getDuration();
            callableStatement.setString(7, duration);
            String markedAsDoneTime=model.getMarkedAsDoneTime();
            callableStatement.setString(8, markedAsDoneTime);
            String subject=model.getSubject();
            callableStatement.setString(9, subject);
            int orgId=model.getOrgId();
            callableStatement.setInt(10, orgId);
            int personId=model.getPersonId();
            callableStatement.setInt(11, personId);
            int dealId=model.getDealId();
            callableStatement.setInt(12, dealId);
            boolean activeFlag=model.getActiveFlag();
            callableStatement.setBoolean(13, activeFlag);
            String updateTime=model.getUpdateTime();
            callableStatement.setString(14, updateTime);
            String gCalEventId=model.getGCalEventId();
            callableStatement.setString(15, gCalEventId);
            String googleCalendarId=model.getGoogleCalendarId();
            callableStatement.setString(16, googleCalendarId);
            String googleCalendarETag=model.getGoogleCalendarETag();
            callableStatement.setString(17, googleCalendarETag);
            String note=model.getNote();
            callableStatement.setString(18, note);
            int createdByUserProfileId=model.getCreatedByUserProfileId();
            callableStatement.setInt(19, createdByUserProfileId);
            String participants=model.getParticipants();
            callableStatement.setString(20, participants);
            String orgName=model.getOrgName();
            callableStatement.setString(21, orgName);
            String personName=model.getPersonName();
            callableStatement.setString(22, personName);
            String dealTitle=model.getDealTitle();
            callableStatement.setString(23, dealTitle);
            String ownerName=model.getOwnerName();
            callableStatement.setString(24, ownerName);
            String personDropBoxBcc=model.getPersonDropBoxBcc();
            callableStatement.setString(25, personDropBoxBcc);
            String dealDropBoxBcc=model.getDealDropBoxBcc();
            callableStatement.setString(26, dealDropBoxBcc);
            int assignedToUserProfileId=model.getAssignedToUserProfileId();
            callableStatement.setInt(27, assignedToUserProfileId);
            int activityId=model.getActivityId();
            callableStatement.setInt(28, activityId);

            return callableStatement.executeUpdate();
        });
        if(isUpdated!=0){
            return getActivityByUserProfileId(model.getUserProfileId());
        }
        return getActivityResponse(false,"Acitivity is not updated",null);
    }

    @Override
    public ActivityResponse deleteActivity(ActivityModel model) {
        String query="{CALL `UserSettings.Activity_DeleteActivityByActivityId`(?) }";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1, model.getActivityId());
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return getActivityByUserProfileId(model.getUserProfileId());
        }
        return getActivityResponse(false,"Activity is not deleted",null);
    }
    private ActivityResponse getActivityResponse(boolean value,String message,List<ActivityModel> activityModelList){
        ActivityResponse response=new ActivityResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setActivityList(activityModelList);
        return response;
    }
}
