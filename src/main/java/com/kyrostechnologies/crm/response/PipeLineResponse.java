package com.kyrostechnologies.crm.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.PipeLineModel;

public class PipeLineResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("PipeLineList")
private ArrayList<PipeLineModel>pipeLineList=new ArrayList<PipeLineModel>();
public PipeLineResponse(){
	
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
public ArrayList<PipeLineModel> getPipeLineList() {
	return pipeLineList;
}
public void setPipeLineList(ArrayList<PipeLineModel> pipeLineList) {
	this.pipeLineList = pipeLineList;
}

}
