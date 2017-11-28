package com.kyrostechnologies.crm.application.googlecalendar.datatier;

import com.kyrostechnologies.crm.dbconstants.GoogleCalanderDBConstants;
import com.kyrostechnologies.crm.model.GoogleCalanderModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoogleCalendarDataTier implements RowMapper<GoogleCalanderModel> {
    @Override
    public GoogleCalanderModel mapRow(ResultSet rs, int i) throws SQLException {
        GoogleCalanderModel model=new GoogleCalanderModel();
        int connectionId=rs.getInt(GoogleCalanderDBConstants.CONNECTION_ID);
        int userProfileId=rs.getInt(GoogleCalanderDBConstants.USER_PROFILE_ID);
        boolean isConnectedToGoogleAccount=rs.getBoolean(GoogleCalanderDBConstants.IS_CONNECTED_TO_GOOGLE_ACCOUNT);
        boolean isActive=rs.getBoolean(GoogleCalanderDBConstants.IS_ACTIVE);
        String googleAccountEmail=rs.getString(GoogleCalanderDBConstants.GOOGLE_ACCOUNT_EMAIL);
        String createdDate=rs.getString(GoogleCalanderDBConstants.CREATED_DATE);
        model.setConnectionId(connectionId);
        model.setUserProfileId(userProfileId);
        model.setIsConnectedToGoogleAccount(isConnectedToGoogleAccount);
        model.setIsActive(isActive);
        model.setGoogleAccountEmail(googleAccountEmail);
        model.setCreatedDate(createdDate);
        return model;
    }
}
