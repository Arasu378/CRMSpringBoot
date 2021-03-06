package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.UserLocaleModel;

public class UserLocaleResponse {
	@JsonProperty("IsSuccess")
	private boolean isSuccess;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("UserLocaleList")
	private List<UserLocaleModel>userLocaleList=new ArrayList<UserLocaleModel>();
public UserLocaleResponse(){
	
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
public List<UserLocaleModel> getUserLocaleList() {
	return userLocaleList;
}
public void setUserLocaleList(List<UserLocaleModel> userLocaleList) {
	this.userLocaleList = userLocaleList;
}

}
