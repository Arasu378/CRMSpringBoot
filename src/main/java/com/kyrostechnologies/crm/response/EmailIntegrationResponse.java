package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.EmailIntegrationModel;

public class EmailIntegrationResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("EmailIntegrationList")
private List<EmailIntegrationModel> emailIntegrationList=new ArrayList<EmailIntegrationModel>();
public EmailIntegrationResponse(){
	
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
public List<EmailIntegrationModel> getEmailIntegrationList() {
	return emailIntegrationList;
}
public void setEmailIntegrationList(
		List<EmailIntegrationModel> emailIntegrationList) {
	this.emailIntegrationList = emailIntegrationList;
}

}
