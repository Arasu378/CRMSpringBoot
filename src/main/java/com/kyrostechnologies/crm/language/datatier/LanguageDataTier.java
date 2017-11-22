package com.kyrostechnologies.crm.language.datatier;

import com.kyrostechnologies.crm.dbconstants.LanguageDBConstants;
import com.kyrostechnologies.crm.model.LanguageModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LanguageDataTier implements RowMapper<LanguageModel> {
    @Override
    public LanguageModel mapRow(ResultSet rs, int i) throws SQLException {
        LanguageModel model=new LanguageModel();
        int LanguageId=rs.getInt(LanguageDBConstants.LANGUAGE_ID);
        model.setLanguageId(LanguageId);
        String LanguageCultureName=rs.getString(LanguageDBConstants.LANGUAGE_CULTURE_NAME);
        model.setLanguageCultureName(LanguageCultureName);
        String LanguageName=rs.getString(LanguageDBConstants.LANGUAGE_NAME);
        model.setLanguageName(LanguageName);
        boolean IsActive=rs.getBoolean(LanguageDBConstants.IS_ACTIVE);
        model.setIsActive(IsActive);
        String CreatedDate=rs.getString(LanguageDBConstants.CREATED_DATE);
        model.setCreatedDate(CreatedDate);
        String ModifiedDate=rs.getString(LanguageDBConstants.MODIFIED_DATE);
        model.setModifiedDate(ModifiedDate);
        return model;
    }

}
