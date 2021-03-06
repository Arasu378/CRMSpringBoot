package com.kyrostechnologies.crm.application.person.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.person.bussinesstier.PersonBussinessLogic;
import com.kyrostechnologies.crm.model.PersonModel;
import com.kyrostechnologies.crm.response.PersonEmailResponse;
import com.kyrostechnologies.crm.response.PersonPhoneResponse;
import com.kyrostechnologies.crm.response.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {
    @Autowired
    private PersonBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.PERSON_BY_USER_PROFILE_ID)
    public @ResponseBody
    PersonResponse getPersonByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
        return bussinessLogic.getPersonByUserProfileId(UserProfileId);
    }
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.PERSON_BY_PERSON_ID)
    public @ResponseBody
    PersonResponse getPersonByPersonId(@PathVariable("PersonId")int PersonId){
        return bussinessLogic.getPersonByPersonId(PersonId);
    }
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.PERSON)
    public @ResponseBody
    PersonResponse insertPerson(@RequestBody PersonModel model){
        return bussinessLogic.insertPerson(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.PERSON)
    public @ResponseBody
    PersonResponse updatePerson(@RequestBody PersonModel model){
        return bussinessLogic.updatePerson(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.PERSON)
    public @ResponseBody
    PersonResponse deletePerson(@RequestBody PersonModel model){
        return bussinessLogic.deletePerson(model);
    }
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.PERSON_EMAIL_BY_PERSON_EMAIL_ID)
    public @ResponseBody
    PersonEmailResponse getPersonEmailByPersonEmailId(@PathVariable("PersonEmailId")int PersonEmailId){
        return bussinessLogic.getPersonEmailByPersonEmailId(PersonEmailId);
    }
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.PERSON_EMAIL_BY_PERSON_ID)
    public @ResponseBody
    PersonEmailResponse getPersonEmailByPersonId(@PathVariable("PersonId")int PersonId){
        return bussinessLogic.getPersonEmailByPersonId(PersonId);
    }
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.PERSON_PHONE_BY_PERSON_PHONE_ID)
    public @ResponseBody
    PersonPhoneResponse getPersonPhoneByPersonPhoneId(@PathVariable("PersonPhoneId")int PersonPhoneId){
        return bussinessLogic.getPersonPhoneByPersonPhoneId(PersonPhoneId);
    }
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.PERSON_PHONE_BY_PERSON_ID)
    public @ResponseBody
    PersonPhoneResponse getPersonPhoneByPersonId(@PathVariable("PersonId")int PersonId){
        return bussinessLogic.getPersonPhoneByPersonId(PersonId);
    }


}
