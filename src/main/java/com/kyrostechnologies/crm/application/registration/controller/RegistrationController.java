package com.kyrostechnologies.crm.application.registration.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.registration.bussinesstier.RegistrationBussinessLogic;
import com.kyrostechnologies.crm.model.RegistrationModel;
import com.kyrostechnologies.crm.response.RegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.REGISTRATION)
    public @ResponseBody
    RegistrationResponse registraion(@RequestBody RegistrationModel model){
        return bussinessLogic.registration(model);
    }
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.REGISTRATION_MORE_DETAILS)
    public @ResponseBody
    RegistrationResponse registrationMoreDetails(@RequestBody RegistrationModel model){
        return bussinessLogic.insertOtherDetails(model);
    }
}
