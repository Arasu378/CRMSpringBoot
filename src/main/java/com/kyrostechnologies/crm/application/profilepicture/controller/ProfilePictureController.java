package com.kyrostechnologies.crm.application.profilepicture.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.profilepicture.bussinesstier.ProfilePictureBussinessLogic;
import com.kyrostechnologies.crm.model.ProfilePictureModel;
import com.kyrostechnologies.crm.response.ProfilePictureResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfilePictureController {
    @Autowired
    private ProfilePictureBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.PROFILE_PICTURE_BY_PROFILE_PICTURE_ID)
    public @ResponseBody
    ProfilePictureResponse getProfilePicture(@PathVariable("ProfilePictureId")int ProfilePictureId){
        return bussinessLogic.getProfilePicture(ProfilePictureId);
    }
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.PROFILE_PICTURE)
    public @ResponseBody
    ProfilePictureResponse insertProfilePicture(@RequestBody ProfilePictureModel model){
        return bussinessLogic.insertProfilePicture(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.PROFILE_PICTURE)
    public @ResponseBody
    ProfilePictureResponse updateProfilePicture(@RequestBody ProfilePictureModel model){
        return bussinessLogic.updateProfilePicture(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.PROFILE_PICTURE)
    public @ResponseBody
    ProfilePictureResponse deleteProfilePicture(@RequestBody ProfilePictureModel model){
        return bussinessLogic.deleteProfilePicture(model);
    }
}
