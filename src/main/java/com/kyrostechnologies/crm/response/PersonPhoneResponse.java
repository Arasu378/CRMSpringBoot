package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.PersonPhoneModel;

public class PersonPhoneResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("PersonPhoneList")
private List<PersonPhoneModel>personPhoneList=new ArrayList<PersonPhoneModel>();
public PersonPhoneResponse(){
	
}
public boolean getIsSuccess() {
	return isSuccess;
}
public void setIsSuccess(boolean isSuccess) {
	this.isSuccess = isSuccess;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public List<PersonPhoneModel> getPersonPhoneList() {
	return personPhoneList;
}
public void setPersonPhoneList(List<PersonPhoneModel> personPhoneList) {
	this.personPhoneList = personPhoneList;
}

}
