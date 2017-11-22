package com.kyrostechnologies.crm.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.StagesModel;

public class StagesResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("StagesList")
private ArrayList<StagesModel>stagesList=new ArrayList<StagesModel>();
public StagesResponse(){
	
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
public ArrayList<StagesModel> getStagesList() {
	return stagesList;
}
public void setStagesList(ArrayList<StagesModel> stagesList) {
	this.stagesList = stagesList;
}

}
