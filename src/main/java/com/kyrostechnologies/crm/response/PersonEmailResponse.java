package com.kyrostechnologies.crm.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.PersonEmailModel;

public class PersonEmailResponse {
	@JsonProperty("IsSuccess")
	private boolean isSuccess;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("PersonEmailList")
	private ArrayList<PersonEmailModel>personEmailList=new ArrayList<PersonEmailModel>();
	public PersonEmailResponse(){
		
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
	public ArrayList<PersonEmailModel> getPersonEmailList() {
		return personEmailList;
	}
	public void setPersonEmailList(ArrayList<PersonEmailModel> personEmailList) {
		this.personEmailList = personEmailList;
	}
	

}
