package com.kyrostechnologies.crm.application.stages.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.stages.bussinesstier.StagesBussinessLogic;
import com.kyrostechnologies.crm.model.StagesModel;
import com.kyrostechnologies.crm.response.StagesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StagesController {
    @Autowired
    private StagesBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.STAGES_BY_PIPE_LINE_ID)
    public @ResponseBody
    StagesResponse getStagesByUserProfileId(@PathVariable("PipeLineId")int PipeLineId){
        return bussinessLogic.getStagesByPipeLineId(PipeLineId);
    }
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.STAGES_BY_STAGE_ID)
    public @ResponseBody
    StagesResponse getStagesByStageId(@PathVariable("StageId")int StageId){
        return bussinessLogic.getStagesByStageId(StageId);
    }
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.STAGES)
    public @ResponseBody
    StagesResponse insertStages(@RequestBody StagesModel model){
        return bussinessLogic.insertStages(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.STAGES)
    public @ResponseBody
    StagesResponse updateStages(@RequestBody StagesModel model){
        return bussinessLogic.updateStages(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.STAGES)
    public @ResponseBody
    StagesResponse deleteStages(@RequestBody StagesModel model){
        return bussinessLogic.deleteStages(model);
    }
}
