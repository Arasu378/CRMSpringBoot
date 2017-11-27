package com.kyrostechnologies.crm.application.language.controller;

import com.kyrostechnologies.crm.application.HttpUnauthorizedException;
import com.kyrostechnologies.crm.application.language.businesstier.LanguageBusinessLogic;
import com.kyrostechnologies.crm.application.token.InsertTokenClass;
import com.kyrostechnologies.crm.model.LanguageModel;
import com.kyrostechnologies.crm.response.LanguageResponse;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.NotAuthorizedException;
import java.nio.file.AccessDeniedException;
import java.security.InvalidKeyException;

@Controller
//@CrossOrigin(origins="*")
public class LanguageController {
    @Autowired
    private LanguageBusinessLogic businessLogic;
    @ExceptionHandler({HttpUnauthorizedException.class})
    @RequestMapping(method = RequestMethod.GET,value="/language")
    public @ResponseBody    LanguageResponse getLanguage(){
        return businessLogic.getLanguageList();
    }
    @RequestMapping(method = RequestMethod.POST,value="/language")
    public @ResponseBody    LanguageResponse insertLanguage(@RequestBody LanguageModel model){
        return businessLogic.insertLanguageList(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value="/language")
    public @ResponseBody    LanguageResponse updateLanguage(@RequestBody LanguageModel model){
        return businessLogic.updateLanguageList(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value="/language")
    public @ResponseBody    LanguageResponse deleteLanguage(@RequestBody LanguageModel model){
        return businessLogic.deleteLanguageList(model);
    }
}
