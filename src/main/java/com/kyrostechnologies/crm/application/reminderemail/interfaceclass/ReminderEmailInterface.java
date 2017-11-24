package com.kyrostechnologies.crm.application.reminderemail.interfaceclass;

import com.kyrostechnologies.crm.model.ReminderEmailModel;
import com.kyrostechnologies.crm.response.ReminderEmailResponse;

public interface ReminderEmailInterface {
    ReminderEmailResponse getReminderEmailByUserProfileId(int UserProfileId);
    ReminderEmailResponse getReminderEmailByReminderEmailId(int ReminderEmailId);
    ReminderEmailResponse insertReminderEmail(ReminderEmailModel model);
    ReminderEmailResponse updateReminderEmail(ReminderEmailModel model);
    ReminderEmailResponse deleteReminderEmail(ReminderEmailModel model);
}
