package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="usersettings.files")
public class FilesModel implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("FileId")
	private int fileId;
	@JsonProperty("UserProfileId")
	private int userProfileId;
	@JsonProperty("DealId")
	private int dealId;
	@JsonProperty("PersonId")
	private int personId;
	@JsonProperty("OrgId")
	private int orgId;
	@JsonProperty("ProductId")
	private int productId;
	@JsonProperty("EmailMessageId")
	private int emailMessageId;
	@JsonProperty("ActivityId")
	private int activityId;
	@JsonProperty("NoteId")
	private int noteId;
	@JsonProperty("LogId")
	private int logId;
	@JsonProperty("DateCreated")
	private String dateCreated;
	@JsonProperty("DateModified")
	private String dateModified;
	@JsonProperty("FileName")
	private String fileName;
	@JsonProperty("FileType")
	private String fileType;
	@JsonProperty("FileSize")
	private String fileSize;
	@JsonProperty("ActiveFlag")
	private boolean activeFlag;
	@JsonProperty("InLineFlag")
	private boolean inLineFlag;
	@JsonProperty("RemoteLocation")
	private String remoteLocation;
	@JsonProperty("RemoteId")
	private int remoteId;
	@JsonProperty("Cid")
	private String cid;
	@JsonProperty("SBucket")
	private String sBucket;
	@JsonProperty("MailMessageId")
	private String mailMessageId;
	@JsonProperty("DealName")
	private String dealName;
	@JsonProperty("PersonName")
	private String personName;
	@JsonProperty("OrgName")
	private String orgName;
	@JsonProperty("ProductName")
	private String productName;
	@JsonProperty("URL")
	private String uRL;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Description")
	private String description;
	public FilesModel(){
		
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public int getOrgId() {
		return orgId;
	}
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getEmailMessageId() {
		return emailMessageId;
	}
	public void setEmailMessageId(int emailMessageId) {
		this.emailMessageId = emailMessageId;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public boolean getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public boolean getInLineFlag() {
		return inLineFlag;
	}
	public void setInLineFlag(boolean inLineFlag) {
		this.inLineFlag = inLineFlag;
	}
	public String getRemoteLocation() {
		return remoteLocation;
	}
	public void setRemoteLocation(String remoteLocation) {
		this.remoteLocation = remoteLocation;
	}
	public int getRemoteId() {
		return remoteId;
	}
	public void setRemoteId(int remoteId) {
		this.remoteId = remoteId;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getsBucket() {
		return sBucket;
	}
	public void setsBucket(String sBucket) {
		this.sBucket = sBucket;
	}
	public String getMailMessageId() {
		return mailMessageId;
	}
	public void setMailMessageId(String mailMessageId) {
		this.mailMessageId = mailMessageId;
	}
	public String getDealName() {
		return dealName;
	}
	public void setDealName(String dealName) {
		this.dealName = dealName;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getuRL() {
		return uRL;
	}
	public void setuRL(String uRL) {
		this.uRL = uRL;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
