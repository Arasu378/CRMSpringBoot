package com.kyrostechnologies.crm.response;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.ConnectionsModel;

public class ConnectionsResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("ConnectionList")
private ArrayList<ConnectionsModel>connectionList=new ArrayList<ConnectionsModel>();
public ConnectionsResponse(){
	
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
public ArrayList<ConnectionsModel> getConnectionList() {
	return connectionList;
}
public void setConnectionList(ArrayList<ConnectionsModel> connectionList) {
	this.connectionList = connectionList;
}

}
