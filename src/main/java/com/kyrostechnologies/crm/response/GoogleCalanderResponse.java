package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.GoogleCalanderModel;

public class GoogleCalanderResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("GoogleCalanderList")
private List<GoogleCalanderModel> googleCalanderList=new ArrayList<GoogleCalanderModel>();
public GoogleCalanderResponse(){
	
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
public List<GoogleCalanderModel> getGoogleCalanderList() {
	return googleCalanderList;
}
public void setGoogleCalanderList(
		List<GoogleCalanderModel> googleCalanderList) {
	this.googleCalanderList = googleCalanderList;
}

}
