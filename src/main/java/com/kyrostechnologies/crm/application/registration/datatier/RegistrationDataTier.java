package com.kyrostechnologies.crm.application.registration.datatier;

import com.kyrostechnologies.crm.model.RegistrationModel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationDataTier implements RowMapper<RegistrationModel> {
    private int registrationId;
    private String companyCode;
    private int userProfileId;
    public RegistrationDataTier(int registrationId,String companycode,int userProfileId){
        this.registrationId=registrationId;
        this.companyCode=companycode;
        this.userProfileId=userProfileId;
    }
    @Override
    public RegistrationModel mapRow(ResultSet rs, int i) throws SQLException {
        RegistrationModel model=new RegistrationModel();
        model.setRegistrationId(registrationId);
        model.setCompanyCode(companyCode);
        model.setUserProfileId(userProfileId);
        model.setUserPassword(model.getUserPassword());
        model.setEmailAddress(model.getEmailAddress());
        return model;
    }
}
