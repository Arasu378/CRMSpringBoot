package com.kyrostechnologies.crm.application.profilepicture.bussinesstier;

import com.kyrostechnologies.crm.application.profilepicture.interfaceclass.ProfilePictureInterface;
import com.kyrostechnologies.crm.application.profilepicture.datatier.ProfilePictureDataTier;
import com.kyrostechnologies.crm.model.ProfilePictureModel;
import com.kyrostechnologies.crm.response.ProfilePictureResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfilePictureBussinessLogic implements ProfilePictureInterface {
   @Autowired
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
   @Autowired
   private JdbcTemplate jdbcTemplate;
    @Override
    public ProfilePictureResponse getProfilePicture(int ProfilePictureId) {
        String query="CALL `UserSettings.ProfilePicture_GetProfilePicturebyPictureId` ("+ProfilePictureId+");";
        System.out.println("Query : "+query);
        List<ProfilePictureModel>profilePictureModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new ProfilePictureDataTier());
        if(profilePictureModelList!=null && profilePictureModelList.size()!=0){
            return getProfilePictureResponse(true,"Success",profilePictureModelList);
        }
        return getProfilePictureResponse(false,"list is empty or null",null);
    }

    @Override
    public ProfilePictureResponse insertProfilePicture(ProfilePictureModel model) {
      String query="CALL `UserSettings.ProfilePicture_InsertProfilePicture`(?,?);";
      System.out.println("Query : "+query);
      int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
          preparedStatement.setInt(1,model.getUserProfileId() );
          preparedStatement.setInt(2,model.getAttachmentId() );
          return preparedStatement.executeUpdate();
      });
      if(isInserted!=0){
          return getProfilePicture(model.getProfilePictureId());
      }
        return getProfilePictureResponse(false,"profilePicture is not inserted",null);
    }

    @Override
    public ProfilePictureResponse updateProfilePicture(ProfilePictureModel model) {
        String query="CALL `UserSettings.ProfilePicture_UpdateProfilePicture`(?,?);";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getProfilePictureId() );
            preparedStatement.setInt(2,model.getAttachmentId() );
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getProfilePicture(model.getProfilePictureId());
        }
        return getProfilePictureResponse(false,"profilePicture is not updated",null);
    }

    @Override
    public ProfilePictureResponse deleteProfilePicture(ProfilePictureModel model) {
        String query="CALL `UserSettings.ProfilePicture_DeleteProfilePicture`(?);";
        System.out.println("Query : "+query);
        int isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<Integer>)preparedStatement->{
            preparedStatement.setInt(1,model.getProfilePictureId() );
            return preparedStatement.executeUpdate();
        });
        if(isInserted!=0){
            return getProfilePicture(model.getProfilePictureId());
        }
        return getProfilePictureResponse(false,"profilePicture is not deleted",null);
    }
    private ProfilePictureResponse getProfilePictureResponse(boolean value,String message,List<ProfilePictureModel>profilePictureModelList){
        ProfilePictureResponse response=new ProfilePictureResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setProfilePicture(profilePictureModelList);
        return response;
    }
}
