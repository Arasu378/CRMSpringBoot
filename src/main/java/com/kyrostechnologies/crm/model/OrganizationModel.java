package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="company.organization")
public class OrganizationModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("OrganizationId")
	private int organizationId;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("PeopleCount")
	private int peopleCount;
	@JsonProperty("OwnersUserProfileId")
	private int ownersUserProfileId;
	@JsonProperty("Address")
	private String address;
	@JsonProperty("CCEmail")
	private String cCEmail;
	@JsonProperty("CreatedDate")
	private String createdDate;
	@JsonProperty("ModifiedDate")
	private String modifiedDate;
	@JsonProperty("CompanyCode")
	private String companyCode;
	@JsonProperty("OpenDealsCount")
	private int openDealsCount;
	@JsonProperty("RelatedOpenDealsCount")
	private int relatedOpenDealsCount;
	@JsonProperty("ClosedDealsCount")
	private int closedDealsCount;
	@JsonProperty("RelatedClosedDealsCount")
	private int relatedClosedDealsCount;
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
	@JsonProperty("CategoryId")
	private int categoryId;
	@JsonProperty("PictureId")
	private int pictureId;
	@JsonProperty("CountryCode")
	private String countryCode;
	@JsonProperty("FirstChar")
	private String firstChar;
	@JsonProperty("VisibleTo")
	private int visibleTo;
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
	@JsonProperty("AddressSubpremise")
	private String addressSubpremise;
	@JsonProperty("AddressStreetNumber")
	private String addressStreetNumber;
	@JsonProperty("AddressRoute")
	private String addressRoute;
	@JsonProperty("AddressSubLocality")
	private String addressSubLocality;
	@JsonProperty("AddressLocality")
	private String addressLocality;
	@JsonProperty("AddressAdminAreaLevel1")
	private String addressAdminAreaLevel1;
	@JsonProperty("AddressAdminAreaLevel2")
	private String addressAdminAreaLevel2;
	@JsonProperty("AddressCountry")
	private String addressCountry;
	@JsonProperty("AddressPostalCode")
	private String addressPostalCode;
	@JsonProperty("AddressFormattedAddress")
	private String addressFormattedAddress;
	@JsonProperty("OwnerName")
	private String ownerName;
	public OrganizationModel(){
		
	}
	public int getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(int organizationId) {
		this.organizationId = organizationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPeopleCount() {
		return peopleCount;
	}
	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}
	public int getOwnersUserProfileId() {
		return ownersUserProfileId;
	}
	public void setOwnersUserProfileId(int ownersUserProfileId) {
		this.ownersUserProfileId = ownersUserProfileId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCCEmail() {
		return cCEmail;
	}
	public void setCCEmail(String cCEmail) {
		this.cCEmail = cCEmail;
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
	public int getRelatedOpenDealsCount() {
		return relatedOpenDealsCount;
	}
	public void setRelatedOpenDealsCount(int relatedOpenDealsCount) {
		this.relatedOpenDealsCount = relatedOpenDealsCount;
	}
	public int getClosedDealsCount() {
		return closedDealsCount;
	}
	public void setClosedDealsCount(int closedDealsCount) {
		this.closedDealsCount = closedDealsCount;
	}
	public int getRelatedClosedDealsCount() {
		return relatedClosedDealsCount;
	}
	public void setRelatedClosedDealsCount(int relatedClosedDealsCount) {
		this.relatedClosedDealsCount = relatedClosedDealsCount;
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
	public int getRelatedwonDealsCount() {
		return relatedWonDealsCount;
	}
	public void setRelatedwonDealsCount(int relatedwonDealsCount) {
		this.relatedWonDealsCount = relatedwonDealsCount;
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getPictureId() {
		return pictureId;
	}
	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
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
	public String getAddressSubpremise() {
		return addressSubpremise;
	}
	public void setAddressSubpremise(String addressSubpremise) {
		this.addressSubpremise = addressSubpremise;
	}
	public String getAddressStreetNumber() {
		return addressStreetNumber;
	}
	public void setAddressStreetNumber(String addressStreetNumber) {
		this.addressStreetNumber = addressStreetNumber;
	}
	public String getAddressRoute() {
		return addressRoute;
	}
	public void setAddressRoute(String addressRoute) {
		this.addressRoute = addressRoute;
	}
	public String getAddressSubLocality() {
		return addressSubLocality;
	}
	public void setAddressSubLocality(String addressSubLocality) {
		this.addressSubLocality = addressSubLocality;
	}
	public String getAddressLocality() {
		return addressLocality;
	}
	public void setAddressLocality(String addressLocality) {
		this.addressLocality = addressLocality;
	}
	public String getAddressAdminAreaLevel1() {
		return addressAdminAreaLevel1;
	}
	public void setAddressAdminAreaLevel1(String addressAdminAreaLevel1) {
		this.addressAdminAreaLevel1 = addressAdminAreaLevel1;
	}
	public String getAddressAdminAreaLevel2() {
		return addressAdminAreaLevel2;
	}
	public void setAddressAdminAreaLevel2(String addressAdminAreaLevel2) {
		this.addressAdminAreaLevel2 = addressAdminAreaLevel2;
	}
	public String getAddressCountry() {
		return addressCountry;
	}
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	public String getAddressPostalCode() {
		return addressPostalCode;
	}
	public void setAddressPostalCode(String addressPostalCode) {
		this.addressPostalCode = addressPostalCode;
	}
	public String getAddressFormattedAddress() {
		return addressFormattedAddress;
	}
	public void setAddressFormattedAddress(String addressFormattedAddress) {
		this.addressFormattedAddress = addressFormattedAddress;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	

}
