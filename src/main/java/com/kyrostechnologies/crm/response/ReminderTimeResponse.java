package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.ReminderTimeModel;

public class ReminderTimeResponse {
@JsonProperty("IsSuccess")
private boolean isSuccess;
@JsonProperty("Message")
private String message;
@JsonProperty("ReminderTime")
private List<ReminderTimeModel> reminderTime=new ArrayList<ReminderTimeModel>();
public ReminderTimeResponse(){
	
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
public List<ReminderTimeModel> getReminderTime() {
	return reminderTime;
}
public void setReminderTime(List<ReminderTimeModel> reminderTime) {
	this.reminderTime = reminderTime;
}

}
