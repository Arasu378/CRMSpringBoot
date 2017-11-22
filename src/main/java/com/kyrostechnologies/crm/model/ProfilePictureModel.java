package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;

public class ProfilePictureModel {
	@JsonProperty("ProfilePictureId")
	private int profilePictureId;
	@JsonProperty("UserProfileId")
	private int userProfileId;
	@JsonProperty("AttachmentId")
	private int AttachmentId;
	public ProfilePictureModel(){
		
	}
	public int getProfilePictureId() {
		return profilePictureId;
	}
	public void setProfilePictureId(int profilePictureId) {
		this.profilePictureId = profilePictureId;
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	public int getAttachmentId() {
		return AttachmentId;
	}
	public void setAttachmentId(int attachmentId) {
		AttachmentId = attachmentId;
	}
	

}
