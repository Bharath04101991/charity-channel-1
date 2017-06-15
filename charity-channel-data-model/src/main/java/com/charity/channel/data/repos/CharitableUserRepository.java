package com.charity.channel.data.repos;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.charity.channel.data.model.CharitableUser;


public interface CharitableUserRepository extends TableRepository<CharitableUser, Long>, JpaSpecificationExecutor<CharitableUser> {
	
	  @Query("FROM  CharitableUser WHERE username = ?1 or email=?1 or mobileNumber=?1")
	  public CharitableUser findUserByUserName(String email);

	  @Query("FROM  CharitableUser WHERE passwordResetToken = :passwordResetToken")
	  public CharitableUser findUserByPswdResetToken(@Param("passwordResetToken") String passwordResetToken);

	  @Query("FROM  CharitableUser WHERE email = :email or username = :email")
	  public CharitableUser findUserByEmail(@Param("email") String email) throws Exception; //ResourceNotFoundException;

	  @Query("FROM  CharitableUser WHERE apiKey = :apiKey")
	  public CharitableUser findUserByApiKey(@Param("apiKey") String apiKey);

	  @Query("FROM  CharitableUser WHERE deviceTokenId = :deviceTokenId")
	  public CharitableUser getUserByDeviceId(@Param("deviceTokenId") String deviceTokenId);

	  @Query("FROM  CharitableUser WHERE email = :email and password=:password")
	  public CharitableUser findUserByEmailNPwd(@Param("email") String email, @Param("password") String password);

	  @Query("FROM  CharitableUser WHERE email= ?1 or username= ?1 or mobileNumber=?2")
	  public CharitableUser findUserByEmailAndMobile(String email, String mobileNumber);

	  @Query("FROM  CharitableUser WHERE deviceTokenId= ?1")
	  public CharitableUser findDeviceTokenId(String deviceTokenId);

	  @Query("FROM  CharitableUser WHERE username = ?1 or email=?1 or mobileNumber=?1")
	  public CharitableUser getUserDetails(String username);
	
	

}
