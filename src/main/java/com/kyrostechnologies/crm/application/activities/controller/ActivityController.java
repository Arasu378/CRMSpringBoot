package com.kyrostechnologies.crm.application.activities.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.activities.bussinesstier.ActivityBussinessLogic;
import com.kyrostechnologies.crm.model.ActivityModel;
import com.kyrostechnologies.crm.response.ActivityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ActivityController {
    @Autowired
    private ActivityBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET, value = APIUtils.ACTIVITY_BY_USER_PROFILE_ID)
    public @ResponseBody
    ActivityResponse getActivityByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
        return bussinessLogic.getActivityByUserProfileId(UserProfileId);
    }
    @RequestMapping(method = RequestMethod.GET, value = APIUtils.ACTIVITY_BY_ACTIVITY_ID)
    public @ResponseBody
    ActivityResponse getActivityByActivityId(@PathVariable("ActivityId")int ActivityId){
        return bussinessLogic.getActivityByActivityId(ActivityId);
    }
    @RequestMapping(method = RequestMethod.POST, value = APIUtils.ACTIVITY)
    public @ResponseBody
    ActivityResponse insertActivity(@RequestBody ActivityModel model){
        return bussinessLogic.insertActivity(model);
    }
    @RequestMapping(method = RequestMethod.PUT, value = APIUtils.ACTIVITY)
    public @ResponseBody
    ActivityResponse updateActivity(@RequestBody ActivityModel model){
        return bussinessLogic.updateActivity(model);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = APIUtils.ACTIVITY)
    public @ResponseBody
    ActivityResponse deleteActivity(@RequestBody ActivityModel model){
        return bussinessLogic.deleteActivity(model);
    }
}
