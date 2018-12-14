package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.TestService;

@RestController
@CrossOrigin
public class TestController {

	HashMap<String, UserData> userMap = new HashMap<>();
	@Autowired
	TestService testService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public TokenResponse getTestString(@RequestBody LoginData loginData, HttpServletResponse res) {
		System.out.println(userMap);
		if (userMap.containsKey(loginData.getUserName())) {
			UserData userData = userMap.get(loginData.getUserName());
			if (StringUtils.equals(userData.getPassword(), loginData.getPassword())) {
				TokenResponse token = new TokenResponse();
				token.setToken("token-" + loginData.hashCode());
				token.setRoles(userData.getRoleList());
				res.setStatus(HttpStatus.OK.value());
				return token;
			}
		}
		TokenResponse token = new TokenResponse();
		token.setToken("token-LoginFailed");
		res.setStatus(HttpStatus.NOT_FOUND.value());
		return token;
	}

	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	public Object getRegister(@RequestBody UserData user, HttpServletResponse res) {
		userMap.put(user.userName, user);
		res.setStatus(HttpStatus.OK.value());
		Response status = new Response();
		status.setStatus("OK");
		return status;
	}

	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public Object getRegister(HttpServletResponse res) {
		ArrayList<UserData> userData = new ArrayList<UserData>();
		userMap.forEach((String key, UserData value) -> {
			userData.add(value);
		});
		res.setStatus(HttpStatus.OK.value());
		return userData;
	}
}
