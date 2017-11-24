package com.kyrostechnologies.crm.application.reminderemail.datatier;

import com.kyrostechnologies.crm.dbconstants.ReminderEmailDBConstants;
import com.kyrostechnologies.crm.model.ReminderEmailModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReminderEmailDataTier implements RowMapper<ReminderEmailModel> {
    @Override
    public ReminderEmailModel mapRow(ResultSet rs, int i) throws SQLException {
        ReminderEmailModel model=new ReminderEmailModel();
        int reminderEmailId=rs.getInt(ReminderEmailDBConstants.REMINDER_EMAIL_ID);
        int userProfileId=rs.getInt(ReminderEmailDBConstants.USER_PROFILE_ID);
        String reminderTypeId=rs.getString(ReminderEmailDBConstants.REMINDER_TYPE_ID);
        String reminderTimeId=rs.getString(ReminderEmailDBConstants.REMINDER_TIME_ID);
        boolean isActive=rs.getBoolean(ReminderEmailDBConstants.IS_ACTIVE);
        String createdDate=rs.getString(ReminderEmailDBConstants.CREATED_DATE);
        String modifiedDate=rs.getString(ReminderEmailDBConstants.MODIFIED_DATE);
        model.setReminderEmailId(reminderEmailId);
        model.setUserProfileId(userProfileId);
        model.setReminderTypeId(reminderTypeId);
        model.setReminderTimeId(reminderTimeId);
        model.setIsActive(isActive);
        model.setCreatedDate(createdDate);
        model.setModifiedDate(modifiedDate);
        return model;
    }
}
