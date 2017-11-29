package com.kyrostechnologies.crm.application.attachments.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.attachments.bussinesstier.AttachmentsBussinessLogic;
import com.kyrostechnologies.crm.model.AttachmentModel;
import com.kyrostechnologies.crm.response.AttachmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AttachmentController {
    @Autowired
    private AttachmentsBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.ATTACHMENT_BY_ATTACHMENT_ID)
    public @ResponseBody
    AttachmentResponse getAttachmentByAttachmentId(@PathVariable("AttachmentId")int AttachmentId){
        return bussinessLogic.getAttachmentByAttachmentId(AttachmentId);
    }
    @RequestMapping(method =RequestMethod.GET,value = APIUtils.ATTACHMENT_PICTURE_BY_ATTACHMENT_ID,produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody
    ResponseEntity<InputStreamResource> getAttachmentPictureByAttachmentId(@PathVariable("AttachmentId")int AttachmentId){
        return bussinessLogic.getAttachmentPictureByAttachmentId(AttachmentId);
    }
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.ATTACHMENTS)
    public @ResponseBody
    AttachmentResponse insertAttachment( @RequestParam("AttachmentFileName")String attachmentFileName,
                                         @RequestParam("ContentType")String contentType,
                                         @RequestParam("FileSource")String fileSource,
                                         @RequestParam("FileBinary") MultipartFile multipartFile){
        return bussinessLogic.insertAttachment(attachmentFileName,contentType,fileSource,multipartFile);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.ATTACHMENTS)
    public @ResponseBody
    AttachmentResponse updateAttachment( @RequestParam("AttachmentId")int inputattachmentid,
                                         @RequestParam("AttachmentFileName")String attachmentFileName,
                                         @RequestParam("ContentType")String contentType,
                                         @RequestParam("FileSource")String fileSource,
                                         @RequestParam("FileBinary") MultipartFile multipartFile){
        return bussinessLogic.updateAttachment(inputattachmentid,attachmentFileName,contentType,fileSource,multipartFile);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.ATTACHMENTS)
    public @ResponseBody
    AttachmentResponse deleteAttachment(@RequestBody AttachmentModel model){
        return bussinessLogic.deleteAttachment(model);
    }
}
