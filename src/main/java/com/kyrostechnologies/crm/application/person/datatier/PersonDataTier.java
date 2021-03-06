package com.kyrostechnologies.crm.application.person.datatier;

import com.kyrostechnologies.crm.application.person.bussinesstier.PersonBussinessLogic;
import com.kyrostechnologies.crm.dbconstants.PersonDBConstants;
import com.kyrostechnologies.crm.model.PersonEmailModel;
import com.kyrostechnologies.crm.model.PersonModel;
import com.kyrostechnologies.crm.model.PersonPhoneModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonDataTier implements RowMapper<PersonModel> {
    @Override
    public PersonModel mapRow(ResultSet rs, int i) throws SQLException {
        PersonModel model=new PersonModel();
        int personId=rs.getInt(PersonDBConstants.ID);
        model.setPersonId(personId);
        List<PersonPhoneModel> personPhoneList= PersonBussinessLogic.getPersonPhoneByPersonIdStatic(personId);
        model.setPersonPhoneList(personPhoneList);
        List<PersonEmailModel>personEmailList= PersonBussinessLogic.getPersonEmailByPersonIdStatic(personId);
        model.setPersonEmailList(personEmailList);
        String userName=rs.getString(PersonDBConstants.USER_NAME);
        model.setUserName(userName);
        String createdDate=rs.getString(PersonDBConstants.CREATED_DATE);
        model.setCreatedDate(createdDate);
        String modifiedDate=rs.getString(PersonDBConstants.MODIFIED_DATE);
        model.setModifiedDate(modifiedDate);
        int userProfileId=rs.getInt(PersonDBConstants.USER_PROFILE_ID);
        model.setUserProfileId(userProfileId);
        String companyCode=rs.getString(PersonDBConstants.COMPANY_CODE);
        model.setCompanyCode(companyCode);
        int orgId=rs.getInt(PersonDBConstants.ORG_ID);
        model.setOrgId(orgId);
        String name=rs.getString(PersonDBConstants.NAME);
        model.setName(name);
        String firstName=rs.getString(PersonDBConstants.FIRST_NAME);
        model.setFirstName(firstName);
        String lastName=rs.getString(PersonDBConstants.LAST_NAME);
        model.setLastName(lastName);
        int openDealsCount=rs.getInt(PersonDBConstants.OPEN_DEALS_COUNT);
        model.setOpenDealsCount(openDealsCount);
        int relatedOpenDealsCount=rs.getInt(PersonDBConstants.RELATED_OPEN_DEALS_COUNT);
        model.setRelatedOpenDealsCount(relatedOpenDealsCount);
        int participantOpenDealsCount=rs.getInt(PersonDBConstants.PARTICIPANT_OPEN_DEALS_COUNT);
        model.setParticipantOpenDealsCount(participantOpenDealsCount);
        int participantsClosedDealsCount=rs.getInt(PersonDBConstants.PARTICIPANT_CLOSE_DEALS_COUNT);
        model.setParticipantsClosedDealsCount(participantsClosedDealsCount);
        int emailMessagesCount=rs.getInt(PersonDBConstants.EMAIL_MESSAGES_COUNT);
        model.setEmailMessagesCount(emailMessagesCount);
        int activitiesCount=rs.getInt(PersonDBConstants.ACTIVITIES_COUNT);
        model.setActivitiesCount(activitiesCount);
        int doneActivitiesCount=rs.getInt(PersonDBConstants.DONE_ACTIVITIES_COUNT);
        model.setDoneActivitiesCount(doneActivitiesCount);
        int undoneActivitiesCount=rs.getInt(PersonDBConstants.UNDONE_ACTIVITIES_COUNT);
        model.setUndoneActivitiesCount(undoneActivitiesCount);
        int referenceActivitiesCount=rs.getInt(PersonDBConstants.REFERENCE_ACTIVITIES_COUNT);
        model.setReferenceActivitiesCount(referenceActivitiesCount);
        int filesCount=rs.getInt(PersonDBConstants.FILES_COUNT);
        model.setFilesCount(filesCount);
        int notesCount=rs.getInt(PersonDBConstants.NOTES_COUNT);
        model.setNotesCount(notesCount);
        int followersCount=rs.getInt(PersonDBConstants.FOLLOWERS_COUNT);
        model.setFollowersCount(followersCount);
        int wonDealsCount=rs.getInt(PersonDBConstants.WON_DEALS_COUNT);
        model.setWonDealsCount(wonDealsCount);
        int relatedWonDealsCount=rs.getInt(PersonDBConstants.RELATED_WON_DEALS_COUNT);
        model.setRelatedWonDealsCount(relatedWonDealsCount);
        int lostDealsCount=rs.getInt(PersonDBConstants.LOST_DEALS_COUNT);
        model.setLostDealsCount(lostDealsCount);
        int relatedLostDealsCount=rs.getInt(PersonDBConstants.RelatedLostDealsCount);
        model.setRelatedLostDealsCount(relatedLostDealsCount);
        boolean activeFlag=rs.getBoolean(PersonDBConstants.ACTIVE_FLAG);
        model.setActiveFlag(activeFlag);
        String firstChar=rs.getString(PersonDBConstants.FIRST_CHAR);
        model.setFirstChar(firstChar);
        int visibleTo=rs.getInt(PersonDBConstants.VISIBLE_TO);
        model.setVisibleTo(visibleTo);
        int pictureId=rs.getInt(PersonDBConstants.PICTURE_ID);
        model.setPictureId(pictureId);
        String nextActivityDate=rs.getString(PersonDBConstants.NEXT_ACTIVITY_DATE);
        model.setNextActivityDate(nextActivityDate);
        String nextActivityTime=rs.getString(PersonDBConstants.NEXT_ACTIVITY_TIME);
        model.setNextActivityTime(nextActivityTime);
        int nextActivityId=rs.getInt(PersonDBConstants.NEXT_ACTIVITY_ID);
        model.setNextActivityId(nextActivityId);
        int lastActivityId=rs.getInt(PersonDBConstants.LAST_ACTIVITY_ID);
        model.setLastActivityId(lastActivityId);
        String lastActivityDate=rs.getString(PersonDBConstants.LAST_ACTIVITY_DATE);
        model.setLastActivityDate(lastActivityDate);
        String timeLineLastActivityTime=rs.getString(PersonDBConstants.TIME_LINE_LAST_ACTIVITY_TIME);
        model.setTimeLineLastActivityTime(timeLineLastActivityTime);
        String timeLineLastActivityTimeByOwner=rs.getString(PersonDBConstants.TIME_LINE_LAST_AVTIVITY_TIME_BYOWNER);
        model.setTimeLineLastActivityTimeByOwner(timeLineLastActivityTimeByOwner);
        String lastIncomingMailTime=rs.getString(PersonDBConstants.LAST_INCOMING_MAIL_TILE);
        model.setLastIncomingMailTime(lastIncomingMailTime);
        String lastOutgoingMailTime=rs.getString(PersonDBConstants.LAST_OUTGOING_MAIL_TIME);
        model.setLastOutgoingMailTime(lastOutgoingMailTime);
        String postalAddress=rs.getString(PersonDBConstants.POSTAL_ADDRESS);
        model.setPostalAddress(postalAddress);
        String postalAddressSubpremise=rs.getString(PersonDBConstants.POSTAL_ADDRESS_SUB_PREMISE);
        model.setPostalAddressSubpremise(postalAddressSubpremise);
        String postalAddressStreetNumber=rs.getString(PersonDBConstants.POSTAL_ADDRESS_STREET_NUMBER);
        model.setPostalAddressStreetNumber(postalAddressStreetNumber);
        String postalAddressRoute=rs.getString(PersonDBConstants.POSTAL_ADDRESS_ROUTE);
        model.setPostalAddressRoute(postalAddressRoute);
        String postalAddressSubLocality=rs.getString(PersonDBConstants.POSTAL_ADDRESS_SUB_LOCALITY);
        model.setPostalAddressSubLocality(postalAddressSubLocality);
        String postalAddressLocality=rs.getString(PersonDBConstants.POSTAL_ADDRESS_LOCALITY);
        model.setPostalAddressLocality(postalAddressLocality);
        String postalAddressAdminAreaLevel1=rs.getString(PersonDBConstants.POSTAL_ADDRESS_ADMIN_AREA_LEVEL_1);
        model.setPostalAddressAdminAreaLevel1(postalAddressAdminAreaLevel1);
        String postalAddressAdminAreaLevel2=rs.getString(PersonDBConstants.POSTAL_ADDRESS_ADMIN_AREA_LEVEL_2);
        model.setPostalAddressAdminAreaLevel2(postalAddressAdminAreaLevel2);
        String postalAddressCountry=rs.getString(PersonDBConstants.POSTAL_ADDRESS_COUNTRY);
        model.setPostalAddressCountry(postalAddressCountry);
        String postalAddressPostalCode=rs.getString(PersonDBConstants.POSTAL_ADDRESS_POSTAL_CODE);
        model.setPostalAddressPostalCode(postalAddressPostalCode);
        String postalAddressFormattedAddress=rs.getString(PersonDBConstants.POSTAL_ADDRESS_FORMATTED_ADDRESS);
        model.setPostalAddressFormatAddress(postalAddressFormattedAddress);
        String orgName=rs.getString(PersonDBConstants.ORG_NAME);
        model.setOrgName(orgName);
        String cCEmail=rs.getString(PersonDBConstants.CC_EMAIL);
        model.setCCEmail(cCEmail);
        String ownerName=rs.getString(PersonDBConstants.OWNER_NAME);
        model.setOwnerName(ownerName);
        return model;
    }
}
