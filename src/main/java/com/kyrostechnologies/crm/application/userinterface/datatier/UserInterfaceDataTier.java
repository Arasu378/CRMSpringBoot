package com.kyrostechnologies.crm.application.userinterface.datatier;

import com.kyrostechnologies.crm.dbconstants.UserInterfaceDBConstants;
import com.kyrostechnologies.crm.model.UserInterfaceModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInterfaceDataTier implements RowMapper<UserInterfaceModel> {
    @Override
    public UserInterfaceModel mapRow(ResultSet rs, int i) throws SQLException {
        UserInterfaceModel model=new UserInterfaceModel();
        int userInterfaceId=rs.getInt(UserInterfaceDBConstants.USER_INTERFACE_ID);
        int userProfileId=rs.getInt(UserInterfaceDBConstants.USER_PROFILE_ID);
        boolean isDeal=rs.getBoolean(UserInterfaceDBConstants.IS_DEAL);
        boolean isPerson=rs.getBoolean(UserInterfaceDBConstants.IS_PERSON);
        boolean isOrganization=rs.getBoolean(UserInterfaceDBConstants.IS_ORGANIZATION);
        boolean isActive=rs.getBoolean(UserInterfaceDBConstants.IS_ACTIVE);
        String createdDate=rs.getString(UserInterfaceDBConstants.CREATED_DATE);
        String modifiedDate=rs.getString(UserInterfaceDBConstants.MODIFIED_DATE);
        model.setUserInterfaceId(userInterfaceId);
        model.setUserProfileId(userProfileId);
        model.setIsDeal(isDeal);
        model.setIsPerson(isPerson);
        model.setIsOrganization(isOrganization);
        model.setIsActive(isActive);
        model.setCreatedDate(createdDate);
        model.setModifiedDate(modifiedDate);
        return model;
    }
}
