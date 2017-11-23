package com.kyrostechnologies.crm.application.userlocale.datatier;

import com.kyrostechnologies.crm.dbconstants.UserLocaleDBConstants;
import com.kyrostechnologies.crm.model.UserLocaleModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLocaleDataTier implements RowMapper<UserLocaleModel> {
    @Override
    public UserLocaleModel mapRow(ResultSet rs, int i) throws SQLException {
        UserLocaleModel model= new UserLocaleModel();
        int UserLocaleId=rs.getInt(UserLocaleDBConstants.USER_LOCALE_ID);
        model.setUserLocaleId(UserLocaleId);
        String LocaleCode=rs.getString(UserLocaleDBConstants.LOCALE_CODE);
        model.setLocaleCode(LocaleCode);
        String UserLocale=rs.getString(UserLocaleDBConstants.USER_LOCALE);
        model.setUserLocale(UserLocale);
        boolean IsActive=rs.getBoolean(UserLocaleDBConstants.IS_ACTIVE);
        model.setIsActive(IsActive);
        String CreatedDate=rs.getString(UserLocaleDBConstants.CREATED_DATE);
        model.setCreatedDate(CreatedDate);
        String ModifiedDate=rs.getString(UserLocaleDBConstants.MODIFIED_DATE);
        model.setModifiedDate(ModifiedDate);
        return model;
    }
}
