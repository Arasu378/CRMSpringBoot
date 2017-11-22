package com.kyrostechnologies.crm.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.ReminderEmailModel;

public class ReminderEmailResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("ReminderEmailList")
private ArrayList<ReminderEmailModel>reminderEmailList=new ArrayList<ReminderEmailModel>();
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
public ArrayList<ReminderEmailModel> getReminderEmailList() {
	return reminderEmailList;
}
public void setReminderEmailList(ArrayList<ReminderEmailModel> reminderEmailList) {
	this.reminderEmailList = reminderEmailList;
}

}
