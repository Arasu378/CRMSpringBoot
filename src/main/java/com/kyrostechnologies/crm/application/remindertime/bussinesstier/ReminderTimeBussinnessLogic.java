package com.kyrostechnologies.crm.application.remindertime.bussinesstier;

import com.kyrostechnologies.crm.application.remindertime.interfaceclass.ReminderTimeInterface;
import com.kyrostechnologies.crm.application.remindertime.datatier.ReminderTimeDataTier;
import com.kyrostechnologies.crm.model.ReminderTimeModel;
import com.kyrostechnologies.crm.response.ReminderTimeResponse;
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
public class ReminderTimeBussinnessLogic implements ReminderTimeInterface{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)throws DataAccessException{
        this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
    }
    @Override
    public ReminderTimeResponse getReminderTime() {
        String query="CALL `Settings.ReminderTime_GetReminderTime`();";
        System.out.println("Query : "+query);
        List<ReminderTimeModel>reminderTimeModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new ReminderTimeDataTier());
        if(reminderTimeModelList!=null &&reminderTimeModelList.size()!=0){
            return getReminderTimeResponse(true,"Success",reminderTimeModelList);
        }
       return getReminderTimeResponse(false,"Lis empty or null",null);
    }

    @Override
    public ReminderTimeResponse insertReminderTime(ReminderTimeModel model) {
        String query="CALL `Settings.ReminderTime_InsertReminderTime`(?);";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            int value;
            preparedStatement.setString(1,model.getReminderTimeName() );
            value=preparedStatement.executeUpdate();
            return value;
        });
        if(isInserted!=0){
            return getReminderTime();
        }
        return getReminderTimeResponse(false,"ReminderTime is not inserted",null);
    }

    @Override
    public ReminderTimeResponse updateReminderTime(ReminderTimeModel model) {
        String query="CALL  `Settings.ReminderTime_UpdateReminderTime`(?,?,?,?);";
        System.out.println("Query : "+query);
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            int value;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String modifiedDate=dateFormat.format(date);
            preparedStatement.setInt(1,model.getReminderTimeId() );
            preparedStatement.setString(2, model.getReminderTimeName());
            preparedStatement.setBoolean(3, model.getIsActive());
            preparedStatement.setString(4, modifiedDate);
            value=preparedStatement.executeUpdate();
            return value;
        });
        if(isUpdated!=0){
            return getReminderTime();
        }
        return getReminderTimeResponse(false,"remindertime is not updated",null);
    }

    @Override
    public ReminderTimeResponse deleteReminderTime(ReminderTimeModel model) {
        String query="CALL  `Settings.ReminderTime_DeleteReminderTime` (?);";
        System.out.println("Query : "+query);
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            int value;
            preparedStatement.setInt(1,model.getReminderTimeId());
            value=preparedStatement.executeUpdate();
            return value;
        });
        if(isUpdated!=0){
            return getReminderTime();
        }
        return getReminderTimeResponse(false,"Reminder time is not updated",null);
    }
    private ReminderTimeResponse getReminderTimeResponse(boolean value,String message,List<ReminderTimeModel>reminderTimeModelList){
        ReminderTimeResponse response=new ReminderTimeResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setReminderTime(reminderTimeModelList);
        return response;
    }
}
