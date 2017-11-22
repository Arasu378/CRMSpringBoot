package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class StagesModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonProperty("StageId")
	private int stageId;
	@JsonProperty("UserProfileId")
	private int userProfileId;
	@JsonProperty("PipeLineId")
	private int pipeLineId;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Rotten")
	private boolean rotten;
	@JsonProperty("DateCreated")
	private String dateCreated;
	@JsonProperty("DateModified")
	private String dateModified;
	@JsonProperty("OrderNr")
	private int orderNr;
	@JsonProperty("ActiveFlag")
	private boolean activeFlag;
	@JsonProperty("DealProbability")
	private boolean dealProbability;
	@JsonProperty("RottenFlag")
	private boolean rottenFlag;
	@JsonProperty("RottenDays")
	private String rottenDays;
	@JsonProperty("PipeLineName")
	private String pipeLineName;
	public StagesModel(){
		
	}
	public int getStageId() {
		return stageId;
	}
	public void setStageId(int stageId) {
		this.stageId = stageId;
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
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
	public boolean getRotten() {
		return rotten;
	}
	public void setRotten(boolean rotten) {
		this.rotten = rotten;
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
	public boolean getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public boolean getDealProbability() {
		return dealProbability;
	}
	public void setDealProbability(boolean dealProbability) {
		this.dealProbability = dealProbability;
	}
	public boolean getRottenFlag() {
		return rottenFlag;
	}
	public void setRottenFlag(boolean rottenFlag) {
		this.rottenFlag = rottenFlag;
	}
	public String getRottenDays() {
		return rottenDays;
	}
	public void setRottenDays(String rottenDays) {
		this.rottenDays = rottenDays;
	}
	public String getPipeLineName() {
		return pipeLineName;
	}
	public void setPipeLineName(String pipeLineName) {
		this.pipeLineName = pipeLineName;
	}
	

}
