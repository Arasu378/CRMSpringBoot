package com.kyrostechnologies.crm.application.connections.datatier;

import com.kyrostechnologies.crm.dbconstants.ConnectionsDBConstants;
import com.kyrostechnologies.crm.model.ConnectionsModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionsDataTier implements RowMapper<ConnectionsModel> {
    @Override
    public ConnectionsModel mapRow(ResultSet rs, int i) throws SQLException {
        ConnectionsModel model=new ConnectionsModel();
        int connectionId=rs.getInt(ConnectionsDBConstants.CONNECTION_ID);
        int userProfileId=rs.getInt(ConnectionsDBConstants.USER_PROFILE_ID);
        boolean isConnectedToGoogleAccount=rs.getBoolean(ConnectionsDBConstants.IS_CONNECTED_TO_GOOGLE_ACCOUNT);
        boolean isConnectedToMailChimpAccount=rs.getBoolean(ConnectionsDBConstants.IS_CONNECTED_TO_MAIL_CHIMP_ACCOUNT);
        String googleAccountEmail=rs.getString(ConnectionsDBConstants.GOOGLE_ACCOUNT_EMAIL);
        String mailChimpAccountEmail=rs.getString(ConnectionsDBConstants.MAIL_CHIMP_ACCOUNT_EMAIL);
        boolean isActive=rs.getBoolean(ConnectionsDBConstants.IS_ACTIVE);
        String createdDate=rs.getString(ConnectionsDBConstants.CREATED_DATE);
        String modifiedDate=rs.getString(ConnectionsDBConstants.MODIFIED_DATE);
        model.setConnectionId(connectionId);
        model.setUserProfileId(userProfileId);
        model.setIsConnectedToGoogleAccount(isConnectedToGoogleAccount);
        model.setIsConnectedToMailChimpAccount(isConnectedToMailChimpAccount);
        model.setGoogleAccountEmail(googleAccountEmail);
        model.setMailChimpAccountEmail(mailChimpAccountEmail);
        model.setIsActive(isActive);
        model.setCreatedDate(createdDate);
        model.setModifiedDate(modifiedDate);

        return model;
    }
}
