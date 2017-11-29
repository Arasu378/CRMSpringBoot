package com.kyrostechnologies.crm.application.attachments.bussinesstier;

import com.google.common.io.ByteStreams;
import com.kyrostechnologies.crm.application.attachments.interfaceclass.AttachmentsInteface;
import com.kyrostechnologies.crm.application.attachments.datatier.AttachmentDataTier;
import com.kyrostechnologies.crm.dbconstants.AttachmentsDBConstants;
import com.kyrostechnologies.crm.model.AttachmentModel;
import com.kyrostechnologies.crm.response.AttachmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.Blob;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class AttachmentsBussinessLogic implements AttachmentsInteface{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public AttachmentResponse getAttachmentByAttachmentId(int AttachmentId) {
        String query="CALL `SalesCrm.Attachment_GetAttachmentbyAttachmentId`("+AttachmentId+");";
        System.out.println("Query : "+query);
        List<AttachmentModel>attachmentModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new AttachmentDataTier(AttachmentId));
        if(attachmentModelList!=null &&attachmentModelList.size()!=0){
            return getAttachmentResponse(true,"Success",attachmentModelList);
        }
        return getAttachmentResponse(false,"List is empty or null",null);
    }

    @Override
    public ResponseEntity<InputStreamResource> getAttachmentPictureByAttachmentId(int AttachmentId) {
        String query="CALL `SalesCrm.Attachment_GetPicturebyAttachmentId`("+AttachmentId+");";
        System.out.println("query: "+query);
        InputStream inputStream=jdbcTemplate.execute((StatementCallback<InputStream>)statement->{
           ResultSet rs= statement.executeQuery(query);
           InputStream binarystream=null;
           while (rs.next()){
            Blob blob=rs.getBlob(AttachmentsDBConstants.FILE_BINARY);
                binarystream=blob.getBinaryStream(1,blob.length());
           }
            return binarystream;
        });

        return  ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(inputStream));
    }

    @Override
    public AttachmentResponse insertAttachment(String attachmentFileName, String contentType, String fileSource, MultipartFile multipartFile) {
        InputStream inputStream =null;
        try {
            inputStream = new BufferedInputStream(multipartFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
            if(inputStream!=null){
                String query="CALL `Company.usp_InsertAttachment`(?,?,?,?)";
                System.out.println("Query : "+query);
                InputStream finalInputStream = inputStream;
                int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>) preparedStatement->{
                    preparedStatement.setString(1,attachmentFileName );
                    preparedStatement.setString(2, contentType);
                    preparedStatement.setString(3, fileSource);
                    byte[] valueinputstream= new byte[0];
                    try {
                        valueinputstream = ByteStreams.toByteArray(finalInputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    InputStream myInputStream = new ByteArrayInputStream(valueinputstream);

                    preparedStatement.setBinaryStream(4, myInputStream);
                    return preparedStatement.executeUpdate();
                });
                if(isInserted!=0){
                    return getAttachmentResponse(true,"Attachment is inserted Successfully",null);
                }
                return getAttachmentResponse(false,"attachment is not inserted",null);
            }

        return getAttachmentResponse(false,"Inputstream is null",null);
    }

    @Override
    public AttachmentResponse updateAttachment(int attachmentId,String attachmentFileName, String contentType, String fileSource, MultipartFile multipartFile) {
        InputStream inputStream =null;
        try {
            inputStream = new BufferedInputStream(multipartFile.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(inputStream!=null){
            String query="{CALL `Company.usp_UpdateAttachment`(?,?,?,?,?,?)}";
            System.out.println("Query : "+query);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            InputStream finalInputStream = inputStream;
            int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>) preparedStatement->{
                preparedStatement.setInt(1, attachmentId);
                preparedStatement.setString(2,attachmentFileName );
                preparedStatement.setString(3, contentType);
                preparedStatement.setString(4, fileSource);
                byte[] valueinputstream= new byte[0];
                try {
                    valueinputstream = ByteStreams.toByteArray(finalInputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                InputStream myInputStream = new ByteArrayInputStream(valueinputstream);
                try {
                    System.out.println("Is available : "+myInputStream.available());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                preparedStatement.setBinaryStream(5, myInputStream);
                preparedStatement.setString(6, dateFormat.format(new Date()));
                return preparedStatement.executeUpdate();
            });
            if(isInserted!=0){
                return getAttachmentResponse(true,"Attachment is updated Successfully",null);
            }
            return getAttachmentResponse(false,"attachment is not updated",null);
        }

        return getAttachmentResponse(false,"Inputstream is null",null);

    }


    @Override
    public AttachmentResponse deleteAttachment(AttachmentModel model) {
        String query="CALL `Company.usp_DeleteAttachment`(?);";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getAttachmentId());
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return getAttachmentResponse(true,"Attachment is deleted successfully",null);
        }
        return getAttachmentResponse(false,"Attachment is not deleted successfully",null);
    }
    private AttachmentResponse getAttachmentResponse(boolean value,String message,List<AttachmentModel> attachmentModelList){
        AttachmentResponse response=new AttachmentResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setAttachmentList(attachmentModelList);
        return response;
    }
}
