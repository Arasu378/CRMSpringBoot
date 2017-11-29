package com.kyrostechnologies.crm.application.activitytype.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.activitytype.bussinesstier.ActivityTypeBussinessLogic;
import com.kyrostechnologies.crm.model.ActivityTypeModel;
import com.kyrostechnologies.crm.response.ActivityTypeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ActivityTypeController {
    @Autowired
    private ActivityTypeBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET ,value = APIUtils.ACITIVITY_TYPE)
    public @ResponseBody
    ActivityTypeResponse getActivityType(){
        return bussinessLogic.getActivityType();
    }
    @RequestMapping(method = RequestMethod.GET ,value = APIUtils.ACITIVITY_TYPE_BY_USER_PROFILE_ID)
    public @ResponseBody
    ActivityTypeResponse getActivityTypeByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
        return bussinessLogic.getActivityTypeByUserProfileId(UserProfileId);
    }
    @RequestMapping(method = RequestMethod.POST ,value = APIUtils.ACITIVITY_TYPE)
    public @ResponseBody
    ActivityTypeResponse insertActivityType(@RequestBody ActivityTypeModel model){
        return bussinessLogic.insertActivityType(model);
    }
    @RequestMapping(method = RequestMethod.PUT ,value = APIUtils.ACITIVITY_TYPE)
    public @ResponseBody
    ActivityTypeResponse updateActivityType(@RequestBody ActivityTypeModel model){
        return bussinessLogic.updateActivityType(model);
    }
    @RequestMapping(method = RequestMethod.DELETE ,value = APIUtils.ACITIVITY_TYPE)
    public @ResponseBody
    ActivityTypeResponse deleteActivityType(@RequestBody ActivityTypeModel model){
        return bussinessLogic.deleteActivityType(model);
    }
}
