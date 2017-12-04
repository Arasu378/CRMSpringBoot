package com.kyrostechnologies.crm.application.login.bussinesstier;

import com.kyrostechnologies.crm.application.login.interfaceclass.LoginInterface;
import com.kyrostechnologies.crm.application.login.datatier.LoginDataTier;
import com.kyrostechnologies.crm.application.token.InsertTokenClass;
import com.kyrostechnologies.crm.dbconstants.LoginDBConstants;
import com.kyrostechnologies.crm.model.LoginModel;
import com.kyrostechnologies.crm.response.LoginResponse;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class LoginBussinessLogic implements LoginInterface {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    InsertTokenClass insertTokenClass;
    @Override
    public LoginResponse login(LoginModel model) {
        String userEmail=model.getUserEmail();
        userEmail="'"+userEmail+"'";
        String password=model.getPassword();
        byte[] encodedBytes = Base64.encodeBase64(password.getBytes());
        String new_encryptedpassword=new String (encodedBytes);
        new_encryptedpassword="'"+new_encryptedpassword+"'";
        String CompanyCode=getCompanyCode(userEmail,new_encryptedpassword);
        if(CompanyCode!=null){
            int  UserProfileId=getUserProfileId(CompanyCode);
            String token=generateToken(model.getUserEmail(),model.getPassword(),UserProfileId);
            boolean tokenAlreadyThere=insertTokenClass.isTokenThere(token);
            if(!tokenAlreadyThere){
                @SuppressWarnings("unused")
                boolean tokenValue= insertTokenClass.insertToken(UserProfileId,token);
            }


            if(UserProfileId!=0){
                return getLoginView(UserProfileId,token);
            }
            return getLoginResponse(false,"UserProfileId is zero",null);

        }
            return getLoginResponse(false,"Company code is empty or invalid useremail and password",null);


    }

    @Override
    public String getCompanyCode(String userEmail, String password) {
        String query="CALL `GetCompanyCode_Login`("+userEmail+","+password+");";
        System.out.println("Query  : "+ query);
        return  jdbcTemplate.execute((StatementCallback<String>)statementCallback->{
            ResultSet rs=statementCallback.executeQuery(query);
            String value=null;
            while(rs.next()){
                String companyCode=rs.getString(LoginDBConstants.COMPANY_CODE);
                value=companyCode;
            }
            return value;
        });
    }

    @Override
    public int getUserProfileId(String companyCode) {
        String query="CALL `GetUserProfileId_Login`("+companyCode+");";
        System.out.println("Query : "+query);
        return  jdbcTemplate.execute((StatementCallback<Integer>)statementCallback->{
            int userProfileId=0;
            ResultSet rs=statementCallback.executeQuery(query);
            while (rs.next()){
                 userProfileId=rs.getInt(LoginDBConstants.USER_PROFILE_ID);
            }
            return userProfileId;
        });
    }

    @Override
    public LoginResponse getLoginView(int userProfileId, String token) {
        String query="CALL `User.Login_View`("+userProfileId+");";
        System.out.println("Query : "+query);
        List<LoginModel>loginModelList=namedParameterJdbcTemplate.query(query,new MapSqlParameterSource(),new LoginDataTier(token));
        if(loginModelList!=null &&loginModelList.size()!=0){
            return getLoginResponse(true,"Success",loginModelList);
        }
        return getLoginResponse(false,"Login list is empty or null",null);
    }

    @Override
    public String generateToken(String userEmail, String password,int userProfileId) {
        String finalvalue=userEmail+"|"+password+"|"+userProfileId;
        byte[] encodedBytes = Base64.encodeBase64(finalvalue.getBytes());
        return new String(encodedBytes);
    }
    private LoginResponse getLoginResponse(boolean value, String message, List<LoginModel>loginModelList){
        LoginResponse response=new LoginResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setLoginModel(loginModelList);
        return response;
    }

}
