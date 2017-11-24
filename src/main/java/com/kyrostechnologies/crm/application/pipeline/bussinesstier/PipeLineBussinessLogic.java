package com.kyrostechnologies.crm.application.pipeline.bussinesstier;

import com.kyrostechnologies.crm.application.pipeline.PipeLineInterface;
import com.kyrostechnologies.crm.application.pipeline.datatier.PipeLineDataTier;
import com.kyrostechnologies.crm.model.PipeLineModel;
import com.kyrostechnologies.crm.response.PipeLineResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PipeLineBussinessLogic implements PipeLineInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public PipeLineResponse getPipeLine(int UserProfileId) {
        String query="CALL`Settings.PipeLine_GetPipeLineByUserProfileId`("+UserProfileId+");";
        System.out.println("Query : "+query);
        List<PipeLineModel>pipeLineModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new PipeLineDataTier());
        if(pipeLineModelList!=null&&pipeLineModelList.size()!=0){
            return getPipeLineResponse(true,"Success",pipeLineModelList);
        }
        return getPipeLineResponse(false,"list is empty or null",null);
    }

    @Override
    public PipeLineResponse insertPipeLine(PipeLineModel model) {
        String query="CALL `Settings.PipeLine_InsertPipeLine`(?,?,?,?);";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setString(1,model.getName() );
            preparedStatement.setInt(2, model.getUserProfileId());
            preparedStatement.setInt(3, model.getOrderNr());
            preparedStatement.setBoolean(4, model.getIsActive());
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getPipeLine(model.getUserProfileId());
        }
        return getPipeLineResponse(false,"Pipeline is not inserted",null);
    }

    @Override
    public PipeLineResponse updatePipeLine(PipeLineModel model) {
        String query="CALL`Settings.PipeLine_UpdatePipeLine`(?,?,?,?,?,?,?);";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setString(1,model.getName() );
            preparedStatement.setString(2,model.getDateModified() );
            preparedStatement.setInt(3, model.getOrderNr());
            preparedStatement.setBoolean(4, model.getIsActive());
            preparedStatement.setBoolean(5, model.getIsSelected());
            preparedStatement.setBoolean(6, model.getIsDealProbability());
            preparedStatement.setInt(7, model.getPipeLineId());
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getPipeLine(model.getUserProfileId());
        }
        return getPipeLineResponse(false,"Pipeline is not updated",null);
    }

    @Override
    public PipeLineResponse deletePipeLine(PipeLineModel model) {
        String query="CALL `Settings.PipeLine_DeletePipeLine`(?);";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1, model.getPipeLineId());
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getPipeLine(model.getUserProfileId());
        }
        return getPipeLineResponse(false,"Pipeline is not deleted",null);
    }
    private PipeLineResponse getPipeLineResponse(boolean value,String message,List<PipeLineModel>pipeLineModelList){
        PipeLineResponse response=new PipeLineResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setPipeLineList(pipeLineModelList);
        return response;
    }
}
