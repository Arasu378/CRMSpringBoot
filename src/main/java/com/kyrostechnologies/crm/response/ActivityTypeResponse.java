package com.kyrostechnologies.crm.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.ActivityTypeModel;

public class ActivityTypeResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("ActivityTypeList")
private ArrayList<ActivityTypeModel>activityTypeList=new ArrayList<ActivityTypeModel>();
public ActivityTypeResponse(){
	
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
public ArrayList<ActivityTypeModel> getActivityTypeList() {
	return activityTypeList;
}
public void setActivityTypeList(ArrayList<ActivityTypeModel> activityTypeList) {
	this.activityTypeList = activityTypeList;
}

}
