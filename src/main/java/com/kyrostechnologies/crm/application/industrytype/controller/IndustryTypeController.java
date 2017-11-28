package com.kyrostechnologies.crm.application.industrytype.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.industrytype.bussinesstier.IndustryTypeBussinessLogic;
import com.kyrostechnologies.crm.model.IndustryTypeModel;
import com.kyrostechnologies.crm.response.IndustryTypeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndustryTypeController {
    @Autowired
    private IndustryTypeBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.INDUSTRY_TYPE)
    public @ResponseBody
    IndustryTypeResponse getIndustryType(){
        return bussinessLogic.getIndustryType();
    }
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.INDUSTRY_TYPE)
    public @ResponseBody
    IndustryTypeResponse insertIndustryType(@RequestBody IndustryTypeModel model){
        return bussinessLogic.insertIndustryType(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.INDUSTRY_TYPE)
    public @ResponseBody
    IndustryTypeResponse updateIndustryType(@RequestBody IndustryTypeModel model){
        return bussinessLogic.updateIndustryType(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.INDUSTRY_TYPE)
    public @ResponseBody
    IndustryTypeResponse deleteIndustryType(@RequestBody IndustryTypeModel model){
        return bussinessLogic.updateIndustryType(model);
    }
}
