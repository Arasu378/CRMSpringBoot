package com.kyrostechnologies.crm.application.googledrive.bussinesstier;

import com.kyrostechnologies.crm.application.googledrive.interfaceclass.GoogleDriveInterface;
import com.kyrostechnologies.crm.application.googledrive.datatier.GoogleDriveDataTier;
import com.kyrostechnologies.crm.model.GoogleDriveModel;
import com.kyrostechnologies.crm.response.GoogleDriveResponse;
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
public class GoogleDriveBussinessLogic implements GoogleDriveInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public GoogleDriveResponse getGoogleDriveByDriveId(int GoogleDriveId) {
        String query="CALL `UserSettings.GoogleDrive_GetGoogleDriveByDriveId`("+GoogleDriveId+");";
        System.out.println("Query : "+query);
        List<GoogleDriveModel>googleDriveModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new GoogleDriveDataTier());
        if(googleDriveModelList!=null && googleDriveModelList.size()!=0){
            return getGoogleDriveResponse(true,"Success",googleDriveModelList);
        }
        return getGoogleDriveResponse(false,"List is empty or null",null);
    }

    @Override
    public GoogleDriveResponse insertGoogleDrive(GoogleDriveModel model) {
        String query="CALL `UserSettings.GoogleDrive_InsertGoogleDrive`(?,?,?,?)";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getUserProfileId() );
            preparedStatement.setBoolean(2, model.getIsConnectedToGoogleAccount());
            preparedStatement.setString(3, model.getGoogleAccountEmail());
            preparedStatement.setBoolean(4, model.getIsActive());
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getGoogleDriveByDriveId(model.getDriveId());
        }
        return getGoogleDriveResponse(false,"google drive is not inserted",null);
    }

    @Override
    public GoogleDriveResponse updateGoogleDrive(GoogleDriveModel model) {
        String query="CALL  `UserSettings.GoogleDrive_UpdateGoogleDrive`(?,?,?,?,?)";
        System.out.println("Query : "+query);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ModifiedDate=dateFormat.format(new Date());
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getDriveId() );
            preparedStatement.setBoolean(2, model.getIsConnectedToGoogleAccount());
            preparedStatement.setString(3, model.getGoogleAccountEmail());
            preparedStatement.setBoolean(4, model.getIsActive());
            preparedStatement.setString(5, ModifiedDate);
            return preparedStatement.executeUpdate();
        });
        if(isUpdated!=0){
            return getGoogleDriveByDriveId(model.getDriveId());
        }
        return getGoogleDriveResponse(false,"google drive is not inserted",null);
    }

    @Override
    public GoogleDriveResponse deleteGoogleDrive(GoogleDriveModel model) {
        String query="CALL `UserSettings.GoogleDrive_DeleteGoogleDrive`(?);";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getDriveId());
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return getGoogleDriveByDriveId(model.getDriveId());
        }
        return getGoogleDriveResponse(false,"Google drive is not deleted",null);
    }
    private GoogleDriveResponse getGoogleDriveResponse(boolean value, String message, List<GoogleDriveModel>googleDriveModelList){
        GoogleDriveResponse response=new GoogleDriveResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setGoogleDriveList(googleDriveModelList);
        return response;
    }
}
