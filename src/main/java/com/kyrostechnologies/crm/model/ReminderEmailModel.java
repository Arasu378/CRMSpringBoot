package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;

public class ReminderEmailModel {
	@JsonProperty("ReminderEmailId")
private int reminderEmailId;
	@JsonProperty("UserProfileId")
private int userProfileId;
	@JsonProperty("ReminderTypeId")
private String reminderTypeId;
	@JsonProperty("ReminderTimeId")
private String reminderTimeId;
	@JsonProperty("IsActive")
private boolean isActive;
	@JsonProperty("CreatedDate")
private String createdDate;
	@JsonProperty("ModifiedDate")
private String modifiedDate;
public ReminderEmailModel(){
	
}
public int getReminderEmailId() {
	return reminderEmailId;
}
public void setReminderEmailId(int reminderEmailId) {
	this.reminderEmailId = reminderEmailId;
}
public int getUserProfileId() {
	return userProfileId;
}
public void setUserProfileId(int userProfileId) {
	this.userProfileId = userProfileId;
}
public String getReminderTypeId() {
	return reminderTypeId;
}
public void setReminderTypeId(String reminderTypeId) {
	this.reminderTypeId = reminderTypeId;
}
public String getReminderTimeId() {
	return reminderTimeId;
}
public void setReminderTimeId(String reminderTimeId) {
	this.reminderTimeId = reminderTimeId;
}
public boolean getIsActive() {
	return isActive;
}
public void setIsActive(boolean isActive) {
	this.isActive = isActive;
}
public String getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(String createdDate) {
	this.createdDate = createdDate;
}
public String getModifiedDate() {
	return modifiedDate;
}
public void setModifiedDate(String modifiedDate) {
	this.modifiedDate = modifiedDate;
}


}
