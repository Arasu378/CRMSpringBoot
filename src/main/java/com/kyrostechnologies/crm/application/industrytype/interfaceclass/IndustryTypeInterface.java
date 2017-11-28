package com.kyrostechnologies.crm.application.industrytype.interfaceclass;

import com.kyrostechnologies.crm.model.IndustryTypeModel;
import com.kyrostechnologies.crm.response.IndustryTypeResponse;

public interface IndustryTypeInterface {
    IndustryTypeResponse getIndustryType();
    IndustryTypeResponse insertIndustryType(IndustryTypeModel model);
    IndustryTypeResponse updateIndustryType(IndustryTypeModel model);
    IndustryTypeResponse deleteIndustryType(IndustryTypeModel model);
}
