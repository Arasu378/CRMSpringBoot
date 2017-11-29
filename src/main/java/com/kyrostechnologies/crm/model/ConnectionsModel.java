package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="usersettings.connections")
public class ConnectionsModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
	@JsonProperty("ConnectionId")
private int connectionId;
	@JsonProperty("UserProfileId")
private int userProfileId;
	@JsonProperty("IsConnectedToGoogleAccount")
private boolean isConnectedToGoogleAccount;
	@JsonProperty("IsConnectedToMailChimpAccount")
private boolean isConnectedToMailChimpAccount;
	@JsonProperty("GoogleAccountEmail")
private String googleAccountEmail;
	@JsonProperty("MailChimpAccountEmail")
private String mailChimpAccountEmail;
	@JsonProperty("IsActive")
private boolean isActive;
	@JsonProperty("CreatedDate")
private String createdDate;
	@JsonProperty("ModifiedDate")
private String modifiedDate;
	public ConnectionsModel(){
		
	}
	public int getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	public boolean getIsConnectedToGoogleAccount() {
		return isConnectedToGoogleAccount;
	}
	public void setIsConnectedToGoogleAccount(boolean isConnectedToGoogleAccount) {
		this.isConnectedToGoogleAccount = isConnectedToGoogleAccount;
	}
	public boolean getIsConnectedToMailChimpAccount() {
		return isConnectedToMailChimpAccount;
	}
	public void setIsConnectedToMailChimpAccount(boolean isConnectedToMailChimpAccount) {
		this.isConnectedToMailChimpAccount = isConnectedToMailChimpAccount;
	}
	public String getGoogleAccountEmail() {
		return googleAccountEmail;
	}
	public void setGoogleAccountEmail(String googleAccountEmail) {
		this.googleAccountEmail = googleAccountEmail;
	}
	public String getMailChimpAccountEmail() {
		return mailChimpAccountEmail;
	}
	public void setMailChimpAccountEmail(String mailChimpAccountEmail) {
		this.mailChimpAccountEmail = mailChimpAccountEmail;
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
