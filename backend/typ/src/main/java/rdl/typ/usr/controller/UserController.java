package rdl.typ.usr.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		String msg;
		String data;
		String status;
		ResponseEntity res = null;
		Map<String, Object> result = new HashMap<>();
		try {
			UserInfo user = userService.getUserInfo(req.getUserId(), req.getUserPassword());
			if (user != null) {
				status = "OK";
				result.put("data", user);
				result.put("status", status);
			}
		} catch (NoSuchElementException e) {
			e.getMessage();
			status = "OOPS";
			msg = "login_fail";
			result.put("msg", msg); 
			result.put("status", status);
		}
		LOG.info("result => " + res); 
		return result;

	}
}
