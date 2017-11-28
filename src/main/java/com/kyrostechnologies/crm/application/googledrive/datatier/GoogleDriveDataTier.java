package com.kyrostechnologies.crm.application.googledrive.datatier;

import com.kyrostechnologies.crm.dbconstants.GoogleDriveDBConstants;
import com.kyrostechnologies.crm.model.GoogleDriveModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoogleDriveDataTier implements RowMapper<GoogleDriveModel> {
    @Override
    public GoogleDriveModel mapRow(ResultSet rs, int i) throws SQLException {
        GoogleDriveModel model=new GoogleDriveModel();
        int driveId=rs.getInt(GoogleDriveDBConstants.DRIVE_ID);
        int userProfileId=rs.getInt(GoogleDriveDBConstants.USER_PROFILE_ID);
        boolean isConnectedToGoogleAccount=rs.getBoolean(GoogleDriveDBConstants.IS_CONNECTED_TO_GOOGLE_ACCOUNT);
        String googleAccountEmail=rs.getString(GoogleDriveDBConstants.GOOGLE_ACCOUNT_EMAIL);
        if(googleAccountEmail==null){
            googleAccountEmail="";
        }
        boolean isActive=rs.getBoolean(GoogleDriveDBConstants.IS_ACTIVE);
        String createdDate=rs.getString(GoogleDriveDBConstants.CREATED_DATE);
        if(createdDate==null){
            createdDate="";
        }
        model.setDriveId(driveId);
        model.setUserProfileId(userProfileId);
        model.setIsConnectedToGoogleAccount(isConnectedToGoogleAccount);
        model.setGoogleAccountEmail(googleAccountEmail);
        model.setIsActive(isActive);
        model.setCreatedDate(createdDate);
        return model;
    }
}
