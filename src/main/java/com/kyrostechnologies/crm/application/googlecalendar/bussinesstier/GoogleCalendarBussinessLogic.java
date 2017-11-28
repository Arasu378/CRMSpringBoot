package com.kyrostechnologies.crm.application.googlecalendar.bussinesstier;

import com.kyrostechnologies.crm.application.googlecalendar.interfaceclass.GoogleCalendarInterface;
import com.kyrostechnologies.crm.application.googlecalendar.datatier.GoogleCalendarDataTier;
import com.kyrostechnologies.crm.model.GoogleCalanderModel;
import com.kyrostechnologies.crm.response.GoogleCalanderResponse;
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
public class GoogleCalendarBussinessLogic implements GoogleCalendarInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public GoogleCalanderResponse getGoogleCalendarByUserProfileId(int UserProfileId) {
        String query="CALL `UsersSettings.GoogleCalendar_GetGoogleCalendarbyUserProfileId`("+UserProfileId+");";
        System.out.println("Query : "+query);
        List<GoogleCalanderModel>googleCalanderModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new GoogleCalendarDataTier());
        if(googleCalanderModelList!=null &&googleCalanderModelList.size()!=0){
            return getGoogleCalanderResponse(true,"Success",googleCalanderModelList);
        }
        return getGoogleCalanderResponse(false,"List is empty or null",null);
    }

    @Override
    public GoogleCalanderResponse getGoogleCalendarByConnectionId(int ConnectionId) {
        String query="CALL  `UsersSettings.GoogleCalendar_GetGoogleCalendarbyConnectionId`("+ConnectionId+");";
        System.out.println("Query : "+query);
        List<GoogleCalanderModel>googleCalanderModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new GoogleCalendarDataTier());
        if(googleCalanderModelList!=null &&googleCalanderModelList.size()!=0){
            return getGoogleCalanderResponse(true,"Success",googleCalanderModelList);
        }
        return getGoogleCalanderResponse(false,"List is empty or null",null);
    }

    @Override
    public GoogleCalanderResponse insertGoogleCalendar(GoogleCalanderModel model) {
        String query="CALL  `UserSettings.GoogleCalendar_InsertGoogleCalendar`(?,?,?,?)";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1, model.getUserProfileId());
            preparedStatement.setBoolean(2, model.getIsConnectedToGoogleAccount());
            preparedStatement.setString(3,model.getGoogleAccountEmail() );
            preparedStatement.setBoolean(4, model.getIsActive());
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getGoogleCalendarByUserProfileId(model.getUserProfileId());
        }
        return getGoogleCalanderResponse(false,"GoogleCalendar is not inserted",null);
    }

    @Override
    public GoogleCalanderResponse updateGoogleCalendar(GoogleCalanderModel model) {
        String query="CALL   `UserSettings.GoogleCalendar_UpdateGoogleCalendar`(?,?,?,?,?)";
        System.out.println("Query : "+query);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createdDate=dateFormat.format(new Date());
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getConnectionId() );
            preparedStatement.setBoolean(2, model.getIsConnectedToGoogleAccount());
            preparedStatement.setString(3, model.getGoogleAccountEmail());
            preparedStatement.setBoolean(4, model.getIsActive());
            preparedStatement.setString(5, createdDate);
            return preparedStatement.executeUpdate();
        });
        if(isUpdated!=0){
            return getGoogleCalendarByUserProfileId(model.getUserProfileId());
        }
        return getGoogleCalanderResponse(false,"google calendar is not updated",null);
    }

    @Override
    public GoogleCalanderResponse deleteGoogleCalendar(GoogleCalanderModel model) {
        String query="CALL `UserSettings.GoogleCalendar_DeleteGoogleCalendar`(?);";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getConnectionId());
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return getGoogleCalendarByUserProfileId(model.getUserProfileId());
        }
        return getGoogleCalanderResponse(false,"google calendar is not deleted",null);
    }
    private GoogleCalanderResponse getGoogleCalanderResponse(boolean value,String message,List<GoogleCalanderModel> googleCalanderModelList){
        GoogleCalanderResponse response=new GoogleCalanderResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setGoogleCalanderList(googleCalanderModelList);
        return response;
    }
}
