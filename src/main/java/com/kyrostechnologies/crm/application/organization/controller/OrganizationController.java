package com.kyrostechnologies.crm.application.organization.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.organization.bussinesstier.OrganizationBussinessLogic;
import com.kyrostechnologies.crm.model.OrganizationModel;
import com.kyrostechnologies.crm.response.OrganizationResponse;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrganizationController {
    @Autowired
    private OrganizationBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET, value = APIUtils.ORGANIZATION_BY_USER_PROFILE_ID)
    public @ResponseBody
    OrganizationResponse getOrganizationByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
        return bussinessLogic.organizationByUserProfileId(UserProfileId);
    }
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.ORGANIZATION_BY_ORGANIZATION_ID)
    public @ResponseBody
    OrganizationResponse getOrganizationByOrganizationId(@PathVariable("OrganizationId")int OrganizationId){
        return bussinessLogic.organizationByOrganizationId(OrganizationId);
    }
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.ORGANIZATION)
    public @ResponseBody
    OrganizationResponse insertOrganization(@RequestBody OrganizationModel model){
        return bussinessLogic.insertOrganization(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.ORGANIZATION)
    public @ResponseBody
    OrganizationResponse updateOrganization(@RequestBody OrganizationModel model){
        return bussinessLogic.updateOrganization(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.ORGANIZATION)
    public @ResponseBody
    OrganizationResponse deleteOrganization(@RequestBody OrganizationModel model){
        return bussinessLogic.deleteOrganization(model);
    }
}
