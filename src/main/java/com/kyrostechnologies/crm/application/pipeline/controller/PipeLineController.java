package com.kyrostechnologies.crm.application.pipeline.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.pipeline.bussinesstier.PipeLineBussinessLogic;
import com.kyrostechnologies.crm.model.PipeLineModel;
import com.kyrostechnologies.crm.response.PipeLineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PipeLineController {
@Autowired
    private PipeLineBussinessLogic bussinessLogic;
@RequestMapping(method = RequestMethod.GET,value = APIUtils.PIPE_LINE_BY_USER_PROFILE_ID)
    public @ResponseBody
    PipeLineResponse getPipeLineByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
    return bussinessLogic.getPipeLine(UserProfileId);
}
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.PIPE_LINE)
    public @ResponseBody
    PipeLineResponse insertPipeLineByUserProfileId(@RequestBody PipeLineModel model){
        return bussinessLogic.insertPipeLine(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.PIPE_LINE)
    public @ResponseBody
    PipeLineResponse updatePipeLineByUserProfileId(@RequestBody PipeLineModel model){
        return bussinessLogic.updatePipeLine(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.PIPE_LINE)
    public @ResponseBody
    PipeLineResponse deletePipeLineByUserProfileId(@RequestBody PipeLineModel model){
        return bussinessLogic.deletePipeLine(model);
    }
}
