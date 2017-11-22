package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="settings.language")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name="`Settings.Language_GetLanguage`",
				procedureName = "`Settings.Language_GetLanguage`",
				resultClasses = {LanguageModel.class},
				parameters = {
						@StoredProcedureParameter(
								mode=ParameterMode.OUT,
								name="languageList",
								type=LanguageModel.class
						)
				}
		)
})
public class LanguageModel implements Serializable{
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="LanguageId")
@JsonProperty("LanguageId")
private int languageId;
@Column(name="LanguageCultureName")
@JsonProperty("LanguageCultureName")
private String languageCultureName;
@Column(name="LanguageName")
@JsonProperty("LanguageName")
private String languageName;
@Column(name="IsActive")
@JsonProperty("IsActive")
private boolean isActive;
@Column(name="CreatedDate")
@JsonProperty("CreatedDate")
private String createdDate;
@Column(name="ModifiedDate")
@JsonProperty("ModifiedDate")
private String modifiedDate;
public LanguageModel(){
	
}
public int getLanguageId() {
	return languageId;
}
public void setLanguageId(int languageId) {
	this.languageId = languageId;
}
public String getLanguageCultureName() {
	return languageCultureName;
}
public void setLanguageCultureName(String languageCultureName) {
	this.languageCultureName = languageCultureName;
}
public String getLanguageName() {
	return languageName;
}
public void setLanguageName(String languageName) {
	this.languageName = languageName;
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
