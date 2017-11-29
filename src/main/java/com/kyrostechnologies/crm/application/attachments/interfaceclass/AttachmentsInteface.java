package com.kyrostechnologies.crm.application.attachments.interfaceclass;

import com.kyrostechnologies.crm.model.AttachmentModel;
import com.kyrostechnologies.crm.response.AttachmentResponse;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentsInteface {
    AttachmentResponse getAttachmentByAttachmentId(int AttachmentId);
    ResponseEntity<InputStreamResource> getAttachmentPictureByAttachmentId(int AttachmentId);
    AttachmentResponse insertAttachment(String attachmentFileName, String contentType, String fileSource, MultipartFile multipartFile);
    AttachmentResponse updateAttachment(int attachmentId,String attachmentFileName, String contentType, String fileSource, MultipartFile multipartFile);
    AttachmentResponse deleteAttachment(AttachmentModel model);
}
