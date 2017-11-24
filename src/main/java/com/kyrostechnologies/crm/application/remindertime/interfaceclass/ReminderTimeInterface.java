package com.kyrostechnologies.crm.application.remindertime.interfaceclass;

import com.kyrostechnologies.crm.model.ReminderTimeModel;
import com.kyrostechnologies.crm.response.ReminderTimeResponse;

public interface ReminderTimeInterface {
    ReminderTimeResponse getReminderTime();
    ReminderTimeResponse insertReminderTime(ReminderTimeModel model);
    ReminderTimeResponse updateReminderTime(ReminderTimeModel model);
    ReminderTimeResponse deleteReminderTime(ReminderTimeModel model);

}
