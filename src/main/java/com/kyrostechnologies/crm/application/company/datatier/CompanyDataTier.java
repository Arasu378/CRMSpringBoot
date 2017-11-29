package com.kyrostechnologies.crm.application.company.datatier;

import com.kyrostechnologies.crm.dbconstants.CompanyDBConstants;
import com.kyrostechnologies.crm.model.CompanyModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyDataTier implements RowMapper<CompanyModel> {
    @Override
    public CompanyModel mapRow(ResultSet rs, int i) throws SQLException {
        CompanyModel model=new CompanyModel();
        int companyId=rs.getInt(CompanyDBConstants.COMPANY_ID);
        int userProfileId=rs.getInt(CompanyDBConstants.USER_PROFILE_ID);
        String companyCode=rs.getString(CompanyDBConstants.COMPANY_CODE);
        String companyName=rs.getString(CompanyDBConstants.COMPANY_NAME);
        boolean isActive=rs.getBoolean(CompanyDBConstants.IS_ACTIVE);
        String createdDate=rs.getString(CompanyDBConstants.CREATED_DATE);
        String modifiedDate=rs.getString(CompanyDBConstants.MODIFIED_DATE);
        model.setCompanyId(companyId);
        model.setUserProfileId(userProfileId);
        model.setCompanyCode(companyCode);
        model.setCompanyName(companyName);
        model.setIsActive(isActive);
        model.setCreatedDate(createdDate);
        model.setModifiedDate(modifiedDate);
        return model;
    }
}
