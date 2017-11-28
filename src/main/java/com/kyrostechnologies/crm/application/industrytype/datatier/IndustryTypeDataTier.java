package com.kyrostechnologies.crm.application.industrytype.datatier;

import com.kyrostechnologies.crm.dbconstants.IndustryTypeDBConstants;
import com.kyrostechnologies.crm.model.IndustryTypeModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IndustryTypeDataTier implements RowMapper<IndustryTypeModel> {
    @Override
    public IndustryTypeModel mapRow(ResultSet rs, int i) throws SQLException {
        IndustryTypeModel model=new IndustryTypeModel();
        int IndustryTypeId=rs.getInt(IndustryTypeDBConstants.INDUSTRY_TYPE_ID);
        model.setIndustryTypeId(IndustryTypeId);
        String TypeName=rs.getString(IndustryTypeDBConstants.TYPE_NAME);
        model.setTypeName(TypeName);
        boolean IsActive=rs.getBoolean(IndustryTypeDBConstants.IS_ACTIVE);
        model.setIsActive(IsActive);
        String CreatedDate=rs.getString(IndustryTypeDBConstants.CREATED_DATE);
        model.setCreatedDate(CreatedDate);
        String ModifiedDate=rs.getString(IndustryTypeDBConstants.MODIFIED_DATE);
        model.setModifiedDate(ModifiedDate);
        return model;
    }
}
