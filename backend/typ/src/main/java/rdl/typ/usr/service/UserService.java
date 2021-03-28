package rdl.typ.usr.service;

import java.util.Optional;

import rdl.typ.usr.dto.UserInfo;
import rdl.typ.usr.repository.UserRepository;

public interface UserService {
	
	public UserInfo getUserInfo(String userId, String userPassword);
	public UserInfo getUserInfoById(String userId);
	public String ecntypt(String userPassword);
	public String createToken(UserInfo user);
}
 