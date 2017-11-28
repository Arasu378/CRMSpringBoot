package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.GoogleDriveModel;

public class GoogleDriveResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("GoogleDriveList")
private List<GoogleDriveModel> googleDriveList=new ArrayList<GoogleDriveModel>();
	public GoogleDriveResponse(){
		
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
	public List<GoogleDriveModel> getGoogleDriveList() {
		return googleDriveList;
	}
	public void setGoogleDriveList(List<GoogleDriveModel> googleDriveList) {
		this.googleDriveList = googleDriveList;
	}
	

}
