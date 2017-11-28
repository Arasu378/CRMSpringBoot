package com.kyrostechnologies.crm.application.emailintegration.bussinesstier;

import com.kyrostechnologies.crm.application.emailintegration.interfaceclass.EmailIntegrationInterface;
import com.kyrostechnologies.crm.application.emailintegration.datatier.EmailIntegrationDataTier;
import com.kyrostechnologies.crm.model.EmailIntegrationModel;
import com.kyrostechnologies.crm.response.EmailIntegrationResponse;
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
public class EmaiIntegrationBussinessLogic implements EmailIntegrationInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public EmailIntegrationResponse getEmailIntegrationByUserProfileId(int UserProfileId) {
        String query="CALL  `UserSettings.EmailIntegratin_GetEmailIntegrationByUserProfileId`("+UserProfileId+");";
        System.out.println("Query : "+query);
        List<EmailIntegrationModel>emailIntegrationModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new EmailIntegrationDataTier());
        if(emailIntegrationModelList!=null &&emailIntegrationModelList.size()!=0){
            return getEmailIntegrationResponse(true,"Success",emailIntegrationModelList);
        }
        return getEmailIntegrationResponse(false,"List is empty or null",null);
    }

    @Override
    public EmailIntegrationResponse getEmailIntegrationByEmailIntegrationId(int EmailIntegrationId) {
        String query="CALL `UserSettings.EmailIntegratin_GetEmailIntegraByEmailIntegrationId`("+EmailIntegrationId+");";
        System.out.println("Query : "+query);
        List<EmailIntegrationModel>emailIntegrationModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new EmailIntegrationDataTier());
        if(emailIntegrationModelList!=null &&emailIntegrationModelList.size()!=0){
            return getEmailIntegrationResponse(true,"Success",emailIntegrationModelList);
        }
        return getEmailIntegrationResponse(false,"List is empty or null",null);

    }

    @Override
    public EmailIntegrationResponse insertEmailIntegration(EmailIntegrationModel model) {
        String query="CALL `UserSettings.EmailIntegration_InsertEmail`(?,?,?,?,?,?,?)";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getUserProfileId() );
            preparedStatement.setString(2, model.getAlternativeEmailAddress());
            preparedStatement.setBoolean(3, model.getIsMyLinkedEmailsShared());
            preparedStatement.setBoolean(4, model.getIsMyEmailConversationsPrivate());
            preparedStatement.setBoolean(5, model.getIsLinkMyEmailManually());
            preparedStatement.setBoolean(6, model.getIsEmailLinkWithDeals());
            preparedStatement.setBoolean(7, model.getIsActive());
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getEmailIntegrationByUserProfileId(model.getUserProfileId());
        }
        return getEmailIntegrationResponse(false,"Email integration is not inserted successfully",null);
    }

    @Override
    public EmailIntegrationResponse updateEmailIntegration(EmailIntegrationModel model) {
        String query="CALL  `UserSettings.EmailIntegration_UpdateEmailIntegration`(?,?,?,?,?,?,?,?,?)";
        System.out.println("Query : "+query);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ModifiedDate=dateFormat.format(new Date());
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getEmailIntegrationId() );
            preparedStatement.setInt(2,model.getUserProfileId() );
            preparedStatement.setString(3, model.getAlternativeEmailAddress());
            preparedStatement.setBoolean(4, model.getIsMyLinkedEmailsShared());
            preparedStatement.setBoolean(5, model.getIsMyEmailConversationsPrivate());
            preparedStatement.setBoolean(6, model.getIsLinkMyEmailManually());
            preparedStatement.setBoolean(7, model.getIsEmailLinkWithDeals());
            preparedStatement.setBoolean(8, model.getIsActive());

            preparedStatement.setString(9, ModifiedDate);
            return preparedStatement.executeUpdate();
        });
            if(isUpdated!=0){
                return getEmailIntegrationByUserProfileId(model.getUserProfileId());
            }
        return getEmailIntegrationResponse(false,"email integration is not updated",null);
    }

    @Override
    public EmailIntegrationResponse deleteEmailIntegration(EmailIntegrationModel model) {
        String query="CALL `UserSettings.EmailIntegration_DeleteEmailIntegration`(?);";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getEmailIntegrationId());
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return  getEmailIntegrationByUserProfileId(model.getUserProfileId());
        }
        return getEmailIntegrationResponse(false,"Email integration is not deleted",null);
    }
    private EmailIntegrationResponse getEmailIntegrationResponse(boolean value, String message, List<EmailIntegrationModel>emailIntegrationModelList){
        EmailIntegrationResponse response=new EmailIntegrationResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setEmailIntegrationList(emailIntegrationModelList);
        return response;
    }
}
