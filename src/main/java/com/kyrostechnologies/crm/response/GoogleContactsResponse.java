package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.GoogleContactsModel;

public class GoogleContactsResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("GoogleContactList")
private List<GoogleContactsModel> googleContactList=new ArrayList<GoogleContactsModel>();
	public GoogleContactsResponse(){
		
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
	public List<GoogleContactsModel> getGoogleContactList() {
		return googleContactList;
	}
	public void setGoogleContactList(
			List<GoogleContactsModel> googleContactList) {
		this.googleContactList = googleContactList;
	}
	
}
