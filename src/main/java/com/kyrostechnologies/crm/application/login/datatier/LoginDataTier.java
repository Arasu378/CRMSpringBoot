package com.kyrostechnologies.crm.application.login.datatier;

import com.kyrostechnologies.crm.dbconstants.LoginDBConstants;
import com.kyrostechnologies.crm.model.LoginModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDataTier implements RowMapper<LoginModel> {
    private String token;
    public LoginDataTier(String token){
        this.token=token;
    }
    @Override
    public LoginModel mapRow(ResultSet rs, int i) throws SQLException {
        LoginModel model=new LoginModel();
        String companyCode=rs.getString(LoginDBConstants.COMPANY_CODE);
        model.setCompanyCode(companyCode);
        int registrationId=rs.getInt(LoginDBConstants.REGISTRATION_ID);
        model.setRegistrationId(registrationId);
        String emailAddress=rs.getString(LoginDBConstants.EMAIL_ADDRESS);
        model.setUserEmail(emailAddress);
        String userPassword=rs.getString(LoginDBConstants.USER_PASSWORD);
        model.setPassword(userPassword);
        String userName=rs.getString(LoginDBConstants.USER_NAME);
        model.setToken(token);
        model.setUserName(userName);
        String companyName=rs.getString(LoginDBConstants.COMPANY_NAME);
        model.setCompanyName(companyName);
        int industryTypeId=rs.getInt(LoginDBConstants.INDUSTRY_TYPE_ID);
        model.setIndustryTypeId(industryTypeId);
        String lastLogin=rs.getString(LoginDBConstants.LAST_LOGIN);
        model.setLastLogin(lastLogin);
        int userProfileId=rs.getInt(LoginDBConstants.USER_PROFILE_ID);
        model.setUserProfileId(userProfileId);
        String timeZone=rs.getString(LoginDBConstants.TIME_ZONE);
        model.setTimeZone(timeZone);
        int userLocaleId=rs.getInt(LoginDBConstants.USER_LOCALE_ID);
        model.setUserLocaleId(userLocaleId);
        int languageId=rs.getInt(LoginDBConstants.LANGUAGE_ID);
        model.setLanguageId(languageId);
        int currencyId=rs.getInt(LoginDBConstants.CURRENCY_ID);
        model.setCurrencyId(currencyId);
        boolean isActive=rs.getBoolean(LoginDBConstants.IS_ACTIVE);
        model.setIsActive(isActive);
        String createdDate=rs.getString(LoginDBConstants.CREATED_DATE);
        model.setCreatedDate(createdDate);
        String modifiedDate=rs.getString(LoginDBConstants.MODIFIED_DATE);
        model.setModifiedDate(modifiedDate);
        boolean hasPic=rs.getBoolean(LoginDBConstants.HAS_PIC);
        model.setHasPic(hasPic);
        return model;
    }
}
