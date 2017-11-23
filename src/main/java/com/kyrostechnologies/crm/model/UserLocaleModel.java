package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="settings.userlocale")
public class UserLocaleModel implements Serializable{
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@JsonProperty("UserLocaleId")
private int userLocaleId;
@JsonProperty("LocaleCode")
private String localeCode;
@JsonProperty("UserLocale")
private String userLocale;
@JsonProperty("IsActive")
private boolean isActive;
@JsonProperty("CreatedDate")
private String createdDate;
@JsonProperty("ModifiedDate")
private String modifiedDate;
public UserLocaleModel(){
	
}
public int getUserLocaleId() {
	return userLocaleId;
}
public void setUserLocaleId(int userLocaleId) {
	this.userLocaleId = userLocaleId;
}
public String getLocaleCode() {
	return localeCode;
}
public void setLocaleCode(String localeCode) {
	this.localeCode = localeCode;
}
public String getUserLocale() {
	return userLocale;
}
public void setUserLocale(String userLocale) {
	this.userLocale = userLocale;
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

}
