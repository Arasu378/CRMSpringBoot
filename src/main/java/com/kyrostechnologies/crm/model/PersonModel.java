package com.kyrostechnologies.crm.model;

import java.io.Serializable;
import java.util.ArrayList;


import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@JsonProperty("PersonId")
	private int personId;
	@JsonProperty("UserName")
	private String userName;
	@JsonProperty("CreatedDate")
	private String createdDate;
	@JsonProperty("ModifiedDate")
	private String modifiedDate;
	@JsonProperty("UserProfileId")
	private int userProfileId;
	@JsonProperty("CompanyCode")
	private String companyCode;
	@JsonProperty("OrgId")
	private int orgId;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("FirstName")
	private String firstName;
	@JsonProperty("LastName")
	private String lastName;
	@JsonProperty("OpenDealsCount")
	private int openDealsCount;
	@JsonProperty("RelatedOpenDealsCount")
	private int relatedOpenDealsCount;
	@JsonProperty("ParticipantOpenDealsCount")
	private int participantOpenDealsCount;
	@JsonProperty("ParticipantsClosedDealsCount")
	private int participantsClosedDealsCount;
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
	@JsonProperty("FilesCount")
	private int filesCount;
	@JsonProperty("NotesCount")
	private int notesCount;
	@JsonProperty("FollowersCount")
	private int followersCount;
	@JsonProperty("WonDealsCount")
	private int wonDealsCount;
	@JsonProperty("RelatedWonDealsCount")
	private int relatedWonDealsCount;
	@JsonProperty("LostDealsCount")
	private int lostDealsCount;
	@JsonProperty("RelatedLostDealsCount")
	private int relatedLostDealsCount;
	@JsonProperty("ActiveFlag")
	private boolean activeFlag;
	@JsonProperty("FirstChar")
	private String firstChar;
	@JsonProperty("VisibleTo")
	private int visibleTo;
	@JsonProperty("PictureId")
	private int pictureId;
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
	@JsonProperty("TimeLineLastActivityTime")
	private String timeLineLastActivityTime;
	@JsonProperty("TimeLineLastActivityTimeByOwner")
	private String timeLineLastActivityTimeByOwner;
	@JsonProperty("LastIncomingMailTime")
	private String lastIncomingMailTime;
	@JsonProperty("LastOutgoingMailTime")
	private String lastOutgoingMailTime;
	@JsonProperty("PostalAddress")
	private String postalAddress;
	@JsonProperty("PostalAddressSubpremise")
	private String postalAddressSubpremise;
	@JsonProperty("PostalAddressStreetNumber")
	private String postalAddressStreetNumber;
	@JsonProperty("PostalAddressRoute")
	private String postalAddressRoute;
	@JsonProperty("PostalAddressSubLocality")
	private String postalAddressSubLocality;
	@JsonProperty("PostalAddressLocality")
	private String postalAddressLocality;
	@JsonProperty("PostalAddressAdminAreaLevel1")
	private String postalAddressAdminAreaLevel1;
	@JsonProperty("PostalAddressAdminAreaLevel2")
	private String postalAddressAdminAreaLevel2;
	@JsonProperty("PostalAddressCountry")
	private String postalAddressCountry;
	@JsonProperty("PostalAddressPostalCode")
	private String postalAddressPostalCode;
	@JsonProperty("PostalAdressFormattedAddress")
	private String postalAdressFormattedAddress;
	@JsonProperty("OrgName")
	private String orgName;
	@JsonProperty("CCEmail")
	private String cCEmail;
	@JsonProperty("PostalAddressFormattedAddress")
	private String postalAddressFormattedAddress;
	@JsonProperty("ownerName")
	private String ownerName;
	@JsonProperty("PersonPhoneList")
	private ArrayList<PersonPhoneModel>personPhoneList=new ArrayList<PersonPhoneModel>();
	@JsonProperty("PersonEmailList")
	private ArrayList<PersonEmailModel>personEmailList=new ArrayList<PersonEmailModel>();
	@JsonProperty("Label")
	private String label;
	@JsonProperty("Value")
	private String value;
	@JsonProperty("Primary")
	private boolean primary;
	
	
	public PersonModel(){
		
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean getPrimary() {
		return primary;
	}

	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	public ArrayList<PersonPhoneModel> getPersonPhoneList() {
		return personPhoneList;
	}

	public void setPersonPhoneList(ArrayList<PersonPhoneModel> personPhoneList) {
		this.personPhoneList = personPhoneList;
	}

	public ArrayList<PersonEmailModel> getPersonEmailList() {
		return personEmailList;
	}

	public void setPersonEmailList(ArrayList<PersonEmailModel> personEmailList) {
		this.personEmailList = personEmailList;
	}

	public String getPostalAddressFormatAddress() {
		return postalAddressFormattedAddress;
	}

	public void setPostalAddressFormatAddress(String postalAddressFormatAddress) {
		this.postalAddressFormattedAddress = postalAddressFormatAddress;
	}

	public int getPersonId() {
		return personId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode2) {
		this.companyCode = companyCode2;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getOpenDealsCount() {
		return openDealsCount;
	}

	public void setOpenDealsCount(int openDealsCount) {
		this.openDealsCount = openDealsCount;
	}

	public int getRelatedOpenDealsCount() {
		return relatedOpenDealsCount;
	}

	public void setRelatedOpenDealsCount(int relatedOpenDealsCount) {
		this.relatedOpenDealsCount = relatedOpenDealsCount;
	}

	public int getParticipantOpenDealsCount() {
		return participantOpenDealsCount;
	}

	public void setParticipantOpenDealsCount(int participantOpenDealsCount) {
		this.participantOpenDealsCount = participantOpenDealsCount;
	}

	public int getParticipantsClosedDealsCount() {
		return participantsClosedDealsCount;
	}

	public void setParticipantsClosedDealsCount(int participantsClosedDealsCount) {
		this.participantsClosedDealsCount = participantsClosedDealsCount;
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

	public int getFilesCount() {
		return filesCount;
	}

	public void setFilesCount(int filesCount) {
		this.filesCount = filesCount;
	}

	public int getNotesCount() {
		return notesCount;
	}

	public void setNotesCount(int notesCount) {
		this.notesCount = notesCount;
	}

	public int getFollowersCount() {
		return followersCount;
	}

	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}

	public int getWonDealsCount() {
		return wonDealsCount;
	}

	public void setWonDealsCount(int wonDealsCount) {
		this.wonDealsCount = wonDealsCount;
	}

	public int getRelatedWonDealsCount() {
		return relatedWonDealsCount;
	}

	public void setRelatedWonDealsCount(int relatedWonDealsCount) {
		this.relatedWonDealsCount = relatedWonDealsCount;
	}

	public int getLostDealsCount() {
		return lostDealsCount;
	}

	public void setLostDealsCount(int lostDealsCount) {
		this.lostDealsCount = lostDealsCount;
	}

	public int getRelatedLostDealsCount() {
		return relatedLostDealsCount;
	}

	public void setRelatedLostDealsCount(int relatedLostDealsCount) {
		this.relatedLostDealsCount = relatedLostDealsCount;
	}

	public boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getFirstChar() {
		return firstChar;
	}

	public void setFirstChar(String firstChar) {
		this.firstChar = firstChar;
	}

	public int getVisibleTo() {
		return visibleTo;
	}

	public void setVisibleTo(int visibleTo) {
		this.visibleTo = visibleTo;
	}

	public int getPictureId() {
		return pictureId;
	}

	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
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

	public String getTimeLineLastActivityTime() {
		return timeLineLastActivityTime;
	}

	public void setTimeLineLastActivityTime(String timeLineLastActivityTime) {
		this.timeLineLastActivityTime = timeLineLastActivityTime;
	}

	public String getTimeLineLastActivityTimeByOwner() {
		return timeLineLastActivityTimeByOwner;
	}

	public void setTimeLineLastActivityTimeByOwner(
			String timeLineLastActivityTimeByOwner) {
		this.timeLineLastActivityTimeByOwner = timeLineLastActivityTimeByOwner;
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

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getPostalAddressSubpremise() {
		return postalAddressSubpremise;
	}

	public void setPostalAddressSubpremise(String postalAddressSubpremise) {
		this.postalAddressSubpremise = postalAddressSubpremise;
	}

	public String getPostalAddressStreetNumber() {
		return postalAddressStreetNumber;
	}

	public void setPostalAddressStreetNumber(String postalAddressStreetNumber) {
		this.postalAddressStreetNumber = postalAddressStreetNumber;
	}

	public String getPostalAddressRoute() {
		return postalAddressRoute;
	}

	public void setPostalAddressRoute(String postalAddressRoute) {
		this.postalAddressRoute = postalAddressRoute;
	}

	public String getPostalAddressSubLocality() {
		return postalAddressSubLocality;
	}

	public void setPostalAddressSubLocality(String postalAddressSubLocality) {
		this.postalAddressSubLocality = postalAddressSubLocality;
	}

	public String getPostalAddressLocality() {
		return postalAddressLocality;
	}

	public void setPostalAddressLocality(String postalAddressLocality) {
		this.postalAddressLocality = postalAddressLocality;
	}

	public String getPostalAddressAdminAreaLevel1() {
		return postalAddressAdminAreaLevel1;
	}

	public void setPostalAddressAdminAreaLevel1(String postalAddressAdminAreaLevel1) {
		this.postalAddressAdminAreaLevel1 = postalAddressAdminAreaLevel1;
	}

	public String getPostalAddressAdminAreaLevel2() {
		return postalAddressAdminAreaLevel2;
	}

	public void setPostalAddressAdminAreaLevel2(String postalAddressAdminAreaLevel2) {
		this.postalAddressAdminAreaLevel2 = postalAddressAdminAreaLevel2;
	}

	public String getPostalAddressCountry() {
		return postalAddressCountry;
	}

	public void setPostalAddressCountry(String postalAddressCountry) {
		this.postalAddressCountry = postalAddressCountry;
	}

	public String getPostalAddressPostalCode() {
		return postalAddressPostalCode;
	}

	public void setPostalAddressPostalCode(String postalAddressPostalCode) {
		this.postalAddressPostalCode = postalAddressPostalCode;
	}

	public String getPostalAdressFormattedAddress() {
		return postalAdressFormattedAddress;
	}

	public void setPostalAdressFormattedAddress(String postalAdressFormattedAddress) {
		this.postalAdressFormattedAddress = postalAdressFormattedAddress;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getCCEmail() {
		return cCEmail;
	}

	public void setCCEmail(String cCEmail) {
		this.cCEmail = cCEmail;
	}
	
	

}
