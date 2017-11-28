package com.kyrostechnologies.crm.application.googlecontacts.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.googlecontacts.bussinesstier.GoogleContactsBussinessLogic;
import com.kyrostechnologies.crm.model.GoogleContactsModel;
import com.kyrostechnologies.crm.response.GoogleContactsResponse;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GoogleContactsController {
    @Autowired
    private GoogleContactsBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.GOOGLE_CONTACTS_BY_USER_PROFILE_ID)
    public @ResponseBody
    GoogleContactsResponse getGoogleContactsByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
        return bussinessLogic.getGoogleContactByUserProfileId(UserProfileId);
    }
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.GOOGLE_CONTACTS_BY_CONTACT_ID)
    public @ResponseBody
    GoogleContactsResponse getGoogleContactsByContactId(@PathVariable("ContactId")int ContactId){
        return bussinessLogic.getGoogleContactByContactId(ContactId);
    }
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.GOOGLE_CONTACTS)
    public @ResponseBody
    GoogleContactsResponse insertGoogleContacts(@RequestBody GoogleContactsModel model){
        return bussinessLogic.insertGoogleContacts(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.GOOGLE_CONTACTS)
    public @ResponseBody
    GoogleContactsResponse updateGoogleContacts(@RequestBody GoogleContactsModel model){
        return bussinessLogic.updateGoogleContacts(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.GOOGLE_CONTACTS)
    public @ResponseBody
    GoogleContactsResponse deleteGoogleContacts(@RequestBody GoogleContactsModel model){
        return bussinessLogic.deleteGoogleContacts(model);
    }
}
