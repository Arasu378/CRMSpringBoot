package com.kyrostechnologies.crm.application.currency.interfaceclass;

import com.kyrostechnologies.crm.model.CurrencyModel;
import com.kyrostechnologies.crm.response.CurrencyResponse;

import java.util.List;

public interface CurrencyInterface {
   CurrencyResponse getCurrencyList();
   CurrencyResponse insertCurrencyList(CurrencyModel model);
   CurrencyResponse updateCurrencyList(CurrencyModel model);
   CurrencyResponse deleteCurrencyList(CurrencyModel model);
}
