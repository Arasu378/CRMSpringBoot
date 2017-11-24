package com.kyrostechnologies.crm.application.stages.datatier;

import com.kyrostechnologies.crm.dbconstants.StagesDBConstants;
import com.kyrostechnologies.crm.model.StagesModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StagesDataTier implements RowMapper<StagesModel> {
    @Override
    public StagesModel mapRow(ResultSet rs, int i) throws SQLException {
        StagesModel model=new StagesModel();
        int stageId=rs.getInt(StagesDBConstants.STAGES_ID);
        model.setStageId(stageId);
        int userProfileId=rs.getInt(StagesDBConstants.USER_PROFILE_ID);
        model.setUserProfileId(userProfileId);
        int pipeLineId=rs.getInt(StagesDBConstants.PIPE_LINE_ID);
        model.setPipeLineId(pipeLineId);
        String name=rs.getString(StagesDBConstants.NAME);
        model.setName(name);
        boolean rotten=rs.getBoolean(StagesDBConstants.ROTTEN);
        model.setRotten(rotten);
        String dateCreated=rs.getString(StagesDBConstants.DATE_CREATED);
        model.setDateCreated(dateCreated);
        String dateModified=rs.getString(StagesDBConstants.DATE_MODIFIED);
        model.setDateModified(dateModified);
        int orderNr=rs.getInt(StagesDBConstants.ORDER_NR);
        model.setOrderNr(orderNr);
        boolean activeFlag=rs.getBoolean(StagesDBConstants.ACTIVE_FLAG);
        model.setActiveFlag(activeFlag);
        boolean dealProbability=rs.getBoolean(StagesDBConstants.DEAL_PROBABILITY);
        model.setDealProbability(dealProbability);
        boolean rottenFlag=rs.getBoolean(StagesDBConstants.ROTTEN_FLAG);
        model.setRottenFlag(rottenFlag);
        String rottenDays=rs.getString(StagesDBConstants.ROTTEN_DAYS);
        model.setRottenDays(rottenDays);
        String pipeLineName=rs.getString(StagesDBConstants.PIPE_LINE_NAME);
        model.setPipeLineName(pipeLineName);
        return model;
    }
}
