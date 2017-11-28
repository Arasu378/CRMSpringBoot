package com.kyrostechnologies.crm.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kyrostechnologies.crm.model.NotesModel;

public class NotesResponse {
	@JsonProperty("IsSuccess")
private boolean isSuccess;
	@JsonProperty("Message")
private String message;
	@JsonProperty("NotesList")
private List<NotesModel> notesList=new ArrayList<NotesModel>();
	@JsonProperty("Id")
private int id;
public NotesResponse(){
	
}
public boolean getIsSuccess() {
	return isSuccess;
}
public void setIsSuccess(boolean isSuccess) {
	this.isSuccess = isSuccess;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public List<NotesModel> getNotesList() {
	return notesList;
}
public void setNotesList(List<NotesModel> notesList) {
	this.notesList = notesList;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

}
