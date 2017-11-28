package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="usersettings.googlecalendar")
public class GoogleCalanderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("ConnectionId")
private int connectionId;
	@JsonProperty("UserProfileId")
private int userProfileId;
	@JsonProperty("IsConnectedToGoogleAccount")
private boolean isConnectedToGoogleAccount;
	@JsonProperty("GoogleAccountEmail")
private String googleAccountEmail;
	@JsonProperty("IsActive")
private boolean isActive;
	@JsonProperty("CreatedDate")
private String createdDate;
	public GoogleCalanderModel(){
		
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
	public String getGoogleAccountEmail() {
		return googleAccountEmail;
	}
	public void setGoogleAccountEmail(String googleAccountEmail) {
		this.googleAccountEmail = googleAccountEmail;
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
	

}
