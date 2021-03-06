package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.AttachmentModel;

public class AttachmentResponse {
	@JsonProperty("IsSuccess")
	private boolean isSuccess;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("AttachmentList")
	private List<AttachmentModel> attachmentList=new ArrayList<AttachmentModel>();
	public AttachmentResponse(){
		
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
	public List<AttachmentModel> getAttachmentList() {
		return attachmentList;
	}
	public void setAttachmentList(List<AttachmentModel> attachmentList) {
		this.attachmentList = attachmentList;
	}
	

}
