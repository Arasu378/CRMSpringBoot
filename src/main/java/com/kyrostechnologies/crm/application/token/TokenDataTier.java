package com.kyrostechnologies.crm.application.token;

import com.kyrostechnologies.crm.dbconstants.TokenDBConstants;
import com.kyrostechnologies.crm.model.TokenModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TokenDataTier implements RowMapper<TokenModel> {
    @Override
    public TokenModel mapRow(ResultSet rs, int i) throws SQLException {
        TokenModel model=new TokenModel();
        int tokenId=rs.getInt(TokenDBConstants.TOKEN_ID);
        model.setId(tokenId);
        String token=rs.getString(TokenDBConstants.TOKEN);
        model.setToken(token);
        String createdDate=rs.getString(TokenDBConstants.CREATED_DATE);
        model.setCreatedDate(createdDate);
        String modifiedDate=rs.getString(TokenDBConstants.MODIFIED_DATE);
        model.setModifiedDate(modifiedDate);
        return model;
    }
}
