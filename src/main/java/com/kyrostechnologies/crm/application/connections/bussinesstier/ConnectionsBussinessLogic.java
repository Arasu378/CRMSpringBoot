package com.kyrostechnologies.crm.application.connections.bussinesstier;

import com.kyrostechnologies.crm.application.connections.interfaceclass.ConnectionsInterface;
import com.kyrostechnologies.crm.application.connections.datatier.ConnectionsDataTier;
import com.kyrostechnologies.crm.model.ConnectionsModel;
import com.kyrostechnologies.crm.response.ConnectionsResponse;
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
public class ConnectionsBussinessLogic implements ConnectionsInterface {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Override
    public ConnectionsResponse getConnectionByUserProfileId(int UserProfileId) {
        String query="CALL  `UserSettings.Connections_GetConnectionsByUserprofileid`("+UserProfileId+");";
        System.out.println("Query : "+query);
        List<ConnectionsModel>connectionsModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new ConnectionsDataTier());
        if(connectionsModelList!=null && connectionsModelList.size()!=0){
            return getConnectionsResponse(true,"Success",connectionsModelList);
        }
        return getConnectionsResponse(false,"List is empty or null",null);
    }

    @Override
    public ConnectionsResponse getConnectionByConnectionId(int ConnectionId) {
        String query="CALL  `UserSettings.Connections_GetConnectionsByConnectionId`("+ConnectionId+");";
        System.out.println("Query : "+query);
        List<ConnectionsModel>connectionsModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new ConnectionsDataTier());
        if(connectionsModelList!=null && connectionsModelList.size()!=0){
            return getConnectionsResponse(true,"Success",connectionsModelList);
        }
        return getConnectionsResponse(false,"List is empty or null",null);
    }

    @Override
    public ConnectionsResponse insertConnections(ConnectionsModel model) {
        String query="CALL `UserSettingsConnections.InsertConnections`(?,?,?,?,?)";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getUserProfileId() );
            preparedStatement.setBoolean(2, model.getIsConnectedToGoogleAccount());
            preparedStatement.setBoolean(3, model.getIsConnectedToMailChimpAccount());
            preparedStatement.setString(4, model.getGoogleAccountEmail());
            preparedStatement.setString(5, model.getMailChimpAccountEmail());
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getConnectionByUserProfileId(model.getUserProfileId());
        }
        return getConnectionsResponse(false,"connections is not inserted",null);
    }

    @Override
    public ConnectionsResponse updateConnections(ConnectionsModel model) {
        String query="CALL  `UserSettings.Connection_UpdateConnections`(?,?,?,?,?,?,?,?)";
        System.out.println("Query : "+query);
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String modifiedDate=dateFormat.format(new Date());
        int isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getConnectionId() );
            preparedStatement.setInt(2,model.getUserProfileId() );
            preparedStatement.setBoolean(3, model.getIsConnectedToGoogleAccount());
            preparedStatement.setBoolean(4, model.getIsConnectedToMailChimpAccount());
            preparedStatement.setString(5, model.getGoogleAccountEmail());
            preparedStatement.setString(6, model.getMailChimpAccountEmail());
            preparedStatement.setBoolean(7, model.getIsActive());
            preparedStatement.setString(8, modifiedDate);
            return preparedStatement.executeUpdate();
        });
        if(isUpdated!=0){
            return getConnectionByUserProfileId(model.getUserProfileId());
        }
        return getConnectionsResponse(false,"connection is not updated",null);
    }

    @Override
    public ConnectionsResponse deleteConnections(ConnectionsModel model) {
        String query="CALL `UserSettings.Connection_DeleteConnections`(?);";
        System.out.println("Query : "+query);
        int isDeleted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getConnectionId());
            return preparedStatement.executeUpdate();
        });
        if(isDeleted!=0){
            return getConnectionByUserProfileId(model.getUserProfileId());
        }
        return getConnectionsResponse(false,"Connectionis not deleted",null);
    }
    private ConnectionsResponse getConnectionsResponse(boolean value,String message,List<ConnectionsModel> connectionsModelList){
        ConnectionsResponse response=new ConnectionsResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setConnectionList(connectionsModelList);
        return response;
    }
}
