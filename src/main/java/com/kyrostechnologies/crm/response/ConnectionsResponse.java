package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.ConnectionsModel;

public class ConnectionsResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("ConnectionList")
private List<ConnectionsModel> connectionList=new ArrayList<ConnectionsModel>();
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
public List<ConnectionsModel> getConnectionList() {
	return connectionList;
}
public void setConnectionList(List<ConnectionsModel> connectionList) {
	this.connectionList = connectionList;
}

}
