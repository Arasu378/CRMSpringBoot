package com.kyrostechnologies.crm.application.files.datatier;

import com.kyrostechnologies.crm.dbconstants.FilesDBConstants;
import com.kyrostechnologies.crm.model.FilesModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilesDataTier implements RowMapper<FilesModel> {
    @Override
    public FilesModel mapRow(ResultSet rs, int i) throws SQLException {
        FilesModel model=new FilesModel();
        int fileId=rs.getInt(FilesDBConstants.FILE_ID);
        model.setFileId(fileId);
        int userProfileId=rs.getInt(FilesDBConstants.USER_PROFILE_ID);
        model.setUserProfileId(userProfileId);
        int dealId=rs.getInt(FilesDBConstants.DEAL_ID);
        model.setDealId(dealId);
        int personId=rs.getInt(FilesDBConstants.PERSON_ID);
        model.setPersonId(personId);
        int orgId=rs.getInt(FilesDBConstants.ORG_ID);
        model.setOrgId(orgId);
        int productId=rs.getInt(FilesDBConstants.PRODUCT_ID);
        model.setProductId(productId);
        int emailMessageId=rs.getInt(FilesDBConstants.EMAIL_MESSAGE_ID);
        model.setEmailMessageId(emailMessageId);
        int activityId=rs.getInt(FilesDBConstants.ACTIVITY_ID);
        model.setActivityId(activityId);
        int noteId=rs.getInt(FilesDBConstants.NOTE_ID);
        model.setNoteId(noteId);
        int logId=rs.getInt(FilesDBConstants.LOG_ID);
        model.setLogId(logId);
        String dateCreated=rs.getString(FilesDBConstants.DATE_CREATED);
        model.setDateCreated(dateCreated);
        String dateModified=rs.getString(FilesDBConstants.DATE_MODIFIED);
        model.setDateModified(dateModified);
        String fileName=rs.getString(FilesDBConstants.FILE_NAME);
        model.setFileName(fileName);
        String fileType=rs.getString(FilesDBConstants.FILE_TYPE);
        model.setFileType(fileType);
        int  fileSize=rs.getInt(FilesDBConstants.FILE_SIZE);
        model.setFileSize(String.valueOf(fileSize));
        boolean activeFlag=rs.getBoolean(FilesDBConstants.ACTIVE_FLAG);
        model.setActiveFlag(activeFlag);
        boolean inLineFlag=rs.getBoolean(FilesDBConstants.IN_LINE_FLAG);
        model.setInLineFlag(inLineFlag);
        String remoteLocation=rs.getString(FilesDBConstants.REMOTE_LOCATION);
        model.setRemoteLocation(remoteLocation);
        int remoteId=rs.getInt(FilesDBConstants.REMOTE_ID);
        model.setRemoteId((remoteId));
        String cid=rs.getString(FilesDBConstants.CID);
        model.setCid(cid);
        String sBucket=rs.getString(FilesDBConstants.S_BUCKET);
        model.setsBucket(sBucket);
        int mailMessageId=rs.getInt(FilesDBConstants.MAIL_MESSAGE_ID);
        model.setMailMessageId(String.valueOf(mailMessageId));
        String dealName=rs.getString(FilesDBConstants.DEAL_NAME);
        model.setDealName(dealName);
        String personName=rs.getString(FilesDBConstants.PERSON_NAME);
        model.setPersonName(personName);
        String uRL=rs.getString(FilesDBConstants.URL);
        model.setuRL(uRL);
        String name=rs.getString(FilesDBConstants.NAME);
        model.setName(name);
        String description=rs.getString(FilesDBConstants.DESCRIPTION);
        model.setDescription(description);
        return model;
    }
}
