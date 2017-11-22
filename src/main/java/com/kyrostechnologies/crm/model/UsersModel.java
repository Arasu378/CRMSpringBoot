package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class UsersModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@JsonProperty("UserId")
	private int userId;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("DefaultCurrency")
	private String defaultCurrency;
	@JsonProperty("Locale")
	private String locale;
	@JsonProperty("Lang")
	private String lang;
	@JsonProperty("Email")
	private String email;
	@JsonProperty("Phone")
	private String phone;
	@JsonProperty("Activated")
	private boolean activated;
	@JsonProperty("LastLogin")
	private String lastLogin;
	@JsonProperty("Created")
	private String created;
	@JsonProperty("Modified")
	private String modified;
	@JsonProperty("SignupFlowVariation")
	private String signupFlowVariation;
	@JsonProperty("HasCreatedCompany")
	private boolean hasCreatedCompany;
	@JsonProperty("IsAdmin")
	private boolean isAdmin;
	@JsonProperty("TimeZoneName")
	private String timeZoneName;
	@JsonProperty("TimeZoneOffset")
	private String timeZoneOffset;
	@JsonProperty("ActiveFlag")
	private boolean activeFlag;
	@JsonProperty("RoleId")
	private int roleId;
	@JsonProperty("IconUrl")
	private String iconUrl;
	@JsonProperty("IsYou")
	private boolean isYou;
	@JsonProperty("UserProfileId")
	private int userProfileId;
	public UsersModel(){
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDefaultCurrency() {
		return defaultCurrency;
	}
	public void setDefaultCurrency(String defaultCurrency) {
		this.defaultCurrency = defaultCurrency;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean getActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getModified() {
		return modified;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}
	public String getSignupFlowVariation() {
		return signupFlowVariation;
	}
	public void setSignupFlowVariation(String signupFlowVariation) {
		this.signupFlowVariation = signupFlowVariation;
	}
	public boolean getHasCreatedCompany() {
		return hasCreatedCompany;
	}
	public void setHasCreatedCompany(boolean hasCreatedCompany) {
		this.hasCreatedCompany = hasCreatedCompany;
	}
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getTimeZoneName() {
		return timeZoneName;
	}
	public void setTimeZoneName(String timeZoneName) {
		this.timeZoneName = timeZoneName;
	}
	public String getTimeZoneOffset() {
		return timeZoneOffset;
	}
	public void setTimeZoneOffset(String timeZoneOffset) {
		this.timeZoneOffset = timeZoneOffset;
	}
	public boolean getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getIconUrl() {
		return iconUrl;
	}
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}
	public boolean getIsYou() {
		return isYou;
	}
	public void setIsYou(boolean isYou) {
		this.isYou = isYou;
	}
	public int getUserProfileId() {
		return userProfileId;
	}
	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}
	

}
