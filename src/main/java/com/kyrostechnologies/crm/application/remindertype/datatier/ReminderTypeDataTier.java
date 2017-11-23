package com.kyrostechnologies.crm.application.remindertype.datatier;

import com.kyrostechnologies.crm.dbconstants.ReminderTypeDBConstants;
import com.kyrostechnologies.crm.model.ReminderTypeModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReminderTypeDataTier implements RowMapper<ReminderTypeModel> {
    @Override
    public ReminderTypeModel mapRow(ResultSet rs, int i) throws SQLException {
        ReminderTypeModel model=new ReminderTypeModel();
        int ReminderTypeId=rs.getInt(ReminderTypeDBConstants.REMINDER_TYPE_ID);
        model.setReminderTypeId(ReminderTypeId);
        String ReminderTypeName=rs.getString(ReminderTypeDBConstants.REMINDER_TYPE_NAME);
        model.setReminderTypeName(ReminderTypeName);
        boolean IsActive=rs.getBoolean(ReminderTypeDBConstants.IS_ACTIVE);
        model.setIsActive(IsActive);
        String CreatedDate=rs.getString(ReminderTypeDBConstants.CREATED_DATE);
        model.setCreatedDate(CreatedDate);
        String ModifiedDate=rs.getString(ReminderTypeDBConstants.MODIFIED_DATE);
        model.setModifiedDate(ModifiedDate);
        return model;
    }
}
