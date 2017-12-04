package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="company.registration")
public class RegistrationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("RegistrationId")
private int registrationId;
	@JsonProperty("CompanyCode")
private String companyCode;
	@JsonProperty("EmailAddress")
private String emailAddress;
	@JsonProperty("UserPassword")
private String userPassword;
	@JsonProperty("UserName")
private String userName;
	@JsonProperty("CompanyName")
private String companyName;
	@JsonProperty("IndustryTypeId")
private int industryTypeId;
	@JsonProperty("LastLoginOn")
private String lastLoginOn;
	@JsonProperty("IsActive")
private boolean isActive;
	@JsonProperty("CreatedDate")
private String createdDate;
	@JsonProperty("ModifiedDate")
private String modifiedDate;
	@JsonProperty("UserProfileId")
	private int userProfileId;
	@JsonProperty("TimeZone")
	private String timeZone;
	@JsonProperty("UserLocaleId")
	private int userLocaleId;
	@JsonProperty("LanguageId")
	private int languageId;
	@JsonProperty("CurrencyId")
	private int currencyId;
	public RegistrationModel(){
		
	}
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getIndustryTypeId() {
		return industryTypeId;
	}
	public void setIndustryTypeId(int industryTypeId) {
		this.industryTypeId = industryTypeId;
	}
	public String getLastLoginOn() {
		return lastLoginOn;
	}
	public void setLastLoginOn(String lastLoginOn) {
		this.lastLoginOn = lastLoginOn;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
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
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public int getUserLocaleId() {
		return userLocaleId;
	}
	public void setUserLocaleId(int userLocaleId) {
		this.userLocaleId = userLocaleId;
	}
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	public int getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}
	
	

}
