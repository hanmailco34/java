package rdl.typ.usr.controller;

import java.util.HashMap;

import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import rdl.typ.usr.dto.UserInfo;
import rdl.typ.usr.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServiceImpl userService;

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@PostMapping("/login")
	public @ResponseBody Map<String, Object> userLogin(@RequestBody UserInfo req) {
		LOG.info("userId = > " + req.getUserId() + " userPassword = > " + req.getUserPassword());
		
		Map<String, Object> result = new HashMap<>();
		UserInfo user = userService.getUserInfo(req.getUserId(), req.getUserPassword());
		
		Optional.ofNullable(user).ifPresentOrElse(u -> {
			result.put("data", u);
			result.put("status", "OK");
		}, () -> {
			result.put("status", "OOPS");
			result.put("msg", "login_fail");
		});
		return result;

	}
}
