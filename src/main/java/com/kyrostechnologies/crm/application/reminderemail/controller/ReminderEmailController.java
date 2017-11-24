package com.kyrostechnologies.crm.application.reminderemail.controller;

import com.kyrostechnologies.crm.application.reminderemail.bussinesstier.ReminderEmailBussinessLogic;
import com.kyrostechnologies.crm.model.ReminderEmailModel;
import com.kyrostechnologies.crm.response.ReminderEmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReminderEmailController {
    @Autowired
    private ReminderEmailBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value = "/reminderEmailByUserProfileId/{UserProfileId}")
    public @ResponseBody
    ReminderEmailResponse getReminderEmailByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
        return bussinessLogic.getReminderEmailByUserProfileId(UserProfileId);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/reminderEmailByReminderEmailId/{ReminderEmailId}")
    public @ResponseBody
    ReminderEmailResponse getReminderEmailByReminderEmailId(@PathVariable("ReminderEmailId")int ReminderEmailId){
        return bussinessLogic.getReminderEmailByReminderEmailId(ReminderEmailId);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/reminderEmail")
    public @ResponseBody
    ReminderEmailResponse insertReminderEmail(@RequestBody ReminderEmailModel model){
        return bussinessLogic.insertReminderEmail(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/reminderEmail")
    public @ResponseBody
    ReminderEmailResponse updateReminderEmail(@RequestBody ReminderEmailModel model){
        return bussinessLogic.updateReminderEmail(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/reminderEmail")
    public @ResponseBody
    ReminderEmailResponse deleteReminderEmail(@RequestBody ReminderEmailModel model){
        return bussinessLogic.deleteReminderEmail(model);
    }
}
