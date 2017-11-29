package com.kyrostechnologies.crm.application.activitytype.datatier;

import com.kyrostechnologies.crm.dbconstants.ActivityTypeDBConstants;
import com.kyrostechnologies.crm.model.ActivityTypeModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityTypeDataTier implements RowMapper<ActivityTypeModel> {
    @Override
    public ActivityTypeModel mapRow(ResultSet rs, int i) throws SQLException {
        ActivityTypeModel model=new ActivityTypeModel();
        int activityTypeId=rs.getInt(ActivityTypeDBConstants.ACTIVITY_TYPE_ID);
        model.setActivityTypeId(activityTypeId);
        int orderNr=rs.getInt(ActivityTypeDBConstants.ORDER_NR);
        model.setOrderNr(orderNr);
        String name=rs.getString(ActivityTypeDBConstants.NAME);
        model.setName(name);
        String keyString=rs.getString(ActivityTypeDBConstants.KEY_STRING);
        model.setKeyString(keyString);
        String iconKey=rs.getString(ActivityTypeDBConstants.ICON_KEY);
        model.setIconKey(iconKey);
        boolean activeFlag=rs.getBoolean(ActivityTypeDBConstants.ACTIVE_FLAG);
        model.setActiveFlag(activeFlag);
        String color=rs.getString(ActivityTypeDBConstants.COLOR);
        model.setColor(color);
        boolean isCustomFlag=rs.getBoolean(ActivityTypeDBConstants.IS_CUSTOM_FLAG);
        model.setIsCustomFlag(isCustomFlag);
        String dateCreated=rs.getString(ActivityTypeDBConstants.DATE_CREATED);
        model.setDateCreated(dateCreated);
        String dateModified=rs.getString(ActivityTypeDBConstants.DATE_MODIFIED);
        model.setDateModified(dateModified);
        int userProfileId=rs.getInt(ActivityTypeDBConstants.USER_PROFILE_ID);
        model.setUserProfileId(userProfileId);
        return model;
    }
}
