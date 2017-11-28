package com.kyrostechnologies.crm.application.userlocale.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.language.businesstier.LanguageBusinessLogic;
import com.kyrostechnologies.crm.application.userlocale.bussinesstier.UserLocaleBussinessLogic;
import com.kyrostechnologies.crm.model.UserLocaleModel;
import com.kyrostechnologies.crm.response.LanguageResponse;
import com.kyrostechnologies.crm.response.UserLocaleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.Contended;

@Controller
public class UserLocaleController {
    @Autowired
    private UserLocaleBussinessLogic businessLogic;
    @RequestMapping(method = RequestMethod.GET,value= APIUtils.USER_LOCALE)
    public @ResponseBody
    UserLocaleResponse getUserLocale(){
        return businessLogic.getUserLocale();
    }
    @RequestMapping(method = RequestMethod.POST,value=APIUtils.USER_LOCALE)
    public @ResponseBody
    UserLocaleResponse insertUserLocale(@RequestBody UserLocaleModel model){
        return businessLogic.insertUserLocale(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value=APIUtils.USER_LOCALE)
    public @ResponseBody
    UserLocaleResponse updateUserLocale(@RequestBody UserLocaleModel model){
        return businessLogic.updateUserLocale(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value=APIUtils.USER_LOCALE)
    public @ResponseBody
    UserLocaleResponse deleteUserLocale(@RequestBody UserLocaleModel model){
        return businessLogic.deleteUserLocale(model);
    }
}
