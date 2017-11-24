package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.ProfilePictureModel;

public class ProfilePictureResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("ProfilePicture")
	private List<ProfilePictureModel>profilePicture=new ArrayList<ProfilePictureModel>();
	public ProfilePictureResponse(){
		
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
	public List<ProfilePictureModel> getProfilePicture() {
		return profilePicture;
	}
	public void setProfilePicture(List<ProfilePictureModel> profilePicture) {
		this.profilePicture = profilePicture;
	}
	
}
