package com.kyrostechnologies.crm.application.remindertype.interfaceclass;

import com.kyrostechnologies.crm.model.ReminderTypeModel;
import com.kyrostechnologies.crm.response.ReminderTypeResponse;

public interface ReminderTypeInterface {
    ReminderTypeResponse getReminderType();
    ReminderTypeResponse insertReminderType(ReminderTypeModel model);
    ReminderTypeResponse updateReminderType(ReminderTypeModel model);
    ReminderTypeResponse deleteReminderType(ReminderTypeModel model);
}
