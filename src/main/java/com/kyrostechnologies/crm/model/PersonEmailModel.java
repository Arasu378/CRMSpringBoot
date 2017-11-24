package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="usersettings.person")
public class PersonEmailModel implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("PersonEmailId")
private int personEmailId;
	@JsonProperty("Label")
private String label;
	@JsonProperty("Value")
private String value;
	@JsonProperty("Primary")
private boolean primary;
	@JsonProperty("CreatedDate")
private String createdDate;
	@JsonProperty("ModifiedDate")
private String modifiedDate;
	@JsonProperty("PersonId")
private int personId;
public PersonEmailModel(){
	
}
public int getPersonEmailId() {
	return personEmailId;
}
public void setPersonEmailId(int personEmailId) {
	this.personEmailId = personEmailId;
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
public int getPersonId() {
	return personId;
}
public void setPersonId(int personId) {
	this.personId = personId;
}

}
