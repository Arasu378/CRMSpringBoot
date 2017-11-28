package com.kyrostechnologies.crm.application.googlecontacts.bussinesstier;

import com.kyrostechnologies.crm.application.googlecontacts.interfaceclass.GoogleContactsInterface;
import com.kyrostechnologies.crm.application.googlecontacts.datatier.GoogleContactsDataTier;
import com.kyrostechnologies.crm.model.GoogleContactsModel;
import com.kyrostechnologies.crm.response.GoogleContactsResponse;
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
public class GoogleContactsBussinessLogic implements GoogleContactsInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public GoogleContactsResponse getGoogleContactByUserProfileId(int UserProfileId) {
        String query="CALL `UserSettings.GoogleContacts_GetGoogleContactsbyUserProfileId`("+UserProfileId+");";
        System.out.println("Query : "+query);
        List<GoogleContactsModel>googleContactsModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new GoogleContactsDataTier());
        if(googleContactsModelList!=null && googleContactsModelList.size()!=0){
            return getGoogleContactsResponse(true,"Success",googleContactsModelList);
        }
        return getGoogleContactsResponse(false,"List is empty or null",null);
    }

    @Override
    public GoogleContactsResponse getGoogleContactByContactId(int ContactId) {
        String query="CALL `UserSettings.GoogleContacts_GetGoogleContactsbyContactId`("+ContactId+");";
        System.out.println("Query : "+query);
        List<GoogleContactsModel>googleContactsModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new GoogleContactsDataTier());
        if(googleContactsModelList!=null && googleContactsModelList.size()!=0){
            return getGoogleContactsResponse(true,"Success",googleContactsModelList);
        }
        return getGoogleContactsResponse(false,"List is empty or null",null);
    }

    @Override
    public GoogleContactsResponse insertGoogleContacts(GoogleContactsModel model) {
        String query="CALL  `UserSettings.GoogleContacts_InsertGoogleContacts`(?,?,?,?)";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getUserProfileId() );
            preparedStatement.setBoolean(2, model.getIsConnectedToGoogleAccount());
            preparedStatement.setString(3, model.getGoogleAccountEmail());
            preparedStatement.setBoolean(4, model.getIsActive());
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getGoogleContactByUserProfileId(model.getUserProfileId());
        }
        return getGoogleContactsResponse(false,"Google contacts is not inserted",null);
    }

    @Override
    public GoogleContactsResponse updateGoogleContacts(GoogleContactsModel model) {
        String query="CALL `UserSettings.GoogleContacts_UpdateGoogleContacts`(?,?,?,?,?)";
        System.out.println("Query : "+query);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createdDate=dateFormat.format(new Date());
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getContactId() );
            preparedStatement.setBoolean(2, model.getIsConnectedToGoogleAccount());
            preparedStatement.setString(3, model.getGoogleAccountEmail());
            preparedStatement.setBoolean(4, model.getIsActive());
            preparedStatement.setString(5, createdDate);
            return preparedStatement.executeUpdate();
        });
        if(isUpdated!=0){
            return getGoogleContactByUserProfileId(model.getUserProfileId());
        }
        return getGoogleContactsResponse(false,"google contacts is not updated",null);
    }

    @Override
    public GoogleContactsResponse deleteGoogleContacts(GoogleContactsModel model) {
        String query="CALL `UserSettings.GoogleContacts_DeleteGoogleContacts`(?);";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getContactId());
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return getGoogleContactByUserProfileId(model.getUserProfileId());
        }
        return getGoogleContactsResponse(false,"google contact is not deleted",null);
    }
    private GoogleContactsResponse getGoogleContactsResponse(boolean value, String message, List<GoogleContactsModel>googleContactsModelList){
        GoogleContactsResponse response=new GoogleContactsResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setGoogleContactList(googleContactsModelList);
        return response;
    }

}
