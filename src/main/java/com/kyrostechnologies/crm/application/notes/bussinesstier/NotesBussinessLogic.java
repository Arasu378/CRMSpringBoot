package com.kyrostechnologies.crm.application.notes.bussinesstier;

import com.kyrostechnologies.crm.application.notes.datatier.NotesDataTier;
import com.kyrostechnologies.crm.application.notes.interfaceclass.NotesInterface;
import com.kyrostechnologies.crm.model.NotesModel;
import com.kyrostechnologies.crm.response.NotesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class NotesBussinessLogic implements NotesInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public NotesResponse getNotesByUserProfileId(int UserProfileId) {
        String query="CALL `UserSettings.Notes_GetNotesByUserProfileId`("+UserProfileId+");";
        System.out.println("Query : "+query);
        List<NotesModel>notesModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new NotesDataTier());
        if(notesModelList!=null && notesModelList.size()!=0){
            return getNotesResponse(true,"Success",notesModelList);
        }
        return getNotesResponse(false,"List is empty or null",null);
    }

    @Override
    public NotesResponse getNotesByNotesId(int NoteId) {
        String query="CALL `UserSettings.Notes_GetNotesByNoteId`("+NoteId+");";
        System.out.println("Query : "+query);
        List<NotesModel>notesModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new NotesDataTier());
        if(notesModelList!=null && notesModelList.size()!=0){
            return getNotesResponse(true,"Success",notesModelList);
        }
        return getNotesResponse(false,"List is empty or null",null);
    }

    @Override
    public NotesResponse insertNotes(NotesModel model) {
        String query="CALL `UserSettings.Notes_InsertNotes`(?,?,?,?,?,?,?)";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getUserProfileId());
            preparedStatement.setInt(2,model.getDealId());
            preparedStatement.setInt(3,model.getPersonId());
            preparedStatement.setInt(4,model.getOrgId());
            preparedStatement.setString(5,model.getContent());
            preparedStatement.setBoolean(6,model.getActiveFlag());
            preparedStatement.setInt(7,model.getCompanyId());

            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getNotesByUserProfileId(model.getUserProfileId());
        }
        return getNotesResponse(false,"notes is not inserted",null);
    }

    @Override
    public NotesResponse updateNotes(NotesModel model) {
        String query="CALL `UserSettings.Notes_UpdateNotes`(?,?,?,?,?,?,?,?)";
        System.out.println("Query : "+query);
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            String content=model.getContent();
            preparedStatement.setString(1, content);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String dateModified=dateFormat.format(date);
            preparedStatement.setString(2, dateModified);
            boolean activeFlag=model.getActiveFlag();
            preparedStatement.setBoolean(3, activeFlag);
            boolean pinnedToDealFlag=model.getPinnedToDealFlag();
            preparedStatement.setBoolean(4, pinnedToDealFlag);
            boolean pinnedToPersonFlag=model.getPinnedToPersonFlag();
            preparedStatement.setBoolean(5, pinnedToPersonFlag);
            boolean pinnedToOrganizationFlag=model.getPinnedToOrganizationFlag();
            preparedStatement.setBoolean(6, pinnedToOrganizationFlag);
            int lastUpdateUserId=model.getLastUpdateUserId();
            preparedStatement.setInt(7, lastUpdateUserId);
            int noteId=model.getNoteId();
            preparedStatement.setInt(8, noteId);
            return preparedStatement.executeUpdate();
        });
        if(isUpdated!=0){
            return getNotesByUserProfileId(model.getUserProfileId());
        }
        return getNotesResponse(false,"notes is not updated",null);
    }

    @Override
    public NotesResponse deleteNotes(NotesModel model) {
        String query="CALL `UserSettings.Notes_DeleteNote`(?)";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1, model.getNoteId());
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return getNotesByUserProfileId(model.getUserProfileId());
        }
        return getNotesResponse(false,"note is not deleted",null);
    }
    private NotesResponse getNotesResponse(boolean value, String message, List<NotesModel>notesModelList){
        NotesResponse response=new NotesResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setNotesList(notesModelList);
        return response;
    }
}
