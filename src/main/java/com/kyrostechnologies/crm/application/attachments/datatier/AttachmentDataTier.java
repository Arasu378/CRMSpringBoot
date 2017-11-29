package com.kyrostechnologies.crm.application.attachments.datatier;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.dbconstants.AttachmentsDBConstants;
import com.kyrostechnologies.crm.model.AttachmentModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttachmentDataTier implements RowMapper<AttachmentModel> {
    private  int AttachmentId=0;
    public AttachmentDataTier(int AttachmentId){
        this.AttachmentId=AttachmentId;
    }
    @Override
    public AttachmentModel mapRow(ResultSet rs, int i) throws SQLException {
        AttachmentModel model=new AttachmentModel();
        int attachmentId=rs.getInt(AttachmentsDBConstants.ATTACHMENT_ID);
        String attachmentFileName=rs.getString(AttachmentsDBConstants.ATTACHMENT_FILE_NAME);
        String contentType=rs.getString(AttachmentsDBConstants.CONTENT_TYPE);
        String fileSource=rs.getString(AttachmentsDBConstants.FILE_SOURCE);
        String attachedOn=rs.getString(AttachmentsDBConstants.ATTACHED_ON);
        String pictureUrl= APIUtils.PICTURE_URL+AttachmentId;
        model.setAttachmentId(attachmentId);
        model.setAttachmentFileName(attachmentFileName);
        model.setContentType(contentType);
        model.setFileSource(fileSource);
        model.setAttachedOn(attachedOn);
        model.setPictureUrl(pictureUrl);
        return model;
    }
}
