package com.kyrostechnologies.crm.application.remindertime.controller;

import com.kyrostechnologies.crm.application.remindertime.bussinesstier.ReminderTimeBussinnessLogic;
import com.kyrostechnologies.crm.model.ReminderTimeModel;
import com.kyrostechnologies.crm.response.ReminderTimeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReminderTimeController {
    @Autowired
    private ReminderTimeBussinnessLogic bussinnessLogic;
    @RequestMapping(method = RequestMethod.GET,value = "/reminderTime")
    public @ResponseBody
    ReminderTimeResponse getReminderTime(){
        return bussinnessLogic.getReminderTime();
    }
    @RequestMapping(method = RequestMethod.POST,value = "/reminderTime")
    public @ResponseBody
    ReminderTimeResponse insertReminderTime(@RequestBody ReminderTimeModel model){
        return bussinnessLogic.insertReminderTime(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/reminderTime")
    public @ResponseBody
    ReminderTimeResponse updateReminderTime(@RequestBody ReminderTimeModel model){
        return bussinnessLogic.updateReminderTime(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/reminderTime")
    public @ResponseBody
    ReminderTimeResponse deleteReminderTime(@RequestBody ReminderTimeModel model){
        return bussinnessLogic.deleteReminderTime(model);
    }
}
