package com.kyrostechnologies.crm.application.language.controller;

import com.kyrostechnologies.crm.application.language.businesstier.LanguageBusinessLogic;
import com.kyrostechnologies.crm.model.LanguageModel;
import com.kyrostechnologies.crm.response.LanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@CrossOrigin(origins="*")
public class LanguageController {
    @Autowired
    private LanguageBusinessLogic businessLogic;
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
