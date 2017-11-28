package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.OrganizationModel;

public class OrganizationResponse {
	@JsonProperty("IsSuccess")
	private boolean isSuccess;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("OrganizationList")
	private List<OrganizationModel> organizationList=new ArrayList<OrganizationModel>();
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
	public List<OrganizationModel> getOrganizationList() {
		return organizationList;
	}
	public void setOrganizationList(List<OrganizationModel> organizationList) {
		this.organizationList = organizationList;
	}
	

}
