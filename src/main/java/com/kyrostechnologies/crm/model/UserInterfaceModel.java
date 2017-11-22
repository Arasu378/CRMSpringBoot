package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;

public class UserInterfaceModel {
	@JsonProperty("UserInterfaceId")
private int userInterfaceId;
	@JsonProperty("UserProfileId")
private int userProfileId;
	@JsonProperty("IsDeal")
private boolean isDeal;
	@JsonProperty("IsPerson")
private boolean isPerson;
	@JsonProperty("IsOrganization")
private boolean isOrganization;
	@JsonProperty("IsActive")
private boolean isActive;
	@JsonProperty("CreatedDate")
private String createdDate;
	@JsonProperty("ModifiedDate")
private String modifiedDate;
public UserInterfaceModel(){
	
}
public int getUserInterfaceId() {
	return userInterfaceId;
}
public void setUserInterfaceId(int userInterfaceId) {
	this.userInterfaceId = userInterfaceId;
}
public int getUserProfileId() {
	return userProfileId;
}
public void setUserProfileId(int userProfileId) {
	this.userProfileId = userProfileId;
}
public boolean getIsDeal() {
	return isDeal;
}
public void setIsDeal(boolean isDeal) {
	this.isDeal = isDeal;
}
public boolean getIsPerson() {
	return isPerson;
}
public void setIsPerson(boolean isPerson) {
	this.isPerson = isPerson;
}
public boolean getIsOrganization() {
	return isOrganization;
}
public void setIsOrganization(boolean isOrganization) {
	this.isOrganization = isOrganization;
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
