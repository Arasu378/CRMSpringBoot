package com.kyrostechnologies.crm.application.person.datatier;

import com.kyrostechnologies.crm.dbconstants.PersonEmailDBConstants;
import com.kyrostechnologies.crm.model.PersonEmailModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonEmailDataTier implements RowMapper<PersonEmailModel> {
    @Override
    public PersonEmailModel mapRow(ResultSet rs, int i) throws SQLException {
        PersonEmailModel model=new PersonEmailModel();
        int personEmailId=rs.getInt(PersonEmailDBConstants.PERSON_EMAIL_ID);
        model.setPersonEmailId(personEmailId);
        String label=rs.getString(PersonEmailDBConstants.LABEL);
        model.setLabel(label);
        String value=rs.getString(PersonEmailDBConstants.VALUE);
        model.setValue(value);
        boolean primary=rs.getBoolean(PersonEmailDBConstants.PRIMARY);
        model.setPrimary(primary);
        String createdDate=rs.getString(PersonEmailDBConstants.CREATED_DATE);
        model.setCreatedDate(createdDate);
        String modifiedDate=rs.getString(PersonEmailDBConstants.MODIFIED_DATE);
        model.setModifiedDate(modifiedDate);
        int personId=rs.getInt(PersonEmailDBConstants.PERSON_ID);
        model.setPersonId(personId);
        return model;
    }
}
