package com.kyrostechnologies.crm.application.userinterface.controller;

import com.kyrostechnologies.crm.application.remindertype.businesstier.ReminderTypeBussinessLogic;
import com.kyrostechnologies.crm.application.userinterface.businesstier.UserInterfaceBussinessLogic;
import com.kyrostechnologies.crm.model.UserInterfaceModel;
import com.kyrostechnologies.crm.response.ReminderTypeResponse;
import com.kyrostechnologies.crm.response.UserInterfaceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserInterfaceController  {
    @Autowired
    private UserInterfaceBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value="/userInterfaceByUserInterfaceId/{UserInterfaceId}")
    public @ResponseBody
    UserInterfaceResponse getUserInterfaceByUserInterfaceId(@PathVariable("UserInterfaceId")int UserInterfaceId){
        return bussinessLogic.getUserInterfaceByUserInterfaceId(UserInterfaceId);
    }
    @RequestMapping(method = RequestMethod.GET,value="/userInterfaceByUserProfileId/{UserProfileId}")
    public @ResponseBody
    UserInterfaceResponse getUserInterfaceByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
        return bussinessLogic.getUserInterfaceByUserProfileId(UserProfileId);
    }
    @RequestMapping(method = RequestMethod.POST,value = "/userInterface")
    public @ResponseBody
    UserInterfaceResponse insertUserInterface(@RequestBody UserInterfaceModel model){
        return bussinessLogic.insertUserInterface(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/userInterface")
    public @ResponseBody
    UserInterfaceResponse updateUserInterface(@RequestBody UserInterfaceModel model){
        return bussinessLogic.updateUserInterface(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/userInterface")
    public @ResponseBody
    UserInterfaceResponse deleteUserInterface(@RequestBody UserInterfaceModel model){
        return bussinessLogic.deleteUserInterface(model);
    }
}
