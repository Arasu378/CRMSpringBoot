package com.kyrostechnologies.crm.application.userinterface.interfaceclass;

import com.kyrostechnologies.crm.model.UserInterfaceModel;
import com.kyrostechnologies.crm.response.UserInterfaceResponse;

public interface UserInterface {
    UserInterfaceResponse getUserInterfaceByUserProfileId(int UserProfileId);
    UserInterfaceResponse getUserInterfaceByUserInterfaceId(int UserInterfaceId);
    UserInterfaceResponse insertUserInterface(UserInterfaceModel model);
    UserInterfaceResponse updateUserInterface(UserInterfaceModel model);
    UserInterfaceResponse deleteUserInterface(UserInterfaceModel model);

}
