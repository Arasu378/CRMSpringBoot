package com.kyrostechnologies.crm.application.reminderemail.bussinesstier;

import com.kyrostechnologies.crm.application.reminderemail.interfaceclass.ReminderEmailInterface;
import com.kyrostechnologies.crm.application.reminderemail.datatier.ReminderEmailDataTier;
import com.kyrostechnologies.crm.model.ReminderEmailModel;
import com.kyrostechnologies.crm.response.ReminderEmailResponse;
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
public class ReminderEmailBussinessLogic implements ReminderEmailInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public ReminderEmailResponse getReminderEmailByUserProfileId(int UserProfileId) {
        String query="CALL `UserSettings.ReminderEmails_GetReminderEmailsbyUserProfileId`("+ UserProfileId+")";
        System.out.println("Query : "+query);
        List<ReminderEmailModel>reminderEmailModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new ReminderEmailDataTier());
        if(reminderEmailModelList!=null&&reminderEmailModelList.size()!=0){
            return getReminderEmailResponse(true,"Success",reminderEmailModelList);
        }
        return getReminderEmailResponse(false,"List is empty or null",null);
    }

    @Override
    public ReminderEmailResponse getReminderEmailByReminderEmailId(int ReminderEmailId) {
        String query="CALL `UserSettings.ReminderEmails_GetReminderEmailsbyreminderemailid`("+ ReminderEmailId+")";
        System.out.println("Query : "+query);
        List<ReminderEmailModel>reminderEmailModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new ReminderEmailDataTier());
        if(reminderEmailModelList!=null&&reminderEmailModelList.size()!=0){
            return getReminderEmailResponse(true,"Success",reminderEmailModelList);
        }
        return getReminderEmailResponse(false,"List is empty or null",null);
    }

    @Override
    public ReminderEmailResponse insertReminderEmail(ReminderEmailModel model) {
        String query="CALL `UserSettings.ReminderEmail_InsertReminderEmail`(?,?,?,?);";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getUserProfileId() );
            preparedStatement.setString(2,model.getReminderTypeId() );
            preparedStatement.setString(3,model.getReminderTimeId() );
            preparedStatement.setBoolean(4,model.getIsActive() );
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getReminderEmailByUserProfileId(model.getUserProfileId());
        }
        return getReminderEmailResponse(false,"Reminder email is not inserted",null);
    }

    @Override
    public ReminderEmailResponse updateReminderEmail(ReminderEmailModel model) {
        String query="CALL `UserSettings.ReminderEmails._UpdateReminderEmail`(?,?,?,?,?);";
        System.out.println("Query : "+query);
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String modifiedDate=dateFormat.format(new Date());
            preparedStatement.setInt(1,model.getReminderEmailId() );
            preparedStatement.setString(2, model.getReminderTypeId());
            preparedStatement.setString(3, model.getReminderTimeId());
            preparedStatement.setBoolean(4, model.getIsActive());
            preparedStatement.setString(5, modifiedDate);
            return preparedStatement.executeUpdate();
        });
        if(isUpdated!=0){
            return getReminderEmailByUserProfileId(model.getUserProfileId());
        }
        return getReminderEmailResponse(false,"Reminder email is not updated",null);
    }

    @Override
    public ReminderEmailResponse deleteReminderEmail(ReminderEmailModel model) {
        String query="CALL `UserSettings.ReminderEmails_DeleteReminderEmail`(?);";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getReminderEmailId() );
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return getReminderEmailByUserProfileId(model.getUserProfileId());
        }
        return getReminderEmailResponse(false,"Reminder email is not deleted",null);
    }
    private ReminderEmailResponse getReminderEmailResponse(boolean value,String message,List<ReminderEmailModel>reminderEmailModelList){
        ReminderEmailResponse response=new ReminderEmailResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setReminderEmailList(reminderEmailModelList);
        return response;
    }
}
