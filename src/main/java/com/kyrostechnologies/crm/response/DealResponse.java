package com.kyrostechnologies.crm.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.DealModel;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;


public class DealResponse {
	@JsonProperty("IsSuccess")
	private boolean isSuccess;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("DealList")
	private List<DealModel> dealList=new ArrayList<DealModel>();
	public DealResponse(){
		
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
	public List<DealModel> getDealList() {
		return dealList;
	}
	public void setDealList(List<DealModel> dealList) {
		this.dealList = dealList;
	}
	

}
