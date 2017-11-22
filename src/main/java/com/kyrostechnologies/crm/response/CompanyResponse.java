package com.kyrostechnologies.crm.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.CompanyModel;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;


public class CompanyResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("CompanyList")
private ArrayList<CompanyModel>companyList=new ArrayList<CompanyModel>();
public CompanyResponse(){
	
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
public ArrayList<CompanyModel> getCompanyList() {
	return companyList;
}
public void setCompanyList(ArrayList<CompanyModel> companyList) {
	this.companyList = companyList;
}

}
