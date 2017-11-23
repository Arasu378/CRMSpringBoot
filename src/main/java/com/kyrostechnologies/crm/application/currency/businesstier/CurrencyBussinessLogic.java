package com.kyrostechnologies.crm.application.currency.businesstier;

import com.kyrostechnologies.crm.application.currency.interfaceclass.CurrencyInterface;
import com.kyrostechnologies.crm.application.currency.datatier.CurrencyDataTier;
import com.kyrostechnologies.crm.model.CurrencyModel;
import com.kyrostechnologies.crm.response.CurrencyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Repository
public class CurrencyBussinessLogic implements CurrencyInterface {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public CurrencyResponse getCurrencyList() {
        String query="CALL `Settings.Currency_GetCurrency`();";
        System.out.println("Query : "+query);
        List<CurrencyModel>currencyModelList= namedParameterJdbcTemplate.query(query, new MapSqlParameterSource(),new CurrencyDataTier());
        for(CurrencyModel model:currencyModelList){
            System.out.println("Language : "+model.getCurrencyName());
        }

        if(currencyModelList!=null && currencyModelList.size()!=0){
            return getCurrencyResponse(true,"Success",currencyModelList);
        }else{
            return getCurrencyResponse(false,"list size is zero or null!",null);

        }
    }

    @Override
    public CurrencyResponse insertCurrencyList(CurrencyModel model) {
        String query="CALL `Settings.Currency_InsertCurrency`(?,?);";
        System.out.println("Query : "+query);
        int isInserted=   jdbcTemplate.execute(query, (PreparedStatementCallback<Integer>) preparedStatement -> {
            int value;
            preparedStatement.setString(1,model.getCurrencyCode());
            preparedStatement.setString(2,model.getCurrencyName());
            value= preparedStatement.executeUpdate();
            return value;
        });
        if(isInserted==1){
            return getCurrencyList();
        }else{
            return getCurrencyResponse(false,"Currency is not inserted",null);
        }

    }

    @Override
    public CurrencyResponse updateCurrencyList(CurrencyModel model) {
        String query="CALL`Settings.Currency_UpdateCurrency`(?,?,?,?);";
        System.out.println("Query : "+query);
        int isUpdated=   jdbcTemplate.execute(query, (PreparedStatementCallback<Integer>) preparedStatement -> {
            int value;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String modifiedDate=dateFormat.format(date);
            preparedStatement.setInt(1,model.getCurrencyId());
            preparedStatement.setString(2,model.getCurrencyCode());
            preparedStatement.setString(3,model.getCurrencyName());
            preparedStatement.setString(4,modifiedDate);
            value= preparedStatement.executeUpdate();
            return value;
        });
        if(isUpdated==1){
            return getCurrencyList();
        }else{
            return getCurrencyResponse(false,"Currency is not updated",null);
        }

    }

    @Override
    public CurrencyResponse deleteCurrencyList(CurrencyModel model) {
        String query="CALL `Settings.Currency_DeleteCurrency`(?);";
        System.out.println("Query : "+query);
        int isDeleted=   jdbcTemplate.execute(query, (PreparedStatementCallback<Integer>) preparedStatement -> {
            int value;
            preparedStatement.setInt(1,model.getCurrencyId());
            value= preparedStatement.executeUpdate();
            return value;
        });
        if(isDeleted==1){
            return getCurrencyList();
        }else{
            return getCurrencyResponse(false,"Currency is not updated",null);
        }

    }

    private CurrencyResponse getCurrencyResponse(boolean success, String message, List<CurrencyModel>currencyModelList){
        CurrencyResponse response=new CurrencyResponse();
        response.setIsSuccess(success);
        response.setMessage(message);
        response.setCurrencyModel(currencyModelList);
        return response;
    }


}
