package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

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
	private List<RegistrationModel>registrationList=new ArrayList<RegistrationModel>();
	@JsonProperty("LoginModel")
private List<LoginModel> loginModel=new ArrayList<LoginModel>();
	@XmlElement(name="Login")
	private LoginResponse login;
	public RegistrationResponse(){
		
	}

    public LoginResponse getLogin() {
        return login;
    }

    public void setLogin(LoginResponse login) {
        this.login = login;
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
	public List<RegistrationModel> getRegistrationList() {
		return registrationList;
	}
	public void setRegistrationList(List<RegistrationModel> registrationList) {
		this.registrationList = registrationList;
	}
	public List<LoginModel> getLoginModel() {
		return loginModel;
	}
	public void setLoginModel(List<LoginModel> loginModel) {
		this.loginModel = loginModel;
	}
	

}
