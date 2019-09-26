package vn.topica.itlab4.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
	@PostMapping(value = {"/login"})
	public String login(@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false) String password)
	{
		
		return "";
	}
	
	@PostMapping(value = {"/signup"})
	public String signUp()
	{
		
		return "";
	}
}
