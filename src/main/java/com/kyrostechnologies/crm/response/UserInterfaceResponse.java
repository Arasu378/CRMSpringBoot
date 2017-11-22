package com.kyrostechnologies.crm.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.UserInterfaceModel;

public class UserInterfaceResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("UserInterfaceList")
private ArrayList<UserInterfaceModel>userInterfaceList= new ArrayList<UserInterfaceModel>();
public UserInterfaceResponse(){
	
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
public ArrayList<UserInterfaceModel> getUserInterfaceList() {
	return userInterfaceList;
}
public void setUserInterfaceList(ArrayList<UserInterfaceModel> userInterfaceList) {
	this.userInterfaceList = userInterfaceList;
}

}
