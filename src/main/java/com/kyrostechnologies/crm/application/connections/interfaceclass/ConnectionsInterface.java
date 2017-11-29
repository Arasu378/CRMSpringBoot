package com.kyrostechnologies.crm.application.connections.interfaceclass;

import com.kyrostechnologies.crm.model.ConnectionsModel;
import com.kyrostechnologies.crm.response.ConnectionsResponse;

public interface ConnectionsInterface {
    ConnectionsResponse getConnectionByUserProfileId(int UserProfileId);
    ConnectionsResponse getConnectionByConnectionId(int ConnectionId);
    ConnectionsResponse insertConnections(ConnectionsModel model);
    ConnectionsResponse updateConnections(ConnectionsModel model);
    ConnectionsResponse deleteConnections(ConnectionsModel model);
}
