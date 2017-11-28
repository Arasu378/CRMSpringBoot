package com.kyrostechnologies.crm.application.notes.datatier;

import com.kyrostechnologies.crm.dbconstants.NotesDBConstants;
import com.kyrostechnologies.crm.model.NotesModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NotesDataTier implements RowMapper<NotesModel> {
    @Override
    public NotesModel mapRow(ResultSet rs, int i) throws SQLException {
        NotesModel model=new NotesModel();
        int notesId=rs.getInt(NotesDBConstants.NOTE_ID);
        model.setNoteId(notesId);
        int userProfileId=rs.getInt(NotesDBConstants.USER_PROFILE_ID);
        model.setUserProfileId(userProfileId);
        int dealId=rs.getInt(NotesDBConstants.DEAL_ID);
        model.setDealId(dealId);
        int personId=rs.getInt(NotesDBConstants.PERSON_ID);
        model.setPersonId(personId);
        int orgId=rs.getInt(NotesDBConstants.ORG_ID);
        model.setOrgId(orgId);
        String content=rs.getString(NotesDBConstants.CONTENT);
        model.setContent(content);
        String dateCreated=rs.getString(NotesDBConstants.DATE_CREATED);
        model.setDateCreated(dateCreated);
        String dateModified=rs.getString(NotesDBConstants.DATE_MODIFIED);
        model.setDateModified(dateModified);
        boolean activeFlag=rs.getBoolean(NotesDBConstants.ACTIVE_FLAG);
        model.setActiveFlag(activeFlag);
        boolean pinnedToDealFlag=rs.getBoolean(NotesDBConstants.PINNED_TO_DEAL_FLAG);
        model.setPinnedToDealFlag(pinnedToDealFlag);
        boolean pinnedToPersonFlag=rs.getBoolean(NotesDBConstants.PINNED_TO_PERSON_FLAG);
        model.setPinnedToPersonFlag(pinnedToPersonFlag);
        boolean pinnedToOrganizationFlag=rs.getBoolean(NotesDBConstants.PINNED_TO_ORGANIZATION_FLAG);
        model.setPinnedToOrganizationFlag(pinnedToOrganizationFlag);
        int lastUpdateUserId=rs.getInt(NotesDBConstants.LAST_UPDATE_USER_ID);
        model.setLastUpdateUserId(lastUpdateUserId);
        int companyId=rs.getInt(NotesDBConstants.COMPANY_ID);
        model.setCompanyId(companyId);
        return model;
    }
}
