package com.kyrostechnologies.crm.application.emailintegration.interfaceclass;

import com.kyrostechnologies.crm.model.EmailIntegrationModel;
import com.kyrostechnologies.crm.response.EmailIntegrationResponse;

public interface EmailIntegrationInterface {
    EmailIntegrationResponse getEmailIntegrationByUserProfileId(int UserProfileId);
    EmailIntegrationResponse getEmailIntegrationByEmailIntegrationId(int EmailIntegrationId);
    EmailIntegrationResponse insertEmailIntegration(EmailIntegrationModel model);
    EmailIntegrationResponse updateEmailIntegration(EmailIntegrationModel model);
    EmailIntegrationResponse deleteEmailIntegration(EmailIntegrationModel model);
}
