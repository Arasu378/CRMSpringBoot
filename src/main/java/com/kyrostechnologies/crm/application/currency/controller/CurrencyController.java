package com.kyrostechnologies.crm.application.currency.controller;

import com.kyrostechnologies.crm.application.currency.businesstier.CurrencyBussinessLogic;
import com.kyrostechnologies.crm.application.currency.datatier.CurrencyDataTier;
import com.kyrostechnologies.crm.model.CurrencyModel;
import com.kyrostechnologies.crm.model.LanguageModel;
import com.kyrostechnologies.crm.response.CurrencyResponse;
import com.kyrostechnologies.crm.response.LanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CurrencyController{
    @Autowired
    private CurrencyBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value="/currency")
    public @ResponseBody CurrencyResponse getCurrency(){
        return bussinessLogic.getCurrencyList();
    }
    @RequestMapping(method = RequestMethod.POST,value="/currency")
    public @ResponseBody CurrencyResponse insertCurrency(@RequestBody CurrencyModel model){
        return bussinessLogic.insertCurrencyList(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value="/currency")
    public @ResponseBody CurrencyResponse updateCurrency(@RequestBody CurrencyModel model){
        return bussinessLogic.updateCurrencyList(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value="/currency")
    public @ResponseBody CurrencyResponse deleteCurrency(@RequestBody CurrencyModel model){
        return bussinessLogic.deleteCurrencyList(model);
    }
}
