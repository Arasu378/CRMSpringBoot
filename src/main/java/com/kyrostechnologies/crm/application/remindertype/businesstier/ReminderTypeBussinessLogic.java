package com.kyrostechnologies.crm.application.remindertype.businesstier;

import com.kyrostechnologies.crm.application.remindertype.interfaceclass.ReminderTypeInterface;
import com.kyrostechnologies.crm.application.remindertype.datatier.ReminderTypeDataTier;
import com.kyrostechnologies.crm.model.ReminderTypeModel;
import com.kyrostechnologies.crm.response.ReminderTypeResponse;
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
public class ReminderTypeBussinessLogic implements ReminderTypeInterface {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public ReminderTypeResponse getReminderType() {
        String query="CALL  `Settings.ReminderType_GetReminderType`();";
        System.out.println("Query : "+query);
        List<ReminderTypeModel>reminderTypeModelList= namedParameterJdbcTemplate.query(query, new MapSqlParameterSource(),new ReminderTypeDataTier());
         if(reminderTypeModelList!=null && reminderTypeModelList.size()!=0){
            return getReminderTypeResponse(true,"Success",reminderTypeModelList);
        }
            return getReminderTypeResponse(false,"list size is zero or null!",null);



    }

    @Override
    public ReminderTypeResponse insertReminderType(ReminderTypeModel model) {
        String query="CALL `Settings.ReminderType_InsertReminderType`(?);";
        System.out.println("Query : "+query);
        int isInserted=   jdbcTemplate.execute(query, (PreparedStatementCallback<Integer>) preparedStatement -> {
            int value;
            preparedStatement.setString(1,model.getReminderTypeName());
            value= preparedStatement.executeUpdate();
            return value;
        });
        if(isInserted==1){
            return getReminderType();
        }
            return getReminderTypeResponse(false,"Reminder Type is not inserted",null);


    }

    @Override
    public ReminderTypeResponse updateReminderType(ReminderTypeModel model) {
        String query="CALL `Settings.ReminderType_UpdateReminderType`(?,?,?,?);";
        System.out.println("Query : "+query);
        int isUpdated= jdbcTemplate.execute(query, (PreparedStatementCallback<Integer>) preparedStatement -> {
            int value;
            Date date=new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String modifiedDate=dateFormat.format(date);
            preparedStatement.setInt(1,model.getReminderTypeId());
            preparedStatement.setString(2,model.getReminderTypeName());
            preparedStatement.setBoolean(3,model.getIsActive());
            preparedStatement.setString(4,modifiedDate);
            value= preparedStatement.executeUpdate();
            return value;
        });
        if(isUpdated==1){
            return getReminderType();
        }
            return getReminderTypeResponse(false,"Reminder Type is not updated",null);


    }

    @Override
    public ReminderTypeResponse deleteReminderType(ReminderTypeModel model) {
        String query="CALL `Settings.Remindertype_DeleteReminderType`(?);";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            int value;
            preparedStatement.setInt(1,model.getReminderTypeId());
            value=preparedStatement.executeUpdate();
            return value;
        });
        if(isDeleted==1){
            return getReminderType();
        }
            return getReminderTypeResponse(false,"Reminder Type is not Deleted",null);

    }
    private ReminderTypeResponse getReminderTypeResponse(boolean success, String message, List<ReminderTypeModel> reminderTypeModelList){
        ReminderTypeResponse response=new ReminderTypeResponse();
        response.setIsSuccess(success);
        response.setMessage(message);
        response.setReminderTye(reminderTypeModelList);
        return response;
    }
}
