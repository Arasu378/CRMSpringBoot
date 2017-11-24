package com.kyrostechnologies.crm.application.remindertime.datatier;

import com.kyrostechnologies.crm.dbconstants.ReminderTimeDBConstants;
import com.kyrostechnologies.crm.model.ReminderTimeModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReminderTimeDataTier implements RowMapper<ReminderTimeModel> {
    @Override
    public ReminderTimeModel mapRow(ResultSet rs, int i) throws SQLException {
        ReminderTimeModel model=new ReminderTimeModel();
        int ReminderTimeId=rs.getInt(ReminderTimeDBConstants.REMINDER_TIME_ID);
        model.setReminderTimeId(ReminderTimeId);
        String ReminderTimeName=rs.getString(ReminderTimeDBConstants.REMINDER_TIME_NAME);
        model.setReminderTimeName(ReminderTimeName);
        boolean  IsActive=rs.getBoolean(ReminderTimeDBConstants.IS_ACTIVE);
        model.setIsActive(IsActive);
        String CreatedDate=rs.getString(ReminderTimeDBConstants.CREATED_DATE);
        model.setCreatedDate(CreatedDate);
        String ModifiedDate=rs.getString(ReminderTimeDBConstants.MODIFIED_DATE);
        model.setModifiedDate(ModifiedDate);
        return model;
    }
}
