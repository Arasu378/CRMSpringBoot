package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="usersettings.notes")
public class NotesModel  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("NoteId")
	private int noteId;
	@JsonProperty("UserProfileId")
	private int userProfileId;
	@JsonProperty("DealId")
	private int dealId;
	@JsonProperty("PersonId")
	private int personId;
	@JsonProperty("OrgId")
	private int orgId;
	@JsonProperty("Content")
	private String content;
	@JsonProperty("DateCreated")
	private String dateCreated;
	@JsonProperty("DateModified")
	private String dateModified;
	@JsonProperty("ActiveFlag")
	private boolean activeFlag;
	@JsonProperty("PinnedToDealFlag")
	private boolean pinnedToDealFlag;
	@JsonProperty("PinnedToPersonFlag")
	private boolean pinnedToPersonFlag;
	@JsonProperty("PinnedToOrganizationFlag")
	private boolean pinnedToOrganizationFlag;
	@JsonProperty("LastUpdateUserId")
	private int lastUpdateUserId;
	@JsonProperty("CompanyId")
	private int companyId;
	public NotesModel(){
		
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public boolean getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public boolean getPinnedToDealFlag() {
		return pinnedToDealFlag;
	}
	public void setPinnedToDealFlag(boolean pinnedToDealFlag) {
		this.pinnedToDealFlag = pinnedToDealFlag;
	}
	public boolean getPinnedToPersonFlag() {
		return pinnedToPersonFlag;
	}
	public void setPinnedToPersonFlag(boolean pinnedToPersonFlag) {
		this.pinnedToPersonFlag = pinnedToPersonFlag;
	}
	public boolean getPinnedToOrganizationFlag() {
		return pinnedToOrganizationFlag;
	}
	public void setPinnedToOrganizationFlag(boolean pinnedToOrganizationFlag) {
		this.pinnedToOrganizationFlag = pinnedToOrganizationFlag;
	}
	public int getLastUpdateUserId() {
		return lastUpdateUserId;
	}
	public void setLastUpdateUserId(int lastUpdateUserId) {
		this.lastUpdateUserId = lastUpdateUserId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	

}
