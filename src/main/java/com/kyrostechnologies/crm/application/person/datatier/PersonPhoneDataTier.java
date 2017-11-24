package com.kyrostechnologies.crm.application.person.datatier;

import com.kyrostechnologies.crm.dbconstants.PersonPhoneDBConstants;
import com.kyrostechnologies.crm.model.PersonPhoneModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonPhoneDataTier implements RowMapper<PersonPhoneModel> {
    @Override
    public PersonPhoneModel mapRow(ResultSet rs, int i) throws SQLException {
        PersonPhoneModel model=new PersonPhoneModel();
        int personPhoneId=rs.getInt(PersonPhoneDBConstants.PERSON_PHONE_ID);
        model.setPersonPhoneId(personPhoneId);
        String label=rs.getString(PersonPhoneDBConstants.LABEL);
        model.setLabel(label);
        String value=rs.getString(PersonPhoneDBConstants.VALUE);
        model.setValue(value);
        boolean primary=rs.getBoolean(PersonPhoneDBConstants.PRIMARY);
        model.setPrimary(primary);
        String createdDate=rs.getString(PersonPhoneDBConstants.CREATED_DATE);
        model.setCreatedDate(createdDate);
        String modifiedDate=rs.getString(PersonPhoneDBConstants.MODIFIED_DATE);
        model.setModifiedDate(modifiedDate);
        int personId=rs.getInt(PersonPhoneDBConstants.PERSON_ID);
        model.setPersonId(personId);
        return model;
    }
}
