package com.kyrostechnologies.crm.application.googlecontacts.datatier;


import com.kyrostechnologies.crm.dbconstants.GoogleContactsDBConstant;
import com.kyrostechnologies.crm.dbconstants.ReminderEmailDBConstants;
import com.kyrostechnologies.crm.model.GoogleContactsModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoogleContactsDataTier implements RowMapper<GoogleContactsModel> {
    @Override
    public GoogleContactsModel mapRow(ResultSet rs, int i) throws SQLException {
        GoogleContactsModel model=new GoogleContactsModel();
        int contactId=rs.getInt(GoogleContactsDBConstant.CONTACT_ID);
        int userProfileId=rs.getInt(GoogleContactsDBConstant.USER_PROFILE_ID);
        String googleAccountEmail=rs.getString(GoogleContactsDBConstant.GOOGLE_ACCOUNT_EMAIL);
        boolean isConnectedToGoogleAccount=rs.getBoolean(GoogleContactsDBConstant.IS_CONNECTED_TO_GOOGLE_ACCOUNT);
        boolean isActive=rs.getBoolean(GoogleContactsDBConstant.IS_ACTIVE);
        String createdDate=rs.getString(GoogleContactsDBConstant.CREATED_DATE);
        model.setContactId(contactId);
        model.setUserProfileId(userProfileId);
        model.setGoogleAccountEmail(googleAccountEmail);
        model.setIsConnectedToGoogleAccount(isConnectedToGoogleAccount);
        model.setIsActive(isActive);
        model.setCreatedDate(createdDate);
        return model;
    }
}
