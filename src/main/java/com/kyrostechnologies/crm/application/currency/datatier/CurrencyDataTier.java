package com.kyrostechnologies.crm.application.currency.datatier;

import com.kyrostechnologies.crm.dbconstants.CurrencyDBConstants;
import com.kyrostechnologies.crm.model.CurrencyModel;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyDataTier implements RowMapper<CurrencyModel> {

    @Override
    public CurrencyModel mapRow(ResultSet rs, int i) throws SQLException {
        CurrencyModel model=new CurrencyModel();
        int CurrencyId=rs.getInt(CurrencyDBConstants.CURRENCY_ID);
        model.setCurrencyId(CurrencyId);
        String CurrencyCode=rs.getString(CurrencyDBConstants.CURRENCY_CODE);
        model.setCurrencyCode(CurrencyCode);
        String CurrencyName=rs.getString(CurrencyDBConstants.CURRENCY_NAME);
        model.setCurrencyName(CurrencyName);
        boolean IsActive=rs.getBoolean(CurrencyDBConstants.ISACTIVE);
        model.setActive(IsActive);
        String CreatedDate=rs.getString(CurrencyDBConstants.CREATED_DATE);
        model.setCreatedDate(CreatedDate);
        String ModifiedDate=rs.getString(CurrencyDBConstants.MODIFIED_DATE);
        return model;
    }
}
