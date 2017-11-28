package com.kyrostechnologies.crm.application.emailintegration.datatier;

import com.kyrostechnologies.crm.dbconstants.EmailIntegrationDBConstants;
import com.kyrostechnologies.crm.model.EmailIntegrationModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmailIntegrationDataTier implements RowMapper<EmailIntegrationModel> {
    @Override
    public EmailIntegrationModel mapRow(ResultSet rs, int i) throws SQLException {
        EmailIntegrationModel model=new EmailIntegrationModel();
        int emailIntegrationId=rs.getInt(EmailIntegrationDBConstants.EMAIL_INTEGRATION_ID);
        int userProfileId=rs.getInt(EmailIntegrationDBConstants.USER_PROFILE_ID);
        String alternativeEmailAddress=rs.getString(EmailIntegrationDBConstants.ALTERNATIVE_EMAIL_ADDRESS);
        boolean isMyLinkedEmailsShared=rs.getBoolean(EmailIntegrationDBConstants.IS_MY_LINKED_EMAIL_SHARED);
        boolean isMyEmailConversationsPrivate=rs.getBoolean(EmailIntegrationDBConstants.IS_MY_EMAIL_CONVERSATIONS_PRIVATE);
        boolean isLinkMyEmailManually=rs.getBoolean(EmailIntegrationDBConstants.IS_LINK_MY_EMAIL_MANUALLY);
        boolean isEmailLinkWithDeals=rs.getBoolean(EmailIntegrationDBConstants.IS_EMAIL_LINK_WITH_DEALS);
        boolean isActive=rs.getBoolean(EmailIntegrationDBConstants.IS_ACTIVE);

        String createdDate=rs.getString(EmailIntegrationDBConstants.CREATED_DATE);
        String modifiedDate=rs.getString(EmailIntegrationDBConstants.MODIFIED_DATE);
        model.setEmailIntegrationId(emailIntegrationId);
        model.setUserProfileId(userProfileId);
        model.setAlternativeEmailAddress(alternativeEmailAddress);
        model.setIsMyLinkedEmailsShared(isMyLinkedEmailsShared);
        model.setIsMyEmailConversationsPrivate(isMyEmailConversationsPrivate);
        model.setIsEmailLinkWithDeals(isEmailLinkWithDeals);
        model.setIsLinkMyEmailManually(isLinkMyEmailManually);
        model.setIsActive(isActive);
        model.setCreatedDate(createdDate);
        model.setModifiedDate(modifiedDate);

        return model;
    }
}
