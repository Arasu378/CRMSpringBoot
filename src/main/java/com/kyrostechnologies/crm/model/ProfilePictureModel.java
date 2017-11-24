package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="usersettings.profilepicture")
public class ProfilePictureModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("ProfilePictureId")
	private int profilePictureId;
	@JsonProperty("UserProfileId")
	private int userProfileId;
	@JsonProperty("AttachmentId")
	private int attachmentId;
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
		return attachmentId;
	}
	public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
	}
	

}
