package com.kyrostechnologies.crm.application.deals.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.deals.bussinesstier.DealsBussinessLogic;
import com.kyrostechnologies.crm.model.DealModel;
import com.kyrostechnologies.crm.response.DealResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class DealController {
    @Autowired
    private DealsBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.DEAL_BY_USER_PROFILE_ID)
    public @ResponseBody
    DealResponse getDealsByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
        return bussinessLogic.getDealByUserProfileId(UserProfileId);
    }
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.DEAL_BY_DEAL_ID)
    public @ResponseBody
    DealResponse getDealsByDealId(@PathVariable("DealId")int DealId){
        return bussinessLogic.getDealByDealId(DealId);
    }
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.DEALS)
    public @ResponseBody
    DealResponse insertDeals(@RequestBody DealModel model){
        return bussinessLogic.insertDeals(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.DEALS)
    public @ResponseBody
    DealResponse updateDeals(@RequestBody DealModel model){
        return bussinessLogic.updateDeals(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.DEALS)
    public @ResponseBody
    DealResponse deleteDeals(@RequestBody DealModel model){
        return bussinessLogic.deleteDeals(model);
    }
}
