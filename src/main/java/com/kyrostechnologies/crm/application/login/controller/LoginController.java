package com.kyrostechnologies.crm.application.login.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.login.bussinesstier.LoginBussinessLogic;
import com.kyrostechnologies.crm.model.LoginModel;
import com.kyrostechnologies.crm.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private LoginBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.LOGIN)
    public @ResponseBody
    LoginResponse login(@RequestBody LoginModel model){
        return bussinessLogic.login(model);
    }
}
