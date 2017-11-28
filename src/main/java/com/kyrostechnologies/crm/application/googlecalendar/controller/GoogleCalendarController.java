package com.kyrostechnologies.crm.application.googlecalendar.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.googlecalendar.bussinesstier.GoogleCalendarBussinessLogic;
import com.kyrostechnologies.crm.model.GoogleCalanderModel;
import com.kyrostechnologies.crm.response.GoogleCalanderResponse;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GoogleCalendarController {
    @Autowired
    private GoogleCalendarBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.GOOGLE_CALENDAR_BY_USER_PROFILE_ID)
    public @ResponseBody
    GoogleCalanderResponse getGoogleCalendarByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
        return bussinessLogic.getGoogleCalendarByUserProfileId(UserProfileId);
    }
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.GOOGLE_CALENDAR_BY_CONNECTION_ID)
    public @ResponseBody
    GoogleCalanderResponse getGoogleCalendarByConnectionId(@PathVariable("ConnectionId")int ConnectionId){
        return bussinessLogic.getGoogleCalendarByConnectionId(ConnectionId);
    }
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.GOOGLE_CALENDAR)
    public @ResponseBody
    GoogleCalanderResponse insertGoogleCalendar(@RequestBody GoogleCalanderModel model){
        return bussinessLogic.insertGoogleCalendar(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.GOOGLE_CALENDAR)
    public @ResponseBody
    GoogleCalanderResponse updateGoogleCalendar(@RequestBody GoogleCalanderModel model){
        return bussinessLogic.updateGoogleCalendar(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.GOOGLE_CALENDAR)
    public @ResponseBody
    GoogleCalanderResponse deleteGoogleCalendar(@RequestBody GoogleCalanderModel model){
        return bussinessLogic.deleteGoogleCalendar(model);
    }
}
