package com.kyrostechnologies.crm.application.profilepicture.interfaceclass;

import com.kyrostechnologies.crm.model.ProfilePictureModel;
import com.kyrostechnologies.crm.response.ProfilePictureResponse;

public interface ProfilePictureInterface {
    ProfilePictureResponse getProfilePicture(int ProfilePictureId);
    ProfilePictureResponse insertProfilePicture(ProfilePictureModel model);
    ProfilePictureResponse updateProfilePicture(ProfilePictureModel model);
    ProfilePictureResponse deleteProfilePicture(ProfilePictureModel model);
}
