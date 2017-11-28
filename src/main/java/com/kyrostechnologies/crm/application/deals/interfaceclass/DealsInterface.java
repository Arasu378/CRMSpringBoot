package com.kyrostechnologies.crm.application.deals.interfaceclass;

import com.kyrostechnologies.crm.model.DealModel;
import com.kyrostechnologies.crm.response.DealResponse;

public interface DealsInterface {
    DealResponse getDealByUserProfileId(int UserProfileId);
    DealResponse getDealByDealId(int DealId);
    DealResponse insertDeals(DealModel model);
    DealResponse updateDeals(DealModel model);
    DealResponse deleteDeals(DealModel model);
}
