package com.kyrostechnologies.crm.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.PersonPhoneModel;

public class PersonPhoneResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("PersonPhoneList")
private ArrayList<PersonPhoneModel>personPhoneList=new ArrayList<PersonPhoneModel>();
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
public ArrayList<PersonPhoneModel> getPersonPhoneList() {
	return personPhoneList;
}
public void setPersonPhoneList(ArrayList<PersonPhoneModel> personPhoneList) {
	this.personPhoneList = personPhoneList;
}

}
