package rdl.typ.usr.service.impl;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import rdl.typ.jwt.JwtTokenProvider;
import rdl.typ.usr.dto.UserInfo;
import rdl.typ.usr.repository.UserRepository;
import rdl.typ.usr.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository uifRepo;
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

	
	@Override
	public UserInfo getUserInfo(String userId, String userPassword) {
		String encPassword = ecntypt(userPassword);
		return uifRepo.findMember(userId, encPassword);
	}
	

	@Override
	public UserInfo getUserInfoById(String userId) {
		return uifRepo.findById(userId).orElse(null);
	}

	@Override
	public String ecntypt(String userPassword) {
		 String result = "";
		  try {
		  	MessageDigest md = MessageDigest.getInstance("SHA-256");
		  	md.update(userPassword.getBytes());

		  	byte byteData[] = md.digest();
		  	StringBuffer sb = new StringBuffer();
		    
		    for(int i=0; i<byteData.length; i++) {
		      sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
		    }

		    StringBuffer hexString = new StringBuffer();
		    for(int i=0; i<byteData.length;i++) {
		    String hex = Integer.toHexString(0xff & byteData[i]);
		    if(hex.length() == 1) {
		      hexString.append('0');
		    }
		      hexString.append(hex);
		    }

		    result = hexString.toString();
		  } catch(NoSuchAlgorithmException e){
			  LOG.info("EncBySHA256 Error:" + e.toString());
		  }
		  return result;
	}

	@Override
	public String createToken(UserInfo user) {
		return  jwtTokenProvider.createToken(user.getUserId());
	}

}
 