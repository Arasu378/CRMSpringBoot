package com.kyrostechnologies.crm.application.token;


import com.kyrostechnologies.crm.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;


/**
 * @author thirunavukkarasu
 *
 */

@Repository
public class InsertTokenClass  {
    private static  NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    private static JdbcTemplate jdbcTemplate;
    @Autowired
    private  void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    public  boolean insertToken(int UserProfileId, String Token){

            Token="'"+Token+"'";
            String query="CALL `Company.Token_InsertToken`(?,?);";
            System.out.println("Query : "+query);
            String finalToken = Token;
            int isTokenInserted=jdbcTemplate.execute(query, (PreparedStatementCallback<Integer>) preparedStatement->{
                preparedStatement.setInt(1,UserProfileId);
                preparedStatement.setString(2, finalToken);
                return preparedStatement.executeUpdate();
            });
            if(isTokenInserted!=0){
                return true;
            }
            return false;


    }

    public   boolean isTokenThere(String Token) {
        Token="'"+Token+"'";
        String query="CALL `Company.Token_GetToken`("+Token+");";
        System.out.println("Query : "+query);
        List<TokenModel> tokenModelList= namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new TokenDataTier());
        if(tokenModelList!=null && tokenModelList.size()!=0){
            for(TokenModel model:tokenModelList){
                int tokenId=model.getId();
                String token=model.getToken();
                if(tokenId!=0&&token!=null){
                    return true;
                }
            }
        }
        return false;
    }

}
