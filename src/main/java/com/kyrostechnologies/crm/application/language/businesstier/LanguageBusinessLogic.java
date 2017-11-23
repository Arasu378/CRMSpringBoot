package com.kyrostechnologies.crm.application.language.businesstier;

import com.kyrostechnologies.crm.application.language.interfaceclass.LanguageInterface;
import com.kyrostechnologies.crm.application.language.datatier.LanguageDataTier;
import com.kyrostechnologies.crm.dbconstants.LanguageDBConstants;
import com.kyrostechnologies.crm.model.LanguageModel;
import com.kyrostechnologies.crm.response.LanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Repository
public class LanguageBusinessLogic implements LanguageInterface {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public LanguageResponse getLanguageList() {
        String query="CALL `Settings.Language_GetLanguage`();";
        System.out.println("Query : "+query);
        List<LanguageModel>languageModelList= namedParameterJdbcTemplate.query(query, getSqlParameterSource(null,"GET"),new LanguageDataTier());
        for(LanguageModel model:languageModelList){
            System.out.println("Language : "+model.getLanguageName());
        }

        if(languageModelList!=null && languageModelList.size()!=0){
            return getLanguageResponse(true,"Success",languageModelList);
        }else{
            return getLanguageResponse(false,"list size is zero or null!",null);

        }

     }

    @Override
    public LanguageResponse insertLanguageList(LanguageModel model) {
        String query="CALL `Settings.Language_InsertLanguage`(?,?);";
        System.out.println("Query : "+query);
     int isInserted=   jdbcTemplate.execute(query, (PreparedStatementCallback<Integer>) preparedStatement -> {
             int value;
             preparedStatement.setString(1,model.getLanguageCultureName());
             preparedStatement.setString(2,model.getLanguageName());
            value= preparedStatement.executeUpdate();
            return value;
        });
     if(isInserted==1){
         return getLanguageList();
     }else{
         return getLanguageResponse(false,"Language is not inserted",null);
     }





    }

    @Override
    public LanguageResponse updateLanguageList(LanguageModel model) {
        String query="CALL `Settings.Language_UpdateLanguage` (?,?,?,?);";
        System.out.println("Query : "+query);
       int isUpdated= jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement ->{
            int value;
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
           Date date = new Date();
         String modifiedDate=dateFormat.format(date);
           preparedStatement.setInt(1,model.getLanguageId() );
           preparedStatement.setString(2, model.getLanguageCultureName());
           preparedStatement.setString(3, model.getLanguageName());
           preparedStatement.setString(4, modifiedDate);
           value= preparedStatement.executeUpdate();
            return value;
        });
       if(isUpdated==1){
           return getLanguageList();
       }else{
           return getLanguageResponse(false,"Language is not updated",null);
       }


    }

    @Override
    public LanguageResponse deleteLanguageList(LanguageModel model) {
        String query="CALL `Settings.Language_DeleteLanguage`(?);";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement ->{
            int value;
            preparedStatement.setInt(1,model.getLanguageId());
            value=preparedStatement.executeUpdate();
            return value;
        });
        if(isDeleted==1){
            return getLanguageList();
        }else{
            return getLanguageResponse(false,"Language is not deleted",null);
        }

    }

    private LanguageResponse getLanguageResponse(boolean success,String message,List<LanguageModel>languageModelList){
        LanguageResponse response=new LanguageResponse();
        response.setIsSuccess(success);
        response.setMessage(message);
        response.setLanguageList(languageModelList);
        return response;
    }

    private SqlParameterSource getSqlParameterSource(LanguageModel model,String value){
        MapSqlParameterSource parameterSource=new MapSqlParameterSource();
        switch (value){
            case "GET":
                break;
            case "INSERT":
                break;
            case "UPDATE":
                break;
            case "DELETE":
                break;
        }

        return parameterSource;
    }

}
