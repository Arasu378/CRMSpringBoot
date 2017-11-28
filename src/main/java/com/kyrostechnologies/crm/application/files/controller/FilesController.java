package com.kyrostechnologies.crm.application.files.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.files.bussinesstier.FilesBussinessLogic;
import com.kyrostechnologies.crm.model.FilesModel;
import com.kyrostechnologies.crm.response.FilesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FilesController {
    @Autowired
    private FilesBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.FILES_BY_USER_PROFILE_ID)
    public @ResponseBody
    FilesResponse getFilesByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
        return bussinessLogic.getFilesByUserProfileId(UserProfileId);
    }
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.FILES_BY_FILE_ID)
    public @ResponseBody
    FilesResponse getFilesByFileId(@PathVariable("FileId")int FileId){
        return bussinessLogic.getFilesByFileId(FileId);
    }
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.FILES)
    public @ResponseBody
    FilesResponse insertFiles(@RequestBody FilesModel model){
        return bussinessLogic.insertFiles(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.FILES)
    public @ResponseBody
    FilesResponse updateFiles(@RequestBody FilesModel model){
        return bussinessLogic.updateFiles(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.FILES)
    public @ResponseBody
    FilesResponse deleteFiles(@RequestBody FilesModel model){
        return bussinessLogic.deleteFiles(model);
    }
}
