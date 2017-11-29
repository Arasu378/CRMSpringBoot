package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.ActivityModel;

public class ActivityResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("ActivityList")
private List<ActivityModel> activityList=new ArrayList<ActivityModel>();
public ActivityResponse(){
	
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
public List<ActivityModel> getActivityList() {
	return activityList;
}
public void setActivityList(List<ActivityModel> activityList) {
	this.activityList = activityList;
}



}
