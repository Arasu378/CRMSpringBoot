package com.kyrostechnologies.crm.application.remindertype.controller;

import com.kyrostechnologies.crm.application.remindertype.businesstier.ReminderTypeBussinessLogic;
import com.kyrostechnologies.crm.model.ReminderTypeModel;
import com.kyrostechnologies.crm.response.LanguageResponse;
import com.kyrostechnologies.crm.response.ReminderTypeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReminderTypeController {
    @Autowired
    private ReminderTypeBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value="/reminderType")
    public @ResponseBody
    ReminderTypeResponse getReminderType(){
        return bussinessLogic.getReminderType();
    }
    @RequestMapping(method = RequestMethod.POST,value="/reminderType")
    public @ResponseBody
    ReminderTypeResponse insertReminderType(@RequestBody ReminderTypeModel model){
        return bussinessLogic.insertReminderType(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value="/reminderType")
    public @ResponseBody
    ReminderTypeResponse updateReminderType(@RequestBody ReminderTypeModel model){
        return bussinessLogic.updateReminderType(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value="/reminderType")
    public @ResponseBody
    ReminderTypeResponse deleteReminderType(@RequestBody ReminderTypeModel model){
        return bussinessLogic.deleteReminderType(model);
    }
}
