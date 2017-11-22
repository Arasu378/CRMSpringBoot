package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class ActivityTypeModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonProperty("ActivityTypeId")
	private int activityTypeId;
	@JsonProperty("OrderNr")
	private int orderNr;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("KeyString")
	private String keyString;
	@JsonProperty("IconKey")
	private String iconKey;
	@JsonProperty("ActiveFlag")
	private boolean activeFlag;
	@JsonProperty("Color")
	private String color;
	@JsonProperty("IsCustomFlag")
	private boolean isCustomFlag;
	@JsonProperty("DateCreated")
	private String dateCreated;
	@JsonProperty("DateModified")
	private String dateModified;
	@JsonProperty("UserProfileId")
	private int userProfileId;
	public ActivityTypeModel(){
		
	}
	
	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public int getActivityTypeId() {
		return activityTypeId;
	}
	public void setActivityTypeId(int activityTypeId) {
		this.activityTypeId = activityTypeId;
	}
	public int getOrderNr() {
		return orderNr;
	}
	public void setOrderNr(int orderNr) {
		this.orderNr = orderNr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKeyString() {
		return keyString;
	}
	public void setKeyString(String keyString) {
		this.keyString = keyString;
	}
	public String getIconKey() {
		return iconKey;
	}
	public void setIconKey(String iconKey) {
		this.iconKey = iconKey;
	}
	public boolean getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean getIsCustomFlag() {
		return isCustomFlag;
	}
	public void setIsCustomFlag(boolean isCustomFlag) {
		this.isCustomFlag = isCustomFlag;
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
	
	
}
