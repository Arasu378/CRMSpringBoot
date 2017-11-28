package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.FilesModel;

public class FilesResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("FilesList")
private List<FilesModel> filesList=new ArrayList<FilesModel>();
public FilesResponse(){
	
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
public List<FilesModel> getFilesList() {
	return filesList;
}
public void setFilesList(List<FilesModel> filesList) {
	this.filesList = filesList;
}


}
