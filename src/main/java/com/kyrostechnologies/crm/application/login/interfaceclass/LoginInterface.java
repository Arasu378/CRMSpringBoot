package com.kyrostechnologies.crm.application.login.interfaceclass;

import com.kyrostechnologies.crm.model.LoginModel;
import com.kyrostechnologies.crm.response.LoginResponse;

public interface LoginInterface {
    LoginResponse login(LoginModel model);
    String getCompanyCode(String userEmail,String password);
    int getUserProfileId(String companyCode);
    LoginResponse getLoginView(int userProfileId,String token);
    String generateToken(String userEmail,String password,int userProfileId);
}
