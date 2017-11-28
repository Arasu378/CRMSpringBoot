package com.kyrostechnologies.crm.application.deals.bussinesstier;

import com.kyrostechnologies.crm.application.deals.interfaceclass.DealsInterface;
import com.kyrostechnologies.crm.application.deals.datatier.DealsDataTier;
import com.kyrostechnologies.crm.model.DealModel;
import com.kyrostechnologies.crm.response.DealResponse;
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
public class DealsBussinessLogic implements DealsInterface{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public DealResponse getDealByUserProfileId(int UserProfileId) {
        String query="CALL `Company.Deal_GetCompanyByUserProfileId`("+UserProfileId+");";
        System.out.println("Query : "+query);
        List<DealModel>dealModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new DealsDataTier());
        if(dealModelList!=null && dealModelList.size()!=0){
            return getDealResponse(true,"Success",dealModelList);
        }
        return getDealResponse(false,"List is empty or null",null);
    }

    @Override
    public DealResponse getDealByDealId(int DealId) {
        String query="CALL `Company.Deal_GetDealByDealId`("+DealId+");";
        System.out.println("Query : "+query);
        List<DealModel>dealModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new DealsDataTier());
        if(dealModelList!=null && dealModelList.size()!=0){
            return getDealResponse(true,"Success",dealModelList);
        }
        return getDealResponse(false,"List is empty or null",null);
    }

    @Override
    public DealResponse insertDeals(DealModel model) {
        String query="CALL `Company.Deal_InsertDeal` (?,?,?,?,?,?,?,?)";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            String title=model.getTitle();
            preparedStatement.setString(1, title);
            int stageId=model.getStageId();
            preparedStatement.setInt(2, stageId);
            int pipeLineId=model.getPipeLineId();
            preparedStatement.setInt(3, pipeLineId);
            int userProfileId=model.getUserProfileId();
            preparedStatement.setInt(4, userProfileId);
            int personId=model.getPersonId();
            preparedStatement.setInt(5, personId);
            int organizationId=model.getOrganizationId();
            preparedStatement.setInt(6, organizationId);
            boolean active=model.getActive();
            preparedStatement.setBoolean(7, active);
            String ownerName=model.getOwnerName();
            preparedStatement.setString(8, ownerName);
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getDealByUserProfileId(model.getUserProfileId());
        }
        return getDealResponse(false,"deals is not inserted",null);
    }

    @Override
    public DealResponse updateDeals(DealModel model) {
        String query="CALL `Company.Deal_UpdateDeal`(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println("Query : "+query);
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)callableStatement->{
            int userProfileId=model.getUserProfileId();
            String title=model.getTitle();
            callableStatement.setString(1, title);
            String status=model.getStatus();
            callableStatement.setString(2, status);
            int value=model.getValue();
            callableStatement.setInt(3, value);
            String currency=model.getCurrency();
            callableStatement.setString(4, currency);
            int stageId=model.getStageId();
            callableStatement.setInt(5, stageId);
            int pipelineId=model.getPipeLineId();
            callableStatement.setInt(6, pipelineId);
            int personId=model.getPersonId();
            callableStatement.setInt(7, personId);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String updateTime= dateFormat.format(new Date());
            callableStatement.setString(8, updateTime);
            String stageChangeTime=model.getStageChangeTime();
            callableStatement.setString(9, stageChangeTime);
            boolean active=model.getActive();
            callableStatement.setBoolean(10, active);
            boolean deleted=model.getDeleted();
            callableStatement.setBoolean(11, deleted);
            String probability=model.getProbability();
            callableStatement.setString(12, probability);
            String nextActivityDate=model.getNextActivityDate();
            callableStatement.setString(13, nextActivityDate);
            String nextActivityTime=model.getNextActivityTime();
            callableStatement.setString(14, nextActivityTime);
            int nextActivityId=model.getNextActivityId();
            callableStatement.setInt(15, nextActivityId);
            int lastActivityId=model.getLastActivityId();
            callableStatement.setInt(16, lastActivityId);
            String lastActivityDate=model.getLastActivityDate();
            callableStatement.setString(17, lastActivityDate);
            String lostReason=model.getLostReason();
            callableStatement.setString(18, lostReason);
            int visibleTo=model.getVisibleTo();
            callableStatement.setInt(19, visibleTo);
            String closeTime=model.getCloseTime();
            callableStatement.setString(20, closeTime);
            String wonTime=model.getWonTime();
            callableStatement.setString(21, wonTime);
            String firstWonTime=model.getFirstWonTime();
            callableStatement.setString(22, firstWonTime);
            String lostTime=model.getLostTime();
            callableStatement.setString(23, lostTime);
            int productsCount=model.getProductsCount();
            callableStatement.setInt(24, productsCount);
            int filesCount=model.getFilesCount();
            callableStatement.setInt(25, filesCount);
            int notesCount=model.getNotescount();
            callableStatement.setInt(26, notesCount);
            int followersCount=model.getFollowersCount();
            callableStatement.setInt(27, followersCount);
            int emailMessagesCount=model.getEmailMessagesCount();
            callableStatement.setInt(28, emailMessagesCount);
            int activitiesCount=model.getActivitiesCount();
            callableStatement.setInt(29, activitiesCount);
            int doneActivitiesCount=model.getDoneActivitiesCount();
            callableStatement.setInt(30, doneActivitiesCount);
            int undoneActivitiesCount=model.getUndoneActivitiesCount();
            callableStatement.setInt(31, undoneActivitiesCount);
            int referenceActivitiesCount=model.getReferenceActivitiesCount();
            callableStatement.setInt(32, referenceActivitiesCount);
            int participantsCount=model.getParticipantsCount();
            callableStatement.setInt(33, participantsCount);
            String expectedCloseDate=model.getExpectedCloseDate();
            callableStatement.setString(34, expectedCloseDate);
            String lastIncomingMailTime=model.getLastIncomingMailTime();
            callableStatement.setString(35, lastIncomingMailTime);
            String lastOutgoingMailTime=model.getLastOutgoingMailTime();
            callableStatement.setString(36, lastOutgoingMailTime);
            int stageOrderNr=model.getStageOrderNr();
            callableStatement.setInt(37, stageOrderNr);
            String personName=model.getPersonName();
            callableStatement.setString(38, personName);
            String orgName=model.getOrgName();
            callableStatement.setString(39, orgName);
            String nextActivitySubject=model.getNextActivitySubject();
            callableStatement.setString(40, nextActivitySubject);
            String nextActivityType=model.getNextActivityType();
            callableStatement.setString(41, nextActivityType);
            String nextActivityDuration=model.getNextActivityDuration();
            callableStatement.setString(42, nextActivityDuration);
            String nextActivityNote=model.getNextActivityNote();
            callableStatement.setString(43, nextActivityNote);
            String formattedValue=model.getFormattedValue();
            callableStatement.setString(44, formattedValue);
            String rottenTime=model.getRottenTime();
            callableStatement.setString(45, rottenTime);
            int weightedValue=model.getWeightedValue();
            callableStatement.setInt(46, weightedValue);
            String formattedWeightedValue=model.getFormattedWeightedValue();
            callableStatement.setString(47, formattedWeightedValue);
            String ownerName=model.getOwnerName();
            callableStatement.setString(48, ownerName);
            String cCEmail=model.getcCEmail();
            callableStatement.setString(49, cCEmail);
            boolean orgHidden=model.getOrgHidden();
            callableStatement.setBoolean(50, orgHidden);
            boolean personHidden=model.getPersonHidden();
            callableStatement.setBoolean(51, personHidden);
            int dealId=model.getDealId();
            callableStatement.setInt(52, dealId);

            return callableStatement.executeUpdate();
        });
        if(isUpdated!=0){
            return getDealByUserProfileId(model.getUserProfileId());
        }
        return getDealResponse(false,"deals is not updated",null);
    }

    @Override
    public DealResponse deleteDeals(DealModel model) {
        String query="CALL `Company.Deal_DeleteDeal`(?)";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getDealId());
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return getDealByUserProfileId(model.getUserProfileId());
        }
        return getDealResponse(false,"deals is not deleted",null);
    }
    private DealResponse getDealResponse(boolean value, String message, List<DealModel>dealModelList){
        DealResponse response=new DealResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setDealList(dealModelList);
        return response;
    }
}
