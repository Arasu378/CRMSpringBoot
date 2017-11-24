package com.kyrostechnologies.crm.application.profilepicture.datatier;

import com.kyrostechnologies.crm.dbconstants.ProfilePictureDBConstants;
import com.kyrostechnologies.crm.model.ProfilePictureModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfilePictureDataTier implements RowMapper<ProfilePictureModel> {
    @Override
    public ProfilePictureModel mapRow(ResultSet rs, int i) throws SQLException {
        ProfilePictureModel model=new ProfilePictureModel();
        int profilePictureId=rs.getInt(ProfilePictureDBConstants.PROFILE_PICTURE_ID);
        int userProfileId=rs.getInt(ProfilePictureDBConstants.USER_PROFILE_ID);
        int attachmentId=rs.getInt(ProfilePictureDBConstants.ATTACHMENT_ID);
        model.setProfilePictureId(profilePictureId);
        model.setUserProfileId(userProfileId);
        model.setAttachmentId(attachmentId);
        return model;
    }
}
