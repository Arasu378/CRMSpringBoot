package com.kyrostechnologies.crm.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.ReminderTypeModel;

public class ReminderTypeResponse {
@JsonProperty("IsSuccess")
private boolean isSuccess;
@JsonProperty("Message")
private String message;
@JsonProperty("ReminderTye")
private ArrayList<ReminderTypeModel>reminderTye=new ArrayList<ReminderTypeModel>();
public ReminderTypeResponse(){
	
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
public ArrayList<ReminderTypeModel> getReminderTye() {
	return reminderTye;
}
public void setReminderTye(ArrayList<ReminderTypeModel> reminderTye) {
	this.reminderTye = reminderTye;
}


}
