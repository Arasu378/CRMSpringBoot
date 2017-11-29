package com.kyrostechnologies.crm.application.company.interfaceclass;

import com.kyrostechnologies.crm.model.CompanyModel;
import com.kyrostechnologies.crm.response.CompanyResponse;

public interface CompanyInterface {
    CompanyResponse getCompanyByUserProfileId(int UserProfileId);
    CompanyResponse getCompanyByCompanyId(int CompanyId);
    CompanyResponse insertCompany(CompanyModel model);
    CompanyResponse updateCompany(CompanyModel model);
    CompanyResponse deleteCompany(CompanyModel model);
}
