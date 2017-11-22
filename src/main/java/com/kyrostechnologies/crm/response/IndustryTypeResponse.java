package com.kyrostechnologies.crm.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.IndustryTypeModel;

public class IndustryTypeResponse {
	@JsonProperty("IsSuccess")
	private boolean isSuccess;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("IndustryType")
	private ArrayList<IndustryTypeModel>industryType=new ArrayList<IndustryTypeModel>();
	public IndustryTypeResponse(){
		
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
	public ArrayList<IndustryTypeModel> getIndustryType() {
		return industryType;
	}
	public void setIndustryType(ArrayList<IndustryTypeModel> industryType) {
		this.industryType = industryType;
	}
	

}
