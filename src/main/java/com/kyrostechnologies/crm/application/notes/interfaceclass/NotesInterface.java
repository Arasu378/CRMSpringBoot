package com.kyrostechnologies.crm.application.notes.interfaceclass;

import com.kyrostechnologies.crm.model.NotesModel;
import com.kyrostechnologies.crm.response.NotesResponse;

public interface NotesInterface {
    NotesResponse getNotesByUserProfileId(int UserProfileId);
    NotesResponse getNotesByNotesId(int NoteId);
    NotesResponse insertNotes(NotesModel model);
    NotesResponse updateNotes(NotesModel model);
    NotesResponse deleteNotes(NotesModel model);
}
