package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="company.deal")
public class DealModel implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("DealId")
	private int dealId;
	@JsonProperty("Title")
	private String title;
	@JsonProperty("Status")
	private String status;
	@JsonProperty("Value")
	private int value;
	@JsonProperty("Currency")
	private String currency;
	@JsonProperty("StageId")
	private int stageId;
	@JsonProperty("PipeLineId")
	private int pipeLineId;
	@JsonProperty("UserProfileId")
	private int userProfileId;
	@JsonProperty("PersonId")
	private int personId;
	@JsonProperty("OrganizationId")
	private int organizationId;
	@JsonProperty("AddTime")
	private String addTime;
	@JsonProperty("UpdateTime")
	private String updateTime;
	@JsonProperty("StageChangeTime")
	private String stageChangeTime;
	@JsonProperty("Active")
	private boolean active;
	@JsonProperty("Deleted")
	private boolean deleted;
	@JsonProperty("Probability")
	private String probability;
	@JsonProperty("NextActivityDate")
	private String nextActivityDate;
	@JsonProperty("NextActivityTime")
	private String nextActivityTime;
	@JsonProperty("NextActivityId")
	private int nextActivityId;
	@JsonProperty("LastActivityId")
	private int lastActivityId;
	@JsonProperty("LastActivityDate")
	private String lastActivityDate;
	@JsonProperty("LostReason")
	private String lostReason;
	@JsonProperty("VisibleTo")
	private int visibleTo;
	@JsonProperty("CloseTime")
	private String closeTime;
	@JsonProperty("WonTime")
	private String wonTime;
	@JsonProperty("FirstWonTime")
	private String firstWonTime;
	@JsonProperty("LostTime")
	private String lostTime;
	@JsonProperty("ProductsCount")
	private int productsCount;
	@JsonProperty("FilesCount")
	private int filesCount;
	@JsonProperty("NotesCount")
	private int notesCount;
	@JsonProperty("FollowersCount")
	private int followersCount;
	@JsonProperty("EmailMessagesCount")
	private int emailMessagesCount;
	@JsonProperty("ActivitiesCount")
	private int activitiesCount;
	@JsonProperty("DoneActivitiesCount")
	private int doneActivitiesCount;
	@JsonProperty("UndoneActivitiesCount")
	private int undoneActivitiesCount;
	@JsonProperty("ReferenceActivitiesCount")
	private int referenceActivitiesCount;
	@JsonProperty("ParticipantsCount")
	private int participantsCount;
	@JsonProperty("ExpectedCloseDate")
	private String expectedCloseDate;
	@JsonProperty("LastIncomingMailTime")
	private String lastIncomingMailTime;
	@JsonProperty("LastOutgoingMailTime")
	private String lastOutgoingMailTime;
	@JsonProperty("StageOrderNr")
	private int stageOrderNr;
	@JsonProperty("PersonName")
	private String personName;
	@JsonProperty("OrgName")
	private String orgName;
	@JsonProperty("NextActivitySubject")
	private String nextActivitySubject;
	@JsonProperty("NextActivityType")
	private String nextActivityType;
	@JsonProperty("NextActivityDuration")
	private String nextActivityDuration;
	@JsonProperty("NextActivityNote")
	private String nextActivityNote;
	@JsonProperty("FormattedValue")
	private String formattedValue;
	@JsonProperty("RottenTime")
	private String rottenTime;
	@JsonProperty("WeightedValue")
	private int weightedValue;
	@JsonProperty("FormattedWeightedValue")
	private String formattedWeightedValue;
	@JsonProperty("OwnerName")
	private String ownerName;
	@JsonProperty("CCEmail")
	private String cCEmail;
	@JsonProperty("OrgHidden")
	private boolean orgHidden;
	@JsonProperty("PersonHidden")
	private boolean personHidden;
	@JsonProperty("PeopleCount")
	private int peopleCount;
	@JsonProperty("OpenDealsCount")
	private int openDealsCount;
	
	@JsonProperty("CompanyCode")
	private String companyCode;
	public DealModel(){
		
	}

	
	public String getCompanyCode() {
		return companyCode;
	}


	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}


	public int getOpenDealsCount() {
		return openDealsCount;
	}


	public void setOpenDealsCount(int openDealsCount) {
		this.openDealsCount = openDealsCount;
	}


	public int getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}

	public int getDealId() {
		return dealId;
	}

	public void setDealId(int dealId) {
		this.dealId = dealId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getStageId() {
		return stageId;
	}

	public void setStageId(int stageId) {
		this.stageId = stageId;
	}

	public int getPipeLineId() {
		return pipeLineId;
	}

	public void setPipeLineId(int pipeLineId) {
		this.pipeLineId = pipeLineId;
	}

	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public int getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getStageChangeTime() {
		return stageChangeTime;
	}

	public void setStageChangeTime(String stageChangeTime) {
		this.stageChangeTime = stageChangeTime;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getProbability() {
		return probability;
	}

	public void setProbability(String probability) {
		this.probability = probability;
	}

	public String getNextActivityDate() {
		return nextActivityDate;
	}

	public void setNextActivityDate(String nextActivityDate) {
		this.nextActivityDate = nextActivityDate;
	}

	public String getNextActivityTime() {
		return nextActivityTime;
	}

	public void setNextActivityTime(String nextActivityTime) {
		this.nextActivityTime = nextActivityTime;
	}

	public int getNextActivityId() {
		return nextActivityId;
	}

	public void setNextActivityId(int nextActivityId) {
		this.nextActivityId = nextActivityId;
	}

	public int getLastActivityId() {
		return lastActivityId;
	}

	public void setLastActivityId(int lastActivityId) {
		this.lastActivityId = lastActivityId;
	}

	public String getLastActivityDate() {
		return lastActivityDate;
	}

	public void setLastActivityDate(String lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	public String getLostReason() {
		return lostReason;
	}

	public void setLostReason(String lostReason) {
		this.lostReason = lostReason;
	}

	public int getVisibleTo() {
		return visibleTo;
	}

	public void setVisibleTo(int visibleTo) {
		this.visibleTo = visibleTo;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getWonTime() {
		return wonTime;
	}

	public void setWonTime(String wonTime) {
		this.wonTime = wonTime;
	}

	public String getFirstWonTime() {
		return firstWonTime;
	}

	public void setFirstWonTime(String firstWonTime) {
		this.firstWonTime = firstWonTime;
	}

	public String getLostTime() {
		return lostTime;
	}

	public void setLostTime(String lostTime) {
		this.lostTime = lostTime;
	}

	public int getProductsCount() {
		return productsCount;
	}

	public void setProductsCount(int productsCount) {
		this.productsCount = productsCount;
	}

	public int getFilesCount() {
		return filesCount;
	}

	public void setFilesCount(int filesCount) {
		this.filesCount = filesCount;
	}

	public int getNotescount() {
		return notesCount;
	}

	public void setNotescount(int notesCount) {
		this.notesCount = notesCount;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public int getEmailMessagesCount() {
		return emailMessagesCount;
	}

	public void setEmailMessagesCount(int emailMessagesCount) {
		this.emailMessagesCount = emailMessagesCount;
	}

	public int getActivitiesCount() {
		return activitiesCount;
	}

	public void setActivitiesCount(int activitiesCount) {
		this.activitiesCount = activitiesCount;
	}

	public int getDoneActivitiesCount() {
		return doneActivitiesCount;
	}

	public void setDoneActivitiesCount(int doneActivitiesCount) {
		this.doneActivitiesCount = doneActivitiesCount;
	}

	public int getUndoneActivitiesCount() {
		return undoneActivitiesCount;
	}

	public void setUndoneActivitiesCount(int undoneActivitiesCount) {
		this.undoneActivitiesCount = undoneActivitiesCount;
	}

	public int getReferenceActivitiesCount() {
		return referenceActivitiesCount;
	}

	public void setReferenceActivitiesCount(int referenceActivitiesCount) {
		this.referenceActivitiesCount = referenceActivitiesCount;
	}

	public int getParticipantsCount() {
		return participantsCount;
	}

	public void setParticipantsCount(int participantsCount) {
		this.participantsCount = participantsCount;
	}

	public String getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public void setExpectedCloseDate(String expectedCloseDate) {
		this.expectedCloseDate = expectedCloseDate;
	}

	public String getLastIncomingMailTime() {
		return lastIncomingMailTime;
	}

	public void setLastIncomingMailTime(String lastIncomingMailTime) {
		this.lastIncomingMailTime = lastIncomingMailTime;
	}

	public String getLastOutgoingMailTime() {
		return lastOutgoingMailTime;
	}

	public void setLastOutgoingMailTime(String lastOutgoingMailTime) {
		this.lastOutgoingMailTime = lastOutgoingMailTime;
	}

	public int getStageOrderNr() {
		return stageOrderNr;
	}

	public void setStageOrderNr(int stageOrderNr) {
		this.stageOrderNr = stageOrderNr;
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

	public String getNextActivitySubject() {
		return nextActivitySubject;
	}

	public void setNextActivitySubject(String nextActivitySubject) {
		this.nextActivitySubject = nextActivitySubject;
	}

	public String getNextActivityType() {
		return nextActivityType;
	}

	public void setNextActivityType(String nextActivityType) {
		this.nextActivityType = nextActivityType;
	}

	public String getNextActivityDuration() {
		return nextActivityDuration;
	}

	public void setNextActivityDuration(String nextActivityDuration) {
		this.nextActivityDuration = nextActivityDuration;
	}

	public String getNextActivityNote() {
		return nextActivityNote;
	}

	public void setNextActivityNote(String nextActivityNote) {
		this.nextActivityNote = nextActivityNote;
	}

	public String getFormattedValue() {
		return formattedValue;
	}

	public void setFormattedValue(String formattedValue) {
		this.formattedValue = formattedValue;
	}

	public String getRottenTime() {
		return rottenTime;
	}

	public void setRottenTime(String rottenTime) {
		this.rottenTime = rottenTime;
	}

	public int getWeightedValue() {
		return weightedValue;
	}

	public void setWeightedValue(int weightedValue) {
		this.weightedValue = weightedValue;
	}

	public String getFormattedWeightedValue() {
		return formattedWeightedValue;
	}

	public void setFormattedWeightedValue(String formattedWeightedValue) {
		this.formattedWeightedValue = formattedWeightedValue;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getcCEmail() {
		return cCEmail;
	}

	public void setcCEmail(String cCEmail) {
		this.cCEmail = cCEmail;
	}

	public boolean getOrgHidden() {
		return orgHidden;
	}

	public void setOrgHidden(boolean orgHidden) {
		this.orgHidden = orgHidden;
	}

	public boolean getPersonHidden() {
		return personHidden;
	}

	public void setPersonHidden(boolean personHidden) {
		this.personHidden = personHidden;
	}
	
}
