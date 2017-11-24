package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.ReminderEmailModel;

public class ReminderEmailResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("ReminderEmailList")
private List<ReminderEmailModel> reminderEmailList=new ArrayList<ReminderEmailModel>();
public ReminderEmailResponse(){
	
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
public List<ReminderEmailModel> getReminderEmailList() {
	return reminderEmailList;
}
public void setReminderEmailList(List<ReminderEmailModel> reminderEmailList) {
	this.reminderEmailList = reminderEmailList;
}

}
