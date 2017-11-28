package com.kyrostechnologies.crm.application.files.bussinesstier;

import com.kyrostechnologies.crm.application.files.interfaceclass.FilesInterface;
import com.kyrostechnologies.crm.application.files.datatier.FilesDataTier;
import com.kyrostechnologies.crm.model.FilesModel;
import com.kyrostechnologies.crm.response.FilesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class FilesBussinessLogic implements FilesInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public FilesResponse getFilesByUserProfileId(int UserProfileId) {
        String query="CALL `UserSettings.Files_GetFilesByUserProfileId`("+UserProfileId+");";
        System.out.println("Query : "+query);
        List<FilesModel>filesModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new FilesDataTier());
        if(filesModelList!=null && filesModelList.size()!=0){
            return  getFilesResponse(true,"Success",filesModelList);
        }
        return getFilesResponse(false,"List is empty or null",null);
    }

    @Override
    public FilesResponse getFilesByFileId(int FileId) {
        String query="CALL `UserSettings.Files_GetFilesByFileId`("+FileId+");";
        System.out.println("Query : "+query);
        List<FilesModel>filesModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new FilesDataTier());
        if(filesModelList!=null && filesModelList.size()!=0){
            return  getFilesResponse(true,"Success",filesModelList);
        }
        return getFilesResponse(false,"List is empty or null",null);
    }

    @Override
    public FilesResponse insertFiles(FilesModel model) {
        String query="CALL `UserSettings.Files_InsertFiles`(?,?,?,?,?,?,?)";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            int userProfileId=model.getUserProfileId();
            preparedStatement.setInt(1,userProfileId);
            int orgId=model.getOrgId();
            preparedStatement.setInt(2,orgId);
            String fileName=model.getFileName();
            preparedStatement.setString(3,fileName);
            String fileType=model.getFileType();
            preparedStatement.setString(4,fileType);
            boolean activeFlag=model.getActiveFlag();
            preparedStatement.setBoolean(5,activeFlag);
            int remoteId=model.getRemoteId();
            preparedStatement.setInt(6,remoteId);
            String orgName=model.getOrgName();
            preparedStatement.setString(7,orgName);
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getFilesByUserProfileId(model.getUserProfileId());
        }
        return getFilesResponse(false,"files is not inserted",null);
    }

    @Override
    public FilesResponse updateFiles(FilesModel model) {
        String query="CALL  `UserSettings.Files_UpdateFiles`(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println("Query : "+query);
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)callableStatement->{
            int userProfileId=model.getUserProfileId();
            int dealId=model.getDealId();
            callableStatement.setInt(1, dealId);
            int personId=model.getPersonId();
            callableStatement.setInt(2, personId);
            int orgId=model.getOrgId();
            callableStatement.setInt(3, orgId);
            int productId=model.getProductId();
            callableStatement.setInt(4, productId);
            int emailMessageId=model.getEmailMessageId();
            callableStatement.setInt(5, emailMessageId);
            int activityId=model.getActivityId();
            callableStatement.setInt(6, activityId);
            int noteId=model.getNoteId();
            callableStatement.setInt(7, noteId);
            int logId=model.getLogId();
            callableStatement.setInt(8, logId);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String dateModified=dateFormat.format(date);
            callableStatement.setString(9, dateModified);
            String fileName=model.getFileName();
            callableStatement.setString(10, fileName);
            String fileType=model.getFileType();
            callableStatement.setString(11, fileType);
            String fileSize=model.getFileSize();
            callableStatement.setString(12, fileSize);
            boolean inLineFlag=model.getInLineFlag();
            callableStatement.setBoolean(13, inLineFlag);
            String remoteLocation=model.getRemoteLocation();
            callableStatement.setString(14, remoteLocation);
            int remoteId=model.getRemoteId();
            callableStatement.setInt(15, remoteId);
            String cid=model.getCid();
            callableStatement.setString(16, cid);
            String sBucket=model.getsBucket();
            callableStatement.setString(17, sBucket);
            String mailMessageId=model.getMailMessageId();
            callableStatement.setString(18, mailMessageId);
            String dealName=model.getDealName();
            callableStatement.setString(19, dealName);
            String personName=model.getPersonName();
            callableStatement.setString(20, personName);
            String orgName=model.getOrgName();
            callableStatement.setString(21, orgName);
            String productName=model.getProductName();
            callableStatement.setString(22, productName);
            String url=model.getuRL();
            callableStatement.setString(23, url);
            String name=model.getName();
            callableStatement.setString(24, name);
            String description=model.getDescription();
            callableStatement.setString(25, description);
            int fileId=model.getFileId();
            callableStatement.setInt(26, fileId);

            return callableStatement.executeUpdate();
        });
        if(isUpdated!=0){
            return getFilesByUserProfileId(model.getUserProfileId());
        }
        return getFilesResponse(false,"Files is not updated",null);
    }

    @Override
    public FilesResponse deleteFiles(FilesModel model) {
        String query="CALL  `UserSettings.Files_DeleteFiles`(?)";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            int fileId=model.getFileId();
            preparedStatement.setInt(1, fileId);
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return getFilesByUserProfileId(model.getUserProfileId());
        }
        return getFilesResponse(false,"files is not deleted",null);
    }
    private FilesResponse getFilesResponse(boolean value,String message,List<FilesModel> filesModelList){
        FilesResponse response=new FilesResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setFilesList(filesModelList);
        return response;
    }
}
