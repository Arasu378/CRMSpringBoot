package com.kyrostechnologies.crm.application.pipeline.datatier;

import com.kyrostechnologies.crm.dbconstants.PipeLineDBConstants;
import com.kyrostechnologies.crm.model.PipeLineModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PipeLineDataTier implements RowMapper<PipeLineModel> {
    @Override
    public PipeLineModel mapRow(ResultSet rs, int i) throws SQLException {
        PipeLineModel pipModel=new PipeLineModel();
        int pipeLineId=rs.getInt(PipeLineDBConstants.PIPE_LINE_ID);
        pipModel.setPipeLineId(pipeLineId);
        int userProfileId=rs.getInt(PipeLineDBConstants.USER_PROFILE_ID);
        pipModel.setUserProfileId(userProfileId);
        String name=rs.getString(PipeLineDBConstants.NAME);
        pipModel.setName(name);
        String dateCreated=rs.getString(PipeLineDBConstants.DATE_CREATED);
        pipModel.setDateCreated(dateCreated);
        String dateModified=rs.getString(PipeLineDBConstants.DATE_MODIFIED);
        pipModel.setDateModified(dateModified);
        int orderNr=rs.getInt(PipeLineDBConstants.ORDER_NR);
        pipModel.setOrderNr(orderNr);
        boolean active=rs.getBoolean(PipeLineDBConstants.ACTIVE);
        pipModel.setIsActive(active);
        boolean selected=rs.getBoolean(PipeLineDBConstants.SELECTED);
        pipModel.setIsSelected(selected);
        boolean dealProbability=rs.getBoolean(PipeLineDBConstants.DEAL_PROBABILITY);
        pipModel.setIsDealProbability(dealProbability);
        String urlTitle=rs.getString(PipeLineDBConstants.URL_TITLE);
        pipModel.setUrlTitle(urlTitle);
        return pipModel;
    }
}
