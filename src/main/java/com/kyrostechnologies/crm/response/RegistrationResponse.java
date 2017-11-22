package com.kyrostechnologies.crm.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.LoginModel;
import com.kyrostechnologies.crm.model.RegistrationModel;


public class RegistrationResponse {
	@JsonProperty("IsSuccess")
	private boolean isSuccess;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("RegistrationList")
	private ArrayList<RegistrationModel>registrationList=new ArrayList<RegistrationModel>();
	@JsonProperty("LoginModel")
private ArrayList<LoginModel>loginModel=new ArrayList<LoginModel>();
	public RegistrationResponse(){
		
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
	public ArrayList<RegistrationModel> getRegistrationList() {
		return registrationList;
	}
	public void setRegistrationList(ArrayList<RegistrationModel> registrationList) {
		this.registrationList = registrationList;
	}
	public ArrayList<LoginModel> getLoginModel() {
		return loginModel;
	}
	public void setLoginModel(ArrayList<LoginModel> loginModel) {
		this.loginModel = loginModel;
	}
	

}
