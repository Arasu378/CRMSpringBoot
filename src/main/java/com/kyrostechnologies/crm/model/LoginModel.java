package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;

public class LoginModel {
	@JsonProperty("UserEmail")
	private String userEmail;
	@JsonProperty("Password")
	private String password;
	@JsonProperty("UserProfileId")
private int userProfileId;
	@JsonProperty("CompanyId")
private int companyId;
	@JsonProperty("CompanyCode")
private String companyCode;
	@JsonProperty("CompanyName")
private String companyName;
	@JsonProperty("ConnectionId")
private int connectionId;
	@JsonProperty("IsConnectedToMailChimpAccount")
private boolean isConnectedToMailChimpAccount;
	@JsonProperty("MailChimpAccountEmail")
private String mailChimpAccountEmail;
	@JsonProperty("EmailIntegrationId")
private int emailIntegrationId;
	@JsonProperty("AlternativeEmailAddress")
private String alternativeEmailAddress;
	@JsonProperty("IsMyLinkedEmailsShared")
private boolean isMyLinkedEmailsShared;
	@JsonProperty("IsMyEmailConversationsPrivate")
private boolean isMyEmailConversationsPrivate;
	@JsonProperty("IsLinkMyEmailManually")
private boolean isLinkMyEmailManually;
	@JsonProperty("IsEmailLinkWithDeals")
private boolean isEmailLinkWithDeals;
	@JsonProperty("ContactId")
private int contactId;
	@JsonProperty("IsConnectedToGoogleAccount")
private boolean isConnectedToGoogleAccount;
	@JsonProperty("GoogleAccountEmail")
private String googleAccountEmail;
	@JsonProperty("DriveId")
private int driveId;
	@JsonProperty("ProfilePictureId")
private int profilePictureId;
	@JsonProperty("AttachmentId")
private int attachmentId;
	@JsonProperty("ReminderEmailId")
private int reminderEmailId;
	@JsonProperty("ReminderTypeId")
private String reminderTypeId;
	@JsonProperty("ReminderTimeId")
private String reminderTimeId;
	@JsonProperty("UserInterfaceId")
private int userInterfaceId;
	@JsonProperty("IsDeal")
private boolean isDeal;
	@JsonProperty("IsPerson")
private boolean isPerson;
	@JsonProperty("IsOrganization")
private boolean isOrganization;
	@JsonProperty("TimeZone")
private String timeZone;
	@JsonProperty("UserLocaleId")
private int userLocaleId;
	@JsonProperty("LanguageId")
private int languageId;
	@JsonProperty("CurrencyId")
private int currencyId;
	@JsonProperty("IsActive")
private boolean isActive;
	@JsonProperty("CreatedDate")
private String createdDate;
	@JsonProperty("ModifiedDate")
private String modifiedDate;
	@JsonProperty("HasPic")
private boolean hasPic;
	@JsonProperty("RegistrationId")
private int registrationId;
	@JsonProperty("EmailAddress")
private String emailAddress; 
	@JsonProperty("UserName")
private String userName;
	@JsonProperty("IndustryTypeId")
private int industryTypeId;
	@JsonProperty("LastLogin")
private String lastLogin;
	@JsonProperty("Token")
private String token;
	public LoginModel(){
		
	}
	
	
	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}


	public int getIndustryTypeId() {
		return industryTypeId;
	}


	public void setIndustryTypeId(int industryTypeId) {
		this.industryTypeId = industryTypeId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public int getRegistrationId() {
		return registrationId;
	}


	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
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


	public boolean isHasPic() {
		return hasPic;
	}


	public void setHasPic(boolean hasPic) {
		this.hasPic = hasPic;
	}


	public boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}


	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getUserLocaleId() {
		return userLocaleId;
	}

	public void setUserLocaleId(int userLocaleId) {
		this.userLocaleId = userLocaleId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}
	public boolean getIsConnectedToMailChimpAccount() {
		return isConnectedToMailChimpAccount;
	}
	public void setIsConnectedToMailChimpAccount(boolean isConnectedToMailChimpAccount) {
		this.isConnectedToMailChimpAccount = isConnectedToMailChimpAccount;
	}
	public String getMailChimpAccountEmail() {
		return mailChimpAccountEmail;
	}
	public void setMailChimpAccountEmail(String mailChimpAccountEmail) {
		this.mailChimpAccountEmail = mailChimpAccountEmail;
	}
	public int getEmailIntegrationId() {
		return emailIntegrationId;
	}
	public void setEmailIntegrationId(int emailIntegrationId) {
		this.emailIntegrationId = emailIntegrationId;
	}
	public String getAlternativeEmailAddress() {
		return alternativeEmailAddress;
	}
	public void setAlternativeEmailAddress(String alternativeEmailAddress) {
		this.alternativeEmailAddress = alternativeEmailAddress;
	}
	public boolean getIsMyLinkedEmailsShared() {
		return isMyLinkedEmailsShared;
	}
	public void setIsMyLinkedEmailsShared(boolean isMyLinkedEmailsShared) {
		this.isMyLinkedEmailsShared = isMyLinkedEmailsShared;
	}
	public boolean getIsMyEmailConversationsPrivate() {
		return isMyEmailConversationsPrivate;
	}
	public void setIsMyEmailConversationsPrivate(boolean isMyEmailConversationsPrivate) {
		this.isMyEmailConversationsPrivate = isMyEmailConversationsPrivate;
	}
	public boolean getIsLinkMyEmailManually() {
		return isLinkMyEmailManually;
	}
	public void setIsLinkMyEmailManually(boolean isLinkMyEmailManually) {
		this.isLinkMyEmailManually = isLinkMyEmailManually;
	}
	public boolean getIsEmailLinkWithDeals() {
		return isEmailLinkWithDeals;
	}
	public void setIsEmailLinkWithDeals(boolean isEmailLinkWithDeals) {
		this.isEmailLinkWithDeals = isEmailLinkWithDeals;
	}
	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public boolean getIsConnectedToGoogleAccount() {
		return isConnectedToGoogleAccount;
	}
	public void setIsConnectedToGoogleAccount(boolean isConnectedToGoogleAccount) {
		this.isConnectedToGoogleAccount = isConnectedToGoogleAccount;
	}
	public String getGoogleAccountEmail() {
		return googleAccountEmail;
	}
	public void setGoogleAccountEmail(String googleAccountEmail) {
		this.googleAccountEmail = googleAccountEmail;
	}
	public int getDriveId() {
		return driveId;
	}
	public void setDriveId(int driveId) {
		this.driveId = driveId;
	}
	public int getProfilePictureId() {
		return profilePictureId;
	}
	public void setProfilePictureId(int profilePictureId) {
		this.profilePictureId = profilePictureId;
	}
	public int getAttachmentId() {
		return attachmentId;
	}
	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}
	public int getReminderEmailId() {
		return reminderEmailId;
	}
	public void setReminderEmailId(int reminderEmailId) {
		this.reminderEmailId = reminderEmailId;
	}
	public String getReminderTypeId() {
		return reminderTypeId;
	}
	public void setReminderTypeId(String reminderTypeId) {
		this.reminderTypeId = reminderTypeId;
	}
	public String getReminderTimeId() {
		return reminderTimeId;
	}
	public void setReminderTimeId(String reminderTimeId) {
		this.reminderTimeId = reminderTimeId;
	}
	public int getUserInterfaceId() {
		return userInterfaceId;
	}
	public void setUserInterfaceId(int userInterfaceId) {
		this.userInterfaceId = userInterfaceId;
	}
	public boolean getIsDeal() {
		return isDeal;
	}
	public void setIsDeal(boolean isDeal) {
		this.isDeal = isDeal;
	}
	public boolean getIsPerson() {
		return isPerson;
	}
	public void setIsPerson(boolean isPerson) {
		this.isPerson = isPerson;
	}
	public boolean getIsOrganization() {
		return isOrganization;
	}
	public void setIsOrganization(boolean isOrganization) {
		this.isOrganization = isOrganization;
	}
	
}
