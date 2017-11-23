package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="settings.remindertype")
public class ReminderTypeModel implements Serializable{
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@JsonProperty("ReminderTypeId")
private int reminderTypeId;
@JsonProperty("ReminderTypeName")
private String reminderTypeName;
@JsonProperty("IsActive")
private boolean isActive;
@JsonProperty("CreatedDate")
private String createdDate;
@JsonProperty("ModifiedDate")
private String modifiedDate;
public ReminderTypeModel(){
	
}
public int getReminderTypeId() {
	return reminderTypeId;
}
public void setReminderTypeId(int reminderTypeId) {
	this.reminderTypeId = reminderTypeId;
}
public String getReminderTypeName() {
	return reminderTypeName;
}
public void setReminderTypeName(String reminderTypeName) {
	this.reminderTypeName = reminderTypeName;
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
