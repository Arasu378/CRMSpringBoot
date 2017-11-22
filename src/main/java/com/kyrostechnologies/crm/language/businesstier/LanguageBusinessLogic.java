package com.kyrostechnologies.crm.language.businesstier;

import com.kyrostechnologies.crm.language.interfaceclass.LanguageInterface;
import com.kyrostechnologies.crm.language.datatier.LanguageDataTier;
import com.kyrostechnologies.crm.model.LanguageModel;
import com.kyrostechnologies.crm.response.LanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class LanguageBusinessLogic implements LanguageInterface {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Override
    public LanguageResponse getLanguageList() {
        String query="CALL `Settings.Language_GetLanguage`();";
        List<LanguageModel>languageModelList= namedParameterJdbcTemplate.query(query, getSqlParameterSource(null),new LanguageDataTier());
        LanguageResponse response=new LanguageResponse();
        if(languageModelList!=null && languageModelList.size()!=0){
            response.setIsSuccess(true);
            response.setMessage("Success");
            response.setLanguageList(languageModelList);
        }else{
            response.setIsSuccess(true);
            response.setMessage("list size is zero or null!");
            response.setLanguageList(null);
        }

        return response;
    }
    private SqlParameterSource getSqlParameterSource(LanguageModel model){
        MapSqlParameterSource parameterSource=new MapSqlParameterSource();
        return parameterSource;
    }
}
