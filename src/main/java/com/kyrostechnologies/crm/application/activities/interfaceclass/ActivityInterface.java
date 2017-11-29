package com.kyrostechnologies.crm.application.activities.interfaceclass;

import com.kyrostechnologies.crm.model.ActivityModel;
import com.kyrostechnologies.crm.response.ActivityResponse;

public interface ActivityInterface {
    ActivityResponse getActivityByUserProfileId(int UserProfileId);
    ActivityResponse getActivityByActivityId(int ActivityId);
    ActivityResponse insertActivity(ActivityModel model);
    ActivityResponse updateActivity(ActivityModel model);
    ActivityResponse deleteActivity(ActivityModel model);
}
