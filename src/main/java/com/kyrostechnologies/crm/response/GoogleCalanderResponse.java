package com.kyrostechnologies.crm.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.GoogleCalanderModel;

public class GoogleCalanderResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("GoogleCalanderList")
private ArrayList<GoogleCalanderModel>googleCalanderList=new ArrayList<GoogleCalanderModel>();
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
public ArrayList<GoogleCalanderModel> getGoogleCalanderList() {
	return googleCalanderList;
}
public void setGoogleCalanderList(
		ArrayList<GoogleCalanderModel> googleCalanderList) {
	this.googleCalanderList = googleCalanderList;
}

}
