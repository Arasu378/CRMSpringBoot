package com.kyrostechnologies.crm.application.registration;

import com.kyrostechnologies.crm.model.RegistrationModel;
import com.kyrostechnologies.crm.response.RegistrationResponse;

public interface RegistrationInterface {
    RegistrationResponse registration(RegistrationModel model);
    String registerEmail(String userEmail,String password);
    RegistrationResponse insertOtherDetails(RegistrationModel model);
    String updateRegistrationTable(String companyName,int industryTypeId,int registrationId);
    String updateUserProfileTable(String timeZone,int userLocaleId,int languageId,int currencyId,int userProfileId);
    String insertCompany(int userProfileId,String companyCode,String companyName);
    String generateToken(String userEmail,String password,int userProfileId);
}
