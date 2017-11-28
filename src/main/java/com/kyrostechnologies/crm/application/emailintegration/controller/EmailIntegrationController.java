package com.kyrostechnologies.crm.application.emailintegration.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.emailintegration.bussinesstier.EmaiIntegrationBussinessLogic;
import com.kyrostechnologies.crm.application.emailintegration.datatier.EmailIntegrationDataTier;
import com.kyrostechnologies.crm.model.EmailIntegrationModel;
import com.kyrostechnologies.crm.response.EmailIntegrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailIntegrationController {
    @Autowired
    private EmaiIntegrationBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.EMAIL_INTEGRATION_BY_USER_PROFILE_ID)
    public @ResponseBody
    EmailIntegrationResponse getEmailIntegrationByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
        return bussinessLogic.getEmailIntegrationByUserProfileId(UserProfileId);
    }
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.EMAIL_INTEGRATION_BY_EMAIL_INTEGRATION_ID)
    public @ResponseBody
    EmailIntegrationResponse getEmailIntegrationByEmailIntegrationId(@PathVariable("EmailIntegrationId")int EmailIntegrationId){
        return bussinessLogic.getEmailIntegrationByEmailIntegrationId(EmailIntegrationId);
    }
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.EMAIL_INTEGRATION)
    public @ResponseBody
    EmailIntegrationResponse insertEmailIntegration(@RequestBody EmailIntegrationModel model){
        return bussinessLogic.insertEmailIntegration(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.EMAIL_INTEGRATION)
    public @ResponseBody
    EmailIntegrationResponse updateEmailIntegration(@RequestBody EmailIntegrationModel model){
        return bussinessLogic.updateEmailIntegration(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.EMAIL_INTEGRATION)
    public @ResponseBody
    EmailIntegrationResponse deleteEmailIntegration(@RequestBody EmailIntegrationModel model){
        return bussinessLogic.deleteEmailIntegration(model);
    }
}
