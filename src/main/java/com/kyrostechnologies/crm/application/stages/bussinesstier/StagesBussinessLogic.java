package com.kyrostechnologies.crm.application.stages.bussinesstier;

import com.kyrostechnologies.crm.application.stages.datatier.StagesDataTier;
import com.kyrostechnologies.crm.application.stages.interfaceclass.StagesInterface;
import com.kyrostechnologies.crm.model.StagesModel;
import com.kyrostechnologies.crm.response.StagesResponse;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class StagesBussinessLogic  implements StagesInterface{
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate)throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public StagesResponse getStagesByStageId(int StageId) {
        String query="CALL `Settings.Stages_GetStageByStageId`("+StageId+")";
        System.out.println("Query : "+query);
        List<StagesModel>stagesModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new StagesDataTier());
        for(StagesModel model:stagesModelList){
            System.out.println(""+model.getName());
        }
        if(stagesModelList!=null&&stagesModelList.size()!=0){
            return getStagesResponse(true,"Success",stagesModelList);
        }else{
            return getStagesResponse(false,"Stages List is Empty or null!",null);
        }

    }

    @Override
    public StagesResponse getStagesByPipeLineId(int PipeLineId) {
        String query="CALL `Settings.Stages_GetStagesByPipeLineId`("+PipeLineId+")";
        System.out.println("Query : "+query);
        List<StagesModel>stagesModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new StagesDataTier());
        for(StagesModel model:stagesModelList){
            System.out.println(""+model.getName());
        }
        if(stagesModelList!=null&&stagesModelList.size()!=0){
            return getStagesResponse(true,"Success",stagesModelList);
        }else{
            return getStagesResponse(false,"Stages List is Empty or null!",null);
        }
    }

    @Override
    public StagesResponse insertStages(StagesModel model) {
        String query="CALL `Settings.Stages_InsertStages`(?,?,?,?,?,?,?);";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>) preparedStatement->{
            int value;
            preparedStatement.setInt(1,model.getUserProfileId() );
            preparedStatement.setInt(2,model.getPipeLineId() );
            preparedStatement.setString(3, model.getName());
            preparedStatement.setBoolean(4, model.getRotten());
            preparedStatement.setBoolean(5, model.getActiveFlag());
            preparedStatement.setBoolean(6, model.getDealProbability());
            preparedStatement.setString(7, model.getPipeLineName());
            value=preparedStatement.executeUpdate();
            return value;
        });
        if(isInserted!=0){
            return getStagesByPipeLineId(model.getPipeLineId());
        }else{
            return getStagesResponse(false,"Stages is not inserted",null);
        }
    }

    @Override
    public StagesResponse updateStages(StagesModel model) {
        String query="CALL `Settings.Stages_UpdateStages`(?,?,?,?,?,?,?,?,?,?);";
        System.out.println("Query : "+query);
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>) preparedStatement->{
            int value;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String dateModified=dateFormat.format(date);
            preparedStatement.setInt(1,model.getStageId() );
            preparedStatement.setString(2, model.getName());
            preparedStatement.setBoolean(3, model.getRotten());
            preparedStatement.setString(4, dateModified);
            preparedStatement.setInt(5,model.getOrderNr() );
            preparedStatement.setBoolean(6, model.getActiveFlag());
            preparedStatement.setBoolean(7, model.getDealProbability());
            preparedStatement.setBoolean(8, model.getRottenFlag());
            preparedStatement.setString(9, model.getRottenDays());
            preparedStatement.setString(10, model.getPipeLineName());
            value=preparedStatement.executeUpdate();
            return value;
        });
        if(isUpdated!=0){
            return getStagesByPipeLineId(model.getPipeLineId());
        }else{
            return getStagesResponse(false,"Stages is not updated",null);
        }
    }

    @Override
    public StagesResponse deleteStages(StagesModel model) {
        String query="CALL `Settings.Stages_DeleteStage`(?);";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>) preparedStatement->{
            int value;
            preparedStatement.setInt(1,model.getStageId() );
            value=preparedStatement.executeUpdate();
            return value;
        });
        if(isDeleted!=0){
            return getStagesByPipeLineId(model.getPipeLineId());
        }else{
            return getStagesResponse(false,"Stages is not deleted",null);
        }
    }
    private StagesResponse getStagesResponse(boolean success,String message,List<StagesModel>stagesModelList){
        StagesResponse response=new StagesResponse();
        response.setIsSuccess(success);
        response.setMessage(message);
        response.setStagesList(stagesModelList);
        return response;
    }
}
