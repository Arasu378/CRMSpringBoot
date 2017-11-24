package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.PipeLineModel;

public class PipeLineResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("PipeLineList")
private List<PipeLineModel> pipeLineList=new ArrayList<PipeLineModel>();
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
public List<PipeLineModel> getPipeLineList() {
	return pipeLineList;
}
public void setPipeLineList(List<PipeLineModel> pipeLineList) {
	this.pipeLineList = pipeLineList;
}

}
