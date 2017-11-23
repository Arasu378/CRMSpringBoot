package com.kyrostechnologies.crm.application.userlocale.interfaceclass;

import com.kyrostechnologies.crm.model.UserLocaleModel;
import com.kyrostechnologies.crm.response.UserLocaleResponse;

public interface UserLocaleInterface {
    UserLocaleResponse getUserLocale();
    UserLocaleResponse insertUserLocale(UserLocaleModel model);
    UserLocaleResponse updateUserLocale(UserLocaleModel model);
    UserLocaleResponse deleteUserLocale(UserLocaleModel model);

}
