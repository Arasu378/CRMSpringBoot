package com.kyrostechnologies.crm.application.organization.interfaceclass;

import com.kyrostechnologies.crm.model.OrganizationModel;
import com.kyrostechnologies.crm.response.OrganizationResponse;

public interface OrganizationInterface {
    OrganizationResponse insertOrganization(OrganizationModel model);
    OrganizationResponse updateOrganization(OrganizationModel model);
    OrganizationResponse deleteOrganization(OrganizationModel model);
    OrganizationResponse organizationByUserProfileId(int UserProfileId);
    OrganizationResponse organizationByOrganizationId(int OrganizationId);

}
