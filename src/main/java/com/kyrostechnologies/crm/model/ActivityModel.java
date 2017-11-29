package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="usersettings.activity")
public class ActivityModel  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("ActivityId")
	private int activityId;
	@JsonProperty("CompanyId")
	private int companyId;
	@JsonProperty("UserProfileId")
	private int userProfileId;
	@JsonProperty("Done")
	private boolean done;
	@JsonProperty("Type")
	private String type;
	@JsonProperty("ReferenceType")
	private String referenceType;
	@JsonProperty("ReferenceId")
	private String referenceId;
	@JsonProperty("DueDate")
	private String dueDate;
	@JsonProperty("DueTime")
	private String dueTime;
	@JsonProperty("Duration")
	private String duration;
	@JsonProperty("AddTime")
	private String addTime;
	@JsonProperty("MarkedAsDoneTime")
	private String markedAsDoneTime;
	@JsonProperty("Subject")
	private String subject;
	@JsonProperty("OrgId")
	private int orgId;
	@JsonProperty("PersonId")
	private int personId;
	@JsonProperty("DealId")
	private int dealId;
	@JsonProperty("ActiveFlag")
	private boolean activeFlag;
	@JsonProperty("UpdateTime")
	private String updateTime;
	@JsonProperty("GCalEventId")
	private String gCalEventId;
	@JsonProperty("GoogleCalendarId")
	private String googleCalendarId;
	@JsonProperty("GoogleCalendarETag")
	private String googleCalendarETag;
	@JsonProperty("Note")
	private String note;
	@JsonProperty("CreatedByUserProfileId")
	private int createdByUserProfileId;
	@JsonProperty("Participants")
	private String participants;
	@JsonProperty("OrgName")
	private String orgName;
	@JsonProperty("PersonName")
	private String personName;
	@JsonProperty("DealTitle")
	private String dealTitle;
	@JsonProperty("OwnerName")
	private String ownerName;
	@JsonProperty("PersonDropBoxBcc")
	private String personDropBoxBcc;
	@JsonProperty("DealDropBoxBcc")
	private String dealDropBoxBcc;
	@JsonProperty("AssignedToUserProfileId")
	private int assignedToUserProfileId;
	
	public ActivityModel(){
		
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public boolean getDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(String referenceType) {
		this.referenceType = referenceType;
	}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getDueTime() {
		return dueTime;
	}

	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getMarkedAsDoneTime() {
		return markedAsDoneTime;
	}

	public void setMarkedAsDoneTime(String markedAsDoneTime) {
		this.markedAsDoneTime = markedAsDoneTime;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getDealId() {
		return dealId;
	}

	public void setDealId(int dealId) {
		this.dealId = dealId;
	}

	public boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getGCalEventId() {
		return gCalEventId;
	}

	public void setGCalEventId(String gCalEventId) {
		this.gCalEventId = gCalEventId;
	}

	public String getGoogleCalendarId() {
		return googleCalendarId;
	}

	public void setGoogleCalendarId(String googleCalendarId) {
		this.googleCalendarId = googleCalendarId;
	}

	public String getGoogleCalendarETag() {
		return googleCalendarETag;
	}

	public void setGoogleCalendarETag(String googleCalendarETag) {
		this.googleCalendarETag = googleCalendarETag;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getCreatedByUserProfileId() {
		return createdByUserProfileId;
	}

	public void setCreatedByUserProfileId(int createdByUserProfileId) {
		this.createdByUserProfileId = createdByUserProfileId;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getDealTitle() {
		return dealTitle;
	}

	public void setDealTitle(String dealTitle) {
		this.dealTitle = dealTitle;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPersonDropBoxBcc() {
		return personDropBoxBcc;
	}

	public void setPersonDropBoxBcc(String personDropBoxBcc) {
		this.personDropBoxBcc = personDropBoxBcc;
	}

	public String getDealDropBoxBcc() {
		return dealDropBoxBcc;
	}

	public void setDealDropBoxBcc(String dealDropBoxBcc) {
		this.dealDropBoxBcc = dealDropBoxBcc;
	}

	public int getAssignedToUserProfileId() {
		return assignedToUserProfileId;
	}

	public void setAssignedToUserProfileId(int assignedToUserProfileId) {
		this.assignedToUserProfileId = assignedToUserProfileId;
	}
	

}
