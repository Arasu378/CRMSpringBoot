package com.kyrostechnologies.crm.application.activities.datatier;

import com.kyrostechnologies.crm.dbconstants.ActivitiesDBConstants;
import com.kyrostechnologies.crm.model.ActivityModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActivityDataTier implements RowMapper<ActivityModel> {
    @Override
    public ActivityModel mapRow(ResultSet rs, int i) throws SQLException {
        ActivityModel model=new ActivityModel();
        int activityId=rs.getInt(ActivitiesDBConstants.ACTIVITY_ID);
        model.setActivityId(activityId);
        int companyId=rs.getInt(ActivitiesDBConstants.COMPANY_ID);
        model.setCompanyId(companyId);
        int userProfileId=rs.getInt(ActivitiesDBConstants.USER_PROFILE_ID);
        model.setUserProfileId(userProfileId);
        boolean done=rs.getBoolean(ActivitiesDBConstants.DONE);
        model.setDone(done);
        String type=rs.getString(ActivitiesDBConstants.TYPE);
        model.setType(type);
        String referenceType=rs.getString(ActivitiesDBConstants.REFERENCE_TYPE);
        model.setReferenceType(referenceType);
        String referenceId=rs.getString(ActivitiesDBConstants.REFERENCE_ID);
        model.setReferenceId(referenceId);
        String dueDate=rs.getString(ActivitiesDBConstants.DUE_DATE);
        model.setDueDate(dueDate);
        String dueTime=rs.getString(ActivitiesDBConstants.DUE_TIME);
        model.setDueTime(dueTime);
        String duration=rs.getString(ActivitiesDBConstants.DURATION);
        model.setDuration(duration);
        String addTime=rs.getString(ActivitiesDBConstants.ADD_TIME);
        model.setAddTime(addTime);
        String markedAsDoneTime=rs.getString(ActivitiesDBConstants.MARKED_AS_DONE_TIME);
        model.setMarkedAsDoneTime(markedAsDoneTime);
        String subject=rs.getString(ActivitiesDBConstants.SUBJECT);
        model.setSubject(subject);
        int  orgId=rs.getInt(ActivitiesDBConstants.ORG_ID);
        model.setOrgId(orgId);
        int personId=rs.getInt(ActivitiesDBConstants.PERSON_ID);
        model.setPersonId(personId);
        int dealId=rs.getInt(ActivitiesDBConstants.DEAL_ID);
        model.setDealId(dealId);
        boolean activeFlag=rs.getBoolean(ActivitiesDBConstants.ACTIVE_FLAG);
        model.setActiveFlag(activeFlag);
        String updateTime=rs.getString(ActivitiesDBConstants.UPDATE_TIME);
        model.setUpdateTime(updateTime);
        String gCalEventId=rs.getString(ActivitiesDBConstants.G_CAL_EVENT_ID);
        model.setGCalEventId(gCalEventId);
        String googleCalendarId=rs.getString(ActivitiesDBConstants.GOOGLE_CALENDAR_ID);
        model.setGoogleCalendarId(googleCalendarId);
        String googleCalendarETag=rs.getString(ActivitiesDBConstants.GOOGLE_CALENDAR_ETAG);
        model.setGoogleCalendarETag(googleCalendarETag);
        String note=rs.getString(ActivitiesDBConstants.NOTE);
        model.setNote(note);
        int createdByUserProfileId=rs.getInt(ActivitiesDBConstants.CREATED_BY_USER_PROFILE_ID);
        model.setCreatedByUserProfileId(createdByUserProfileId);
        String participants=rs.getString(ActivitiesDBConstants.PARTICIPANTS);
        model.setParticipants(participants);
        String orgName=rs.getString(ActivitiesDBConstants.ORG_NAME);
        model.setOrgName(orgName);
        String personName=rs.getString(ActivitiesDBConstants.PERSON_NAME);
        model.setPersonName(personName);
        String dealTitle=rs.getString(ActivitiesDBConstants.DEAL_TITLE);
        model.setDealTitle(dealTitle);
        String ownerName=rs.getString(ActivitiesDBConstants.OWNER_NAME);
        model.setOwnerName(ownerName);
        String personDropBoxBcc=rs.getString(ActivitiesDBConstants.PERSON_DROP_BOX_BCC);
        model.setPersonDropBoxBcc(personDropBoxBcc);
        String dealDropBoxBcc=rs.getString(ActivitiesDBConstants.DEAL_DROP_BOX_BCC);
        model.setDealDropBoxBcc(dealDropBoxBcc);
        int assignedToUserProfileId=rs.getInt(ActivitiesDBConstants.ASSIGNED_TO_USER_PROFILE_ID);
        model.setAssignedToUserProfileId(assignedToUserProfileId);
        return model;
    }
}
