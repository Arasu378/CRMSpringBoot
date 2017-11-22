package com.kyrostechnologies.crm.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.OrganizationModel;

public class OrganizationResponse {
	@JsonProperty("IsSuccess")
	private boolean isSuccess;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("OrganizationList")
	private ArrayList<OrganizationModel>organizationList=new ArrayList<OrganizationModel>();
	public OrganizationResponse(){
		
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
	public ArrayList<OrganizationModel> getOrganizationList() {
		return organizationList;
	}
	public void setOrganizationList(ArrayList<OrganizationModel> organizationList) {
		this.organizationList = organizationList;
	}
	

}
