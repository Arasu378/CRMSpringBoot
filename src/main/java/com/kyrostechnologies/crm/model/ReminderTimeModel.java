package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="settings.remindertime")
public class ReminderTimeModel  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
@JsonProperty("ReminderTimeId")
private int reminderTimeId;
@JsonProperty("ReminderTimeName")
private String reminderTimeName;
@JsonProperty("IsActive")
private boolean isActive;
@JsonProperty("CreatedDate")
private String createdDate;
@JsonProperty("ModifiedDate")
private String modifiedDate;
public ReminderTimeModel(){
	
}
public int getReminderTimeId() {
	return reminderTimeId;
}
public void setReminderTimeId(int reminderTimeId) {
	this.reminderTimeId = reminderTimeId;
}
public String getReminderTimeName() {
	return reminderTimeName;
}
public void setReminderTimeName(String reminderTimeName) {
	this.reminderTimeName = reminderTimeName;
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
