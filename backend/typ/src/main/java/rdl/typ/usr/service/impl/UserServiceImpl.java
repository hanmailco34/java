package rdl.typ.usr.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;
import rdl.typ.usr.dto.UserInfo;
import rdl.typ.usr.repository.UserRepository;
import rdl.typ.usr.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository uifRepo;
	
	@Override
	public UserInfo getUserInfo(String userId, String userPassword) {
		return uifRepo.findMember(userId, userPassword).orElseThrow(() -> new NoSuchElementException("User not found"));
	}

}
 