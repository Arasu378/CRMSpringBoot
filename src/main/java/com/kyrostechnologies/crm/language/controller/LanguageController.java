package com.kyrostechnologies.crm.language.controller;

import com.kyrostechnologies.crm.language.businesstier.LanguageBusinessLogic;
import com.kyrostechnologies.crm.language.datatier.LanguageDataTier;
import com.kyrostechnologies.crm.response.LanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

}
