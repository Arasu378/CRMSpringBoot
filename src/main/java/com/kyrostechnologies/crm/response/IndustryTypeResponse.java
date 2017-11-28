package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.IndustryTypeModel;

public class IndustryTypeResponse {
	@JsonProperty("IsSuccess")
	private boolean isSuccess;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("IndustryType")
	private List<IndustryTypeModel> industryType=new ArrayList<IndustryTypeModel>();
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
	public List<IndustryTypeModel> getIndustryType() {
		return industryType;
	}
	public void setIndustryType(List<IndustryTypeModel> industryType) {
		this.industryType = industryType;
	}
	

}
