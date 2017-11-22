package com.kyrostechnologies.crm.language.interfaceclass;

import com.kyrostechnologies.crm.model.LanguageModel;
import com.kyrostechnologies.crm.response.LanguageResponse;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.ArrayList;
import java.util.List;

public interface LanguageInterface {
    @Procedure("`Settings.Language_GetLanguage`")
    LanguageResponse getLanguageList();
}
