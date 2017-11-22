package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;

public class EmailIntegrationModel {
	@JsonProperty("EmailIntegrationId")
private int emailIntegrationId;
	@JsonProperty("UserProfileId")
private int userProfileId;
	@JsonProperty("AlternativeEmailAddress")
private String alternativeEmailAddress;
	@JsonProperty("IsMyLinkedEmailsShared")
private boolean isMyLinkedEmailsShared;
	@JsonProperty("IsMyEmailConversationsPrivate")
private boolean isMyEmailConversationsPrivate;
	@JsonProperty("IsLinkMyEmailManually")
private boolean isLinkMyEmailManually;
	@JsonProperty("IsEmailLinkWithDeals")
private boolean isEmailLinkWithDeals;
	@JsonProperty("IsActive")
private boolean isActive;
	@JsonProperty("CreatedDate")
private String createdDate;
	@JsonProperty("ModifiedDate")
private String modifiedDate;
public EmailIntegrationModel(){
	
}
public int getEmailIntegrationId() {
	return emailIntegrationId;
}
public void setEmailIntegrationId(int emailIntegrationId) {
	this.emailIntegrationId = emailIntegrationId;
}
public int getUserProfileId() {
	return userProfileId;
}
public void setUserProfileId(int userProfileId) {
	this.userProfileId = userProfileId;
}
public String getAlternativeEmailAddress() {
	return alternativeEmailAddress;
}
public void setAlternativeEmailAddress(String alternativeEmailAddress) {
	this.alternativeEmailAddress = alternativeEmailAddress;
}
public boolean getIsMyLinkedEmailsShared() {
	return isMyLinkedEmailsShared;
}
public void setIsMyLinkedEmailsShared(boolean isMyLinkedEmailsShared) {
	this.isMyLinkedEmailsShared = isMyLinkedEmailsShared;
}
public boolean getIsMyEmailConversationsPrivate() {
	return isMyEmailConversationsPrivate;
}
public void setIsMyEmailConversationsPrivate(boolean isMyEmailConversationsPrivate) {
	this.isMyEmailConversationsPrivate = isMyEmailConversationsPrivate;
}
public boolean getIsLinkMyEmailManually() {
	return isLinkMyEmailManually;
}
public void setIsLinkMyEmailManually(boolean isLinkMyEmailManually) {
	this.isLinkMyEmailManually = isLinkMyEmailManually;
}
public boolean getIsEmailLinkWithDeals() {
	return isEmailLinkWithDeals;
}
public void setIsEmailLinkWithDeals(boolean isEmailLinkWithDeals) {
	this.isEmailLinkWithDeals = isEmailLinkWithDeals;
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
