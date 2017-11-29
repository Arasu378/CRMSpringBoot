package com.kyrostechnologies.crm.application.connections.controller;

import com.kyrostechnologies.crm.application.APIUtils;
import com.kyrostechnologies.crm.application.connections.bussinesstier.ConnectionsBussinessLogic;
import com.kyrostechnologies.crm.model.ConnectionsModel;
import com.kyrostechnologies.crm.response.ConnectionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ConnectionsController {
    @Autowired
    private ConnectionsBussinessLogic bussinessLogic;
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.CONNECTIONS_BY_USER_PROFILE_ID)
    public @ResponseBody
    ConnectionsResponse getConnectionsByUserProfileId(@PathVariable("UserProfileId")int UserProfileId){
        return bussinessLogic.getConnectionByUserProfileId(UserProfileId);
    }
    @RequestMapping(method = RequestMethod.GET,value = APIUtils.CONNECTIONS_BY_CONNECTION_ID)
    public @ResponseBody
    ConnectionsResponse getConnectionsByConnectionId(@PathVariable("ConnectionId")int ConnectionId){
        return bussinessLogic.getConnectionByConnectionId(ConnectionId);
    }
    @RequestMapping(method = RequestMethod.POST,value = APIUtils.CONNECTIONS)
    public @ResponseBody
    ConnectionsResponse insertConnections(@RequestBody ConnectionsModel model){
        return bussinessLogic.insertConnections(model);
    }
    @RequestMapping(method = RequestMethod.PUT,value = APIUtils.CONNECTIONS)
    public @ResponseBody
    ConnectionsResponse updateConnections(@RequestBody ConnectionsModel model){
        return bussinessLogic.updateConnections(model);
    }
    @RequestMapping(method = RequestMethod.DELETE,value = APIUtils.CONNECTIONS)
    public @ResponseBody
    ConnectionsResponse deleteConnections(@RequestBody ConnectionsModel model){
        return bussinessLogic.deleteConnections(model);
    }
}
