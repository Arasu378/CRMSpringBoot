package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.PersonEmailModel;

public class PersonEmailResponse {
	@JsonProperty("IsSuccess")
	private boolean isSuccess;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("PersonEmailList")
	private List<PersonEmailModel> personEmailList=new ArrayList<PersonEmailModel>();
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
	public List<PersonEmailModel> getPersonEmailList() {
		return personEmailList;
	}
	public void setPersonEmailList(List<PersonEmailModel> personEmailList) {
		this.personEmailList = personEmailList;
	}
	

}
