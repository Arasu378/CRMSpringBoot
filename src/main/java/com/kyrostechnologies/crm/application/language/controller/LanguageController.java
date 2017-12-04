package com.kyrostechnologies.crm.application.language.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.language.businesstier.LanguageBusinessLogic;
import com.kyrostechnologies.crm.model.LanguageModel;
import com.kyrostechnologies.crm.response.LanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@CrossOrigin(origins="*")
public class LanguageController {
    @Autowired
    private LanguageBusinessLogic businessLogic;
    @RequestMapping(method = RequestMethod.GET,value= APIUtils.LANGUAGE)
    public @ResponseBody    LanguageResponse getLanguage(){
        return businessLogic.getLanguageList();
    }
    @RequestMapping(method = RequestMethod.POST,value= APIUtils.LANGUAGE)
    public @ResponseBody    LanguageResponse insertLanguage(@RequestBody LanguageModel model){
        return businessLogic.insertLanguageList(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value= APIUtils.LANGUAGE)
    public @ResponseBody    LanguageResponse updateLanguage(@RequestBody LanguageModel model){
        return businessLogic.updateLanguageList(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value= APIUtils.LANGUAGE)
    public @ResponseBody    LanguageResponse deleteLanguage(@RequestBody LanguageModel model){
        return businessLogic.deleteLanguageList(model);
    }
}
