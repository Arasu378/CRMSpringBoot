package com.kyrostechnologies.crm.application.activitytype.interfaceclass;

import com.kyrostechnologies.crm.model.ActivityTypeModel;
import com.kyrostechnologies.crm.response.ActivityTypeResponse;

public interface ActivityTypeInterface {
    ActivityTypeResponse getActivityType();
    ActivityTypeResponse insertActivityType(ActivityTypeModel model);
    ActivityTypeResponse updateActivityType(ActivityTypeModel model);
    ActivityTypeResponse deleteActivityType(ActivityTypeModel model);
    ActivityTypeResponse getActivityTypeByUserProfileId(int UserProfileId);

}
