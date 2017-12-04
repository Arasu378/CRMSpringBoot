package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.LoginModel;

public class LoginResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("LoginModel")
private List<LoginModel> loginModel=new ArrayList<LoginModel>();
public LoginResponse(){
	
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
public List<LoginModel> getLoginModel() {
	return loginModel;
}
public void setLoginModel(List<LoginModel> loginModel) {
	this.loginModel = loginModel;
}

}
