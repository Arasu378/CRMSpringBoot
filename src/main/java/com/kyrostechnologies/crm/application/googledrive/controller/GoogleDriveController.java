package com.kyrostechnologies.crm.application.googledrive.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.googledrive.bussinesstier.GoogleDriveBussinessLogic;
import com.kyrostechnologies.crm.model.GoogleDriveModel;
import com.kyrostechnologies.crm.response.GoogleDriveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GoogleDriveController {
    @Autowired
    private GoogleDriveBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.GOOGLE_DRIVE_BY_DRIVE_ID)
    public @ResponseBody
    GoogleDriveResponse getGoogleDriveByDriveId(@PathVariable("DriveId")int DriveId){
        return bussinessLogic.getGoogleDriveByDriveId(DriveId);
    }
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.GOOGLE_DRIVE)
    public @ResponseBody
    GoogleDriveResponse insertGoogleDrive(@RequestBody GoogleDriveModel model){
        return bussinessLogic.insertGoogleDrive(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.GOOGLE_DRIVE)
    public @ResponseBody
    GoogleDriveResponse updateGoogleDrive(@RequestBody GoogleDriveModel model){
        return bussinessLogic.updateGoogleDrive(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.GOOGLE_DRIVE)
    public @ResponseBody
    GoogleDriveResponse deleteGoogleDrive(@RequestBody GoogleDriveModel model){
        return bussinessLogic.deleteGoogleDrive(model);
    }
}
