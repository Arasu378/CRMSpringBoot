package com.kyrostechnologies.crm.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.UsersModel;

public class UsersResponse {
	@JsonProperty("IsSuccess")
	private boolean isSuccess;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("UsersList")
	private ArrayList<UsersModel>usersList=new ArrayList<UsersModel>();
	public UsersResponse(){
		
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
	public ArrayList<UsersModel> getUsersList() {
		return usersList;
	}
	public void setUsersList(ArrayList<UsersModel> usersList) {
		this.usersList = usersList;
	}
	

}
