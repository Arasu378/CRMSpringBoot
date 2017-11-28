package com.kyrostechnologies.crm.application.notes.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.notes.bussinesstier.NotesBussinessLogic;
import com.kyrostechnologies.crm.model.NotesModel;
import com.kyrostechnologies.crm.response.NotesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@Controller
public class NotesController {
    @Autowired
    private NotesBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.NOTES_BY_USER_PROFILE_ID)
    public @ResponseBody
    NotesResponse getNotesByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
        return bussinessLogic.getNotesByUserProfileId(UserProfileId);
    }
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.NOTES_BY_NOTE_ID)
    public @ResponseBody
    NotesResponse getNotesByNoteId(@PathVariable("NoteId")int NoteId){
        return bussinessLogic.getNotesByNotesId(NoteId);
    }
    @RequestMapping(method = RequestMethod.POST, value = APIUtils.NOTES)
    public @ResponseBody
    NotesResponse insertNotes(@RequestBody NotesModel model){
        return bussinessLogic.insertNotes(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.NOTES)
    public @ResponseBody
    NotesResponse updateNotes(@RequestBody NotesModel model){
        return bussinessLogic.updateNotes(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.NOTES)
    public @ResponseBody
    NotesResponse deleteNotes(@RequestBody NotesModel model){
        return bussinessLogic.deleteNotes(model);
    }
}
