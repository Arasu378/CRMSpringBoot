package com.kyrostechnologies.crm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
@Entity
@Table(name="settings.industrytype")
public class IndustryTypeModel  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("IndustryTypeId")
	private int industryTypeId;
	@JsonProperty("TypeName")
	private String typeName;
	@JsonProperty("IsActive")
	private boolean isActive;
	@JsonProperty("CreatedDate")
	private String createdDate;
	@JsonProperty("ModifiedDate")
	private String modifiedDate;
	public IndustryTypeModel(){
		
	}
	public int getIndustryTypeId() {
		return industryTypeId;
	}
	public void setIndustryTypeId(int industryTypeId) {
		this.industryTypeId = industryTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
