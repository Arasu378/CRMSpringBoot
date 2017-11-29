package com.kyrostechnologies.crm.application.company.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.company.bussinesstier.CompanyBussinessLogic;
import com.kyrostechnologies.crm.model.CompanyModel;
import com.kyrostechnologies.crm.response.CompanyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CompanyController {
@Autowired
    private CompanyBussinessLogic bussinessLogic;
@RequestMapping(method = RequestMethod.GET ,value = APIUtils.COMPANY_BY_USER_PROFILE_ID)
    public @ResponseBody
    CompanyResponse getCompanyByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
    return bussinessLogic.getCompanyByUserProfileId(UserProfileId);
}
    @RequestMapping(method = RequestMethod.GET ,value = APIUtils.COMPANY_BY_COMPANY_ID)
    public @ResponseBody
    CompanyResponse getCompanyByCompanyId(@PathVariable("CompanyId")int CompanyId){
        return bussinessLogic.getCompanyByCompanyId(CompanyId);
    }
    @RequestMapping(method = RequestMethod.POST ,value = APIUtils.COMPANY)
    public @ResponseBody
    CompanyResponse insertCompany(@RequestBody CompanyModel model){
        return bussinessLogic.insertCompany(model);
    }
    @RequestMapping(method = RequestMethod.PUT ,value = APIUtils.COMPANY)
    public @ResponseBody
    CompanyResponse updateCompany(@RequestBody CompanyModel model){
        return bussinessLogic.updateCompany(model);
    }
    @RequestMapping(method = RequestMethod.DELETE ,value = APIUtils.COMPANY)
    public @ResponseBody
    CompanyResponse deleteCompany(@RequestBody CompanyModel model){
        return bussinessLogic.deleteCompany(model);
    }
}
