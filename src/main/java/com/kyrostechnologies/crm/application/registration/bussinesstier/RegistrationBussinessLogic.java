package com.kyrostechnologies.crm.application.registration.bussinesstier;

import com.fasterxml.jackson.databind.util.Named;
import com.kyrostechnologies.crm.application.login.bussinesstier.LoginBussinessLogic;
import com.kyrostechnologies.crm.application.registration.RegistrationInterface;
import com.kyrostechnologies.crm.application.registration.datatier.RegistrationDataTier;
import com.kyrostechnologies.crm.dbconstants.RegistrationDBConstants;
import com.kyrostechnologies.crm.model.LoginModel;
import com.kyrostechnologies.crm.model.RegistrationModel;
import com.kyrostechnologies.crm.response.LoginResponse;
import com.kyrostechnologies.crm.response.RegistrationResponse;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RegistrationBussinessLogic implements RegistrationInterface {
    private int registrationId;
    private String companyCode;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private LoginBussinessLogic bussinessLogic;
    @Override
    public RegistrationResponse registration(RegistrationModel model) {
        String email=model.getEmailAddress();
        email="'"+email+"'";
        String password=model.getUserPassword();
        byte[] encodedBytes = Base64.encodeBase64(password.getBytes());
        System.out.println("encodedBytes " + new String(encodedBytes));
        String new_encryptedpassword=new String (encodedBytes);
        new_encryptedpassword="'"+new_encryptedpassword+"'";
        String companyCode=registerEmail(email,new_encryptedpassword);
        List<RegistrationModel>registrationList=new ArrayList<RegistrationModel>();

        if(companyCode!=null){
            companyCode="'"+companyCode+"'";
            String query="CALL `Registration_UserProfile`("+companyCode+");";
            System.out.println("Query: "+query);
           int proid= jdbcTemplate.execute((StatementCallback<Integer>)statementCallback->{
                int userProfileId=0;
                ResultSet rs=statementCallback.executeQuery(query);
                while(rs.next()){
                    userProfileId=rs.getInt(RegistrationDBConstants.LAST_INSERT_ID);
                }
                return userProfileId;
            });
            registrationList.clear();
            RegistrationModel mod=new RegistrationModel();
            mod.setRegistrationId(registrationId);
            mod.setCompanyCode(companyCode);
            mod.setUserProfileId(proid);
            mod.setUserPassword(model.getUserPassword());
            mod.setEmailAddress(model.getEmailAddress());
            registrationList.add(mod);
            if(registrationList!=null && registrationList.size()!=0){
                return  getRegistrationResponse(true,"Registration successfull",registrationList,null,null);
            }
            return getRegistrationResponse(false,"Registration is not successfull or registration list is empty",null,null,null);
        }
        return getRegistrationResponse(false,"company code is empty: or Email is Already registered",null,null,null);
    }

    @Override
    public String registerEmail(String userEmail, String password) {
        String query="CALL  `Company.usp_RegisterEmail`("+userEmail+","+password+")";
        System.out.println("Query : "+query);
        return  jdbcTemplate.execute((StatementCallback<String>)statementCallback->{
            ResultSet rs=statementCallback.executeQuery(query);
            String value=null;
            while(rs.next()){
                companyCode=rs.getString(RegistrationDBConstants.COMPANY_CODE);
                registrationId=rs.getInt(RegistrationDBConstants.REGISTRATION_ID);
                String emailAddress=rs.getString(RegistrationDBConstants.EMAIL_ADDRESS);
                String userName=rs.getString(RegistrationDBConstants.USER_NAME);
                value=companyCode;
            }
            return value;
        });
    }

    @Override
    public RegistrationResponse insertOtherDetails(RegistrationModel model) {
        String companyName=model.getCompanyName();
        int industryTypeId=model.getIndustryTypeId();
        int registrationId=model.getRegistrationId();
        int userProfileId=model.getUserProfileId();
        String timeZone=model.getTimeZone();
        int localeId=model.getUserLocaleId();
        int languageId=model.getLanguageId();
        int currencyId=model.getCurrencyId();
        String companyCode=model.getCompanyCode();
        String email=model.getEmailAddress();
        String password=model.getUserPassword();

        String value=updateRegistrationTable(companyName,industryTypeId,registrationId);
        if(value!=null){
            String companyvalue=insertCompany(userProfileId,companyCode,companyName);
            if(companyvalue!=null){
                LoginModel model2=new LoginModel();
                model2.setUserEmail(email);
                model2.setPassword(password);
                String token=generateToken(model.getEmailAddress(),model.getUserPassword(),model.getUserProfileId());
                LoginResponse loginResponse=(bussinessLogic.login(model2));
                return getRegistrationResponse(true,"Success",null,null,loginResponse);
            }
            return getRegistrationResponse(false,"insertCompany is failed or value is null",null,null,null);
        }
        return getRegistrationResponse(false,"Updateregistrationtable is failed or value is null",null,null,null);
    }

    @Override
    public String updateRegistrationTable(String companyName, int industryTypeId, int registrationId) {
        String query="CALL `Update.Registration_OtherDetails`(?,?,?)";
        System.out.println("Query : "+query);
        String isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<String>)preparedStatement->{
            preparedStatement.setString(1,companyName );
            preparedStatement.setInt(2, industryTypeId);
            preparedStatement.setInt(3, registrationId);
          int i=preparedStatement.executeUpdate();
          if(i>0){
              return "true";
          }
          return "false";
        });

        return isUpdated;
    }

    @Override
    public String updateUserProfileTable(String timeZone, int userLocaleId, int languageId, int currencyId, int userProfileId) {
        String query="CALL  `Update.Company_UserProfile`(?,?,?,?,?);";
        System.out.println("Query : "+query);
        String isUpdated=jdbcTemplate.execute(query,(PreparedStatementCallback<String>)preparedStatement->{
            preparedStatement.setString(1,timeZone );
            preparedStatement.setInt(2, userLocaleId);
            preparedStatement.setInt(3, languageId);
            preparedStatement.setInt(4, currencyId);
            preparedStatement.setInt(5, userProfileId);
          int i= preparedStatement.executeUpdate();
          if(i>0){
              return "true";
          }
          return "false";
        });
        return isUpdated;
    }

    @Override
    public String insertCompany(int userProfileId, String companyCode, String companyName) {
        String query="CALL `UserSettings.Company_InsertCompany`(?,?,?)";
        System.out.println("Query : "+query);
        String isInserted=jdbcTemplate.execute(query,(PreparedStatementCallback<String>)preparedStatement->{
            preparedStatement.setInt(1,userProfileId );
            preparedStatement.setString(2, companyCode);
            preparedStatement.setString(3, companyName);
          int i= preparedStatement.executeUpdate();
          if(i>0){
              return "true";
          }
          return "false";
        });
        return isInserted;
    }

    @Override
    public String generateToken(String userEmail, String password,int userProfileId) {
        String finalvalue=userEmail+"|"+password+"|"+userProfileId;
        byte[] encodedBytes = Base64.encodeBase64(finalvalue.getBytes());
        return new String(encodedBytes);
    }
    public RegistrationResponse getRegistrationResponse(boolean value, String message, List<RegistrationModel>registrationModelList, List<LoginModel> loginModelList, LoginResponse loginResponse){
        RegistrationResponse response=new RegistrationResponse();
        response.setIsSuccess(value);
        response.setMessage(message);
        response.setRegistrationList(registrationModelList);
        response.setLoginModel(loginModelList);
        response.setLogin(loginResponse);
        return response;
    }
}
