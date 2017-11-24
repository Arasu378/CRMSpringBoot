package com.kyrostechnologies.crm.application.person.bussinesstier;

import com.kyrostechnologies.crm.application.person.interfaceclass.PersonInterface;
import com.kyrostechnologies.crm.application.person.datatier.PersonDataTier;
import com.kyrostechnologies.crm.application.person.datatier.PersonEmailDataTier;
import com.kyrostechnologies.crm.application.person.datatier.PersonPhoneDataTier;
import com.kyrostechnologies.crm.dbconstants.OrganizationDBConstants;
import com.kyrostechnologies.crm.model.PersonEmailModel;
import com.kyrostechnologies.crm.model.PersonModel;
import com.kyrostechnologies.crm.model.PersonPhoneModel;
import com.kyrostechnologies.crm.response.PersonEmailResponse;
import com.kyrostechnologies.crm.response.PersonPhoneResponse;
import com.kyrostechnologies.crm.response.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonBussinessLogic implements PersonInterface {

    private static NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate){
        this.namedParameterJdbcTemplate=namedParameterJdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public PersonEmailResponse getPersonEmailByPersonEmailId(int PersonEmailId) {
        String query="CALL `UserSettings.PersonEmail_GetPersonEmailByPersonEmailId`("+PersonEmailId+");";;
        System.out.println("Query : "+query);
        List<PersonEmailModel>personEmailModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new PersonEmailDataTier());
        if(personEmailModelList!=null && personEmailModelList.size()!=0){
            return getPersonEmailResponse(true,"Success",personEmailModelList);
        }
        return getPersonEmailResponse(false,"list is empty or null",null);
    }

    @Override
    public PersonEmailResponse getPersonEmailByPersonId(int PersonId) {
        String query="CALL `UserSettings.PersonEmail_GetPersonEmailByPersonId`("+PersonId+");";
        System.out.println("Query : "+query);
        List<PersonEmailModel>personEmailModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new PersonEmailDataTier());
        if(personEmailModelList!=null && personEmailModelList.size()!=0){
            return getPersonEmailResponse(true,"Success",personEmailModelList);
        }
        return getPersonEmailResponse(false,"list is empty or null",null);
    }

    @Override
    public PersonPhoneResponse getPersonPhoneByPersonPhoneId(int PersonPhoneId) {
        String query="CALL `UserSettings.PersonPhone_GetPersonPhoneByPersonPhoneId` ("+PersonPhoneId+")";
        System.out.println("Query : "+query);
        List<PersonPhoneModel>personPhoneModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new PersonPhoneDataTier());
        if(personPhoneModelList!=null&&personPhoneModelList.size()!=0){
            return getPersonPhoneResponse(true,"Success",personPhoneModelList);
        }
        return getPersonPhoneResponse(false,"List is empty or null",null);
    }

    @Override
    public  PersonPhoneResponse getPersonPhoneByPersonId(int PersonId) {
        String query="CALL `UserSettings.PersonPhone_GetPersonPhoneByPersonId` ("+PersonId+")";
        System.out.println("Query : "+query);
        List<PersonPhoneModel>personPhoneModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new PersonPhoneDataTier());
        if(personPhoneModelList!=null&&personPhoneModelList.size()!=0){
            return getPersonPhoneResponse(true,"Success",personPhoneModelList);
        }
        return getPersonPhoneResponse(false,"List is empty or null",null);
    }
    public static List<PersonPhoneModel>getPersonPhoneByPersonIdStatic(int PersonId){
        String query="CALL `UserSettings.PersonPhone_GetPersonPhoneByPersonId` ("+PersonId+")";
        System.out.println("Query : "+query);
        List<PersonPhoneModel>personPhoneModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new PersonPhoneDataTier());

        return personPhoneModelList;
    }
    public static List<PersonEmailModel>getPersonEmailByPersonIdStatic(int PersonId){
        String query="CALL `UserSettings.PersonEmail_GetPersonEmailByPersonId`("+PersonId+");";
        System.out.println("Query : "+query);
        List<PersonEmailModel>personEmailModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new PersonEmailDataTier());

        return personEmailModelList;
    }

    @Override
    public int insertPersonEmail(int PersonId,List<PersonEmailModel>personEmailModelList) {
        int finalvalue=0;
        if(personEmailModelList!=null&&personEmailModelList.size()!=0){
            for(PersonEmailModel model:personEmailModelList){
                String label=model.getLabel();
                label="'"+label+"'";
                String value=model.getValue();
                value="'"+value+"'";
                boolean primary=model.getPrimary();

                String query="CALL `UserSettings.PersonEmail_InsertPersonEmail` ("+label+","+value+","+primary+","+PersonId+")";
                System.out.println("Query : "+query);
                ResultSet rs=jdbcTemplate.execute((StatementCallback<ResultSet>)statement-> statement.executeQuery(query));
                try {
                    while(rs.next()){
                        finalvalue=rs.getInt(OrganizationDBConstants.LAST_INSERT_ID);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return finalvalue;
    }

    @Override
    public int insertPersonPhone(int PersonId, List<PersonPhoneModel> personPhoneModelList) {
        int finalvalue=0;
        if(personPhoneModelList!=null&&personPhoneModelList.size()!=0){
            for(PersonPhoneModel model:personPhoneModelList){
                String label=model.getLabel();
                label="'"+label+"'";
                String value=model.getValue();
                value="'"+value+"'";
                boolean primary=model.getPrimary();

                String query ="CALL  `UserSettings.PersonPhone_InsertPipeDrivePersonPhone`("+label+","+value+","+primary+","+PersonId+")";
                System.out.println("Query : "+query);
                ResultSet rs=jdbcTemplate.execute((StatementCallback<ResultSet>)statement-> statement.executeQuery(query));
                try {
                    while(rs.next()){
                        finalvalue=rs.getInt(OrganizationDBConstants.LAST_INSERT_ID);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return finalvalue;
    }

    @Override
    public PersonEmailResponse updatePersonEmail(PersonEmailModel model) {
        return null;
    }

    @Override
    public PersonEmailResponse deletePersonEmail(PersonEmailModel model) {
        return null;
    }

    @Override
    public PersonPhoneResponse updatePersonPhone(PersonPhoneModel model) {
        return null;
    }

    @Override
    public PersonPhoneResponse deletePersonPhone(PersonPhoneModel model) {
        return null;
    }

    @Override
    public PersonResponse insertPersonPDrive(PersonModel model) {
       int personId=pDriveMethod(model);
        if(personId!=0){
            List<PersonPhoneModel>personPhoneList=model.getPersonPhoneList();
            int personPhoneValue=insertPersonPhone(personId, personPhoneList);
            if(personPhoneValue!=0){
                List<PersonEmailModel>personEmailList=model.getPersonEmailList();
                int personEmailValue=insertPersonEmail(personId, personEmailList);
                if(personEmailValue!=0){
                    int UserProfileId=model.getUserProfileId();
                    return getPersonByUserProfileId(UserProfileId);

                }
                return getPersonResponse(false,"Person email is not inserted",null);
            }
            return getPersonResponse(false,"Person Phone is not inserted",null);
        }

        return getPersonResponse(false,"Person not inserted",null);
    }

    @Override
    public PersonResponse getPersonByUserProfileId(int UserProfileId) {
        String query="CALL `UserSettings.Person_GetPersonByUserProfileId`("+UserProfileId+");";
        System.out.println("Query : "+query);
        List<PersonModel>personModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new PersonDataTier());
        if(personModelList!=null&&personModelList.size()!=0){
            return getPersonResponse(true,"Success",personModelList);
        }
        return getPersonResponse(false,"List is empty or null",null);
    }

    @Override
    public PersonResponse getPersonByPersonId(int PersonId) {
        String query="CALL `UserSettings.Person_GetPersonByPersonId`("+PersonId+");";
        System.out.println("Query : "+query);
        List<PersonModel>personModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new PersonDataTier());
        if(personModelList!=null&&personModelList.size()!=0){
            return getPersonResponse(true,"Success",personModelList);
        }
        return getPersonResponse(false,"List is empty or null",null);
    }

    @Override
    public PersonResponse insertPerson(PersonModel model) {
        String query="CALL `UserSettings.Person_InsertPerson`(?,?,?)";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setString(1, model.getName());
            preparedStatement.setInt(2, model.getUserProfileId());
            preparedStatement.setString(3, model.getCompanyCode());
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getPersonByUserProfileId(model.getUserProfileId());
        }
        return getPersonResponse(false,"Person  is not inserted",null);
    }

    @Override
    public PersonResponse updatePerson(PersonModel model) {
        String query="CALL `UserSettings.Person_UpdatePerson`(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println("Query : "+query);
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            int userProfileId=model.getUserProfileId();
            String userName=model.getUserName();
            preparedStatement.setString(1, userName);
            String modifiedDate=model.getModifiedDate();
            preparedStatement.setString(2, modifiedDate);

            String companyCode=model.getCompanyCode();
            preparedStatement.setString(3, companyCode);

            int orgId=model.getOrgId();
            preparedStatement.setInt(4, orgId);

            String name=model.getName();
            preparedStatement.setString(5, name);

            String firstName=model.getFirstName();
            preparedStatement.setString(6, firstName);

            String lastName=model.getLastName();
            preparedStatement.setString(7, lastName);

            int openDealsCount=model.getOpenDealsCount();
            preparedStatement.setInt(8, openDealsCount);

            int relatedOpenDealsCount=model.getRelatedOpenDealsCount();
            preparedStatement.setInt(9, relatedOpenDealsCount);

            int participantOpenDealsCount=model.getParticipantOpenDealsCount();
            preparedStatement.setInt(10, participantOpenDealsCount);

            int participantClosedDealsCount=model.getParticipantsClosedDealsCount();
            preparedStatement.setInt(11, participantClosedDealsCount);

            int emailMessagesCount=model.getEmailMessagesCount();
            preparedStatement.setInt(12, emailMessagesCount);

            int activitiesCount=model.getActivitiesCount();
            preparedStatement.setInt(13, activitiesCount);

            int doneActivitiesCount=model.getDoneActivitiesCount();
            preparedStatement.setInt(14, doneActivitiesCount);

            int undoneActivitiesCount=model.getUndoneActivitiesCount();
            preparedStatement.setInt(15, undoneActivitiesCount);

            int referenceActivitiesCount=model.getReferenceActivitiesCount();
            preparedStatement.setInt(16, referenceActivitiesCount);

            int filesCount=model.getFilesCount();
            preparedStatement.setInt(17, filesCount);

            int notesCount=model.getNotesCount();
            preparedStatement.setInt(18, notesCount);

            int followersCount=model.getFollowersCount();
            preparedStatement.setInt(19, followersCount);

            int wonDealsCount=model.getWonDealsCount();
            preparedStatement.setInt(20, wonDealsCount);

            int relatedWonDealsCount=model.getRelatedWonDealsCount();
            preparedStatement.setInt(21, relatedWonDealsCount);

            int lostDealsCount=model.getLostDealsCount();
            preparedStatement.setInt(22, lostDealsCount);

            int relatedLostDealsCount=model.getRelatedLostDealsCount();
            preparedStatement.setInt(23, relatedLostDealsCount);

            boolean activeFlag=model.getActiveFlag();
            preparedStatement.setBoolean(24, activeFlag);

            String firstChar=model.getFirstChar();
            preparedStatement.setString(25, firstChar);

            int visibleTo=model.getVisibleTo();
            preparedStatement.setInt(26, visibleTo);

            int pictureId=model.getPictureId();
            preparedStatement.setInt(27, pictureId);

            String nextActivityDate=model.getNextActivityDate();
            preparedStatement.setString(28, nextActivityDate);

            String nextActivityTime=model.getNextActivityTime();
            preparedStatement.setString(29, nextActivityTime);

            int nextActivityId=model.getNextActivityId();
            preparedStatement.setInt(30, nextActivityId);

            int lastActivityId=model.getLastActivityId();
            preparedStatement.setInt(31, lastActivityId);

            String lastActivityDate=model.getLastActivityDate();
            preparedStatement.setString(32, lastActivityDate);

            String timeLineLastActivityTime=model.getTimeLineLastActivityTime();
            preparedStatement.setString(33, timeLineLastActivityTime);

            String timeLineLastActivityTimeByOwner=model.getTimeLineLastActivityTimeByOwner();
            preparedStatement.setString(34, timeLineLastActivityTimeByOwner);

            String lastIncomingMailTime=model.getLastIncomingMailTime();
            preparedStatement.setString(35, lastIncomingMailTime);

            String lastOutgoingMailTime=model.getLastOutgoingMailTime();
            preparedStatement.setString(36, lastOutgoingMailTime);

            String postalAddress=model.getPostalAddress();
            preparedStatement.setString(37, postalAddress);

            String postalAddressSubpremise=model.getPostalAddressSubpremise();
            preparedStatement.setString(38, postalAddressSubpremise);

            String postalAddressStreetNumber=model.getPostalAddressStreetNumber();
            preparedStatement.setString(39, postalAddressStreetNumber);

            String postalAddressRoute=model.getPostalAddressRoute();
            preparedStatement.setString(40, postalAddressRoute);

            String postalAddressSubLocality=model.getPostalAddressSubLocality();
            preparedStatement.setString(41, postalAddressSubLocality);

            String postalAddressLocality=model.getPostalAddressLocality();
            preparedStatement.setString(42, postalAddressLocality);

            String postalAddressAdminAreaLevel1=model.getPostalAddressAdminAreaLevel1();
            preparedStatement.setString(43, postalAddressAdminAreaLevel1);

            String postalAddressAdminAreaLevel2=model.getPostalAddressAdminAreaLevel2();
            preparedStatement.setString(44, postalAddressAdminAreaLevel2);

            String postalAddressCountry=model.getPostalAddressCountry();
            preparedStatement.setString(45, postalAddressCountry);

            String postalAddressPostalCode=model.getPostalAddressPostalCode();
            preparedStatement.setString(46, postalAddressPostalCode);

            String postalAddressFormattedAddress=model.getPostalAddressFormatAddress();
            preparedStatement.setString(47, postalAddressFormattedAddress);

            String orgName=model.getOrgName();
            preparedStatement.setString(48, orgName);

            String cCEmail=model.getCCEmail();
            preparedStatement.setString(49, cCEmail);

            int personId=model.getPersonId();
            preparedStatement.setInt(50, personId);

            return preparedStatement.executeUpdate();
        });
        if(isUpdated!=0){
            return getPersonByUserProfileId(model.getUserProfileId());
        }
        return getPersonResponse(false,"person is not updated",null);
    }

    @Override
    public PersonResponse deletePerson(PersonModel model) {
        String query="CALL `UserSettings.Person_DeletePerson`(?)";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1, model.getPersonId());
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return getPersonByUserProfileId(model.getUserProfileId());
        }
        return getPersonResponse(false,"Person is not deleted",null);
    }

    private PersonEmailResponse getPersonEmailResponse(boolean value, String message, List<PersonEmailModel>personEmailModelList){
        PersonEmailResponse response=new PersonEmailResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setPersonEmailList(personEmailModelList);
        return response;
    }
    private PersonPhoneResponse getPersonPhoneResponse(boolean value, String message, List<PersonPhoneModel>personPhoneModelList){
        PersonPhoneResponse response=new PersonPhoneResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setPersonPhoneList(personPhoneModelList);
        return response;
    }
    private PersonResponse getPersonResponse(boolean value,String message,List<PersonModel>personModelList){
        PersonResponse response=new PersonResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setPersonList(personModelList);
        return response;
    }
    private int pDriveMethod(PersonModel model){
        int finalvalue=0;
        String userName=model.getUserName();
        userName="'"+userName+"'";
        int userProfileId=model.getUserProfileId();
        String companyCode=model.getCompanyCode();
        companyCode="'"+companyCode+"'";
        int orgId=model.getOrgId();
        boolean activeFlag=model.getActiveFlag();
        int visibltTo=model.getVisibleTo();
        String orgName=model.getOrgName();
        orgName="'"+orgName+"'";
        String ownerName=model.getOwnerName();
        ownerName="'"+ownerName+"'";
        String query="CALL  `UserSettings.Person_InsertPipePerson`("+userName+","+userProfileId+","+companyCode+","+orgId+","+activeFlag+","+visibltTo+","+orgName+","+ownerName+");";
        System.out.println("Query : "+query);
        ResultSet rs=jdbcTemplate.execute((StatementCallback<ResultSet>) statement -> statement.executeQuery(query));
        try {
            while (rs.next()){
                finalvalue=rs.getInt(OrganizationDBConstants.LAST_INSERT_ID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return finalvalue;
    }
}
