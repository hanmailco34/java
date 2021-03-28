package rdl.typ.usr.controller;

import java.util.HashMap;


import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import rdl.typ.common.CommonCode;
import rdl.typ.exception.LoginFailException;
import rdl.typ.exception.TokenInvalidException;
import rdl.typ.jwt.TokenResponse;
import rdl.typ.usr.dto.UserInfo;
import rdl.typ.usr.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl userService;

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@PostMapping("/login")
	public @ResponseBody Map<String, Object> userLogin(@RequestBody UserInfo request) throws LoginFailException {
		Map<String, Object> result = new HashMap<>();
		UserInfo user = userService.getUserInfo(request.getUserId(), request.getUserPassword());
		result.put(CommonCode.DATA, Optional.ofNullable(user).orElseThrow(() -> new LoginFailException("Not Found User")));
		result.put(CommonCode.MESSAGE, CommonCode.SUCCESS);
		result.put("jwt",new TokenResponse(userService.createToken(request), "bearer"));
		return result; 
	}
	
	@PostMapping("/info") // interceptor 검증을 통해 token으로 정보를 가져옴.
    public ResponseEntity<UserInfo> info(HttpServletRequest request) {
		  String name = (String) request.getAttribute("name");
		  UserInfo user = userService.getUserInfoById((String) request.getAttribute("userId")); 
		  return ResponseEntity.ok().body(user);
    }
	
	@PostMapping("/test")
    public ResponseEntity<TokenResponse> login(@RequestBody UserInfo req) {
		LOG.info("reqValue == > " + req);	
		String token = userService.createToken(req);
        return ResponseEntity.ok().body(new TokenResponse(token, "bearer"));
    }
}
