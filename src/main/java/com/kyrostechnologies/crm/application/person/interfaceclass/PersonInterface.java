package com.kyrostechnologies.crm.application.person.interfaceclass;

import com.kyrostechnologies.crm.model.PersonEmailModel;
import com.kyrostechnologies.crm.model.PersonModel;
import com.kyrostechnologies.crm.model.PersonPhoneModel;
import com.kyrostechnologies.crm.response.PersonEmailResponse;
import com.kyrostechnologies.crm.response.PersonPhoneResponse;
import com.kyrostechnologies.crm.response.PersonResponse;

import java.util.List;

public interface PersonInterface {
    PersonEmailResponse getPersonEmailByPersonEmailId(int PersonEmailId);
    PersonEmailResponse getPersonEmailByPersonId(int PersonId);
    PersonPhoneResponse getPersonPhoneByPersonPhoneId(int PersonPhoneId);
    PersonPhoneResponse getPersonPhoneByPersonId(int PersonId);
    int insertPersonEmail(int PersonId, List<PersonEmailModel>personEmailModelList);
    int insertPersonPhone(int PersonId, List<PersonPhoneModel>personPhoneModelList);
    PersonEmailResponse updatePersonEmail(PersonEmailModel model);
    PersonEmailResponse deletePersonEmail(PersonEmailModel model);
    PersonPhoneResponse updatePersonPhone(PersonPhoneModel model);
    PersonPhoneResponse deletePersonPhone(PersonPhoneModel model);
    PersonResponse insertPersonPDrive(PersonModel model);
    PersonResponse getPersonByUserProfileId(int UserProfileId);
    PersonResponse getPersonByPersonId(int PersonId);
    PersonResponse insertPerson(PersonModel model);
    PersonResponse updatePerson(PersonModel model);
    PersonResponse deletePerson(PersonModel model);

}
