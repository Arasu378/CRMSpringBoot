package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class PipeLineModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@JsonProperty("PipeLineId")
	private int pipeLineId;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("UserProfileId")
	private int userProfileId;
	@JsonProperty("DateCreated")
	private String dateCreated;
	@JsonProperty("DateModified")
	private String dateModified;
	@JsonProperty("OrderNr")
	private int orderNr;
	@JsonProperty("IsActive")
	private boolean isActive;
	@JsonProperty("IsSelected")
	private boolean isSelected;
	@JsonProperty("IsDealProbability")
	private boolean isDealProbability;
	@JsonProperty("UrlTitle")
	private String urlTitle;
	public PipeLineModel(){
		
	}
	public int getPipeLineId() {
		return pipeLineId;
	}
	public void setPipeLineId(int pipeLineId) {
		this.pipeLineId = pipeLineId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getDateModified() {
		return dateModified;
	}
	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}
	public int getOrderNr() {
		return orderNr;
	}
	public void setOrderNr(int orderNr) {
		this.orderNr = orderNr;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean active) {
		this.isActive = active;
	}
	public boolean getIsSelected() {
		return isSelected;
	}
	public void setIsSelected(boolean selected) {
		this.isSelected = selected;
	}
	public boolean getIsDealProbability() {
		return isDealProbability;
	}
	public void setIsDealProbability(boolean dealProbability) {
		this.isDealProbability = dealProbability;
	}
	public String getUrlTitle() {
		return urlTitle;
	}
	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}
	

}
