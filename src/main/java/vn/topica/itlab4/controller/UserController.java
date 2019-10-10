package vn.topica.itlab4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.topica.itlab4.bean.ApiPacket;
import vn.topica.itlab4.bean.Data;
import vn.topica.itlab4.bean.User;
import vn.topica.itlab4.cryptography.Encrypt;
import vn.topica.itlab4.jwt.JwtToken;
import vn.topica.itlab4.model.UserModel;
import vn.topica.itlab4.util.Constant;
import vn.topica.itlab4.util.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user/", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController
{
	@Autowired
	private UserModel model;
	
	@Autowired
	private AuthService authService;
	
	@PostMapping(value = {"login"})
	public String login(@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false) String password)
	{
		ApiPacket packet;
		String method = "Login";
		String message;
		if (username == null || password == null)
		{
			List<String> errors = new ArrayList<>();
			if (username == null)
			{
				errors.add(Constant.MESSAGE_USERNAME_REQUIRE);
			}
			if (password == null)
			{
				errors.add(Constant.MESSAGE_PASSWORD_REQUIRE);
			}
			message = method + Constant.MESSAGE_ERROR;
			packet = Utils.getPacket(method, Constant.CODE_FIELD_REQUIRED,
					message, errors);
		}
		else
		{
			Data d = null;
			int code;
			switch (authService.checkLogin(username, password))
			{
				case Constant.LOGIN_SUCCESS:
					message = method + Constant.MESSAGE_SUCCESS;
					code = Constant.CODE_SUCCESS;
					String token = JwtToken.createJWT(username);
					d = new Data();
					d.setToken(token);
					break;
				case Constant.LOGIN_FAILD:
					message = Constant.MESSAGE_LOGIN_FAILD;
					code = Constant.CODE_FIELD_NOT_VALID;
					break;
				case Constant.USER_NOT_FOUND:
					message = Constant.MESSAGE_USER_NOT_FOUND;
					code = Constant.CODE_FIELD_NOT_VALID;
					break;
				default:
					message = Constant.MESSAGE_UNKNOWN;
					code = Constant.CODE_UNKNOWN;
					break;
			}
			
			packet = Utils.getPacket(method, code, message, d);
		}
		return Utils.packetToJson(packet);
	}
	
	@PostMapping(value = {"register"})
	public String signUp(@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "password", required = false) String password)
	{
		ApiPacket packet;
		String method = "Sign up";
		String message;
		int code;
		List<String> errors = null;
		if (name == null || username == null || password == null)
		{
			errors = new ArrayList<>();
			if (name == null)
			{
				errors.add(Constant.MESSAGE_NAME_REQUIRE);
			}
			if (username == null)
			{
				errors.add(Constant.MESSAGE_USERNAME_REQUIRE);
			}
			if (password == null)
			{
				errors.add(Constant.MESSAGE_PASSWORD_REQUIRE);
			}
			message = method + Constant.MESSAGE_ERROR;
			packet = Utils.getPacket(method, Constant.CODE_FIELD_REQUIRED,
					message, errors);
		}
		else
		{
			if (authService.checkUsername(username))
			{
				message = Constant.MESSAGE_USER_EXIST;
				packet = Utils.getPacket(method, Constant.CODE_USER_EXIST,
						message);
			}
			else
			{
				if (!username.matches(Constant.USERNAME_REGEX) ||
						!password.matches(Constant.PASSWORD_REGEX))
				{
					errors = new ArrayList<>();
					if (!username.matches(Constant.USERNAME_REGEX))
					{
						errors.add(Constant.MESSAGE_USERNAME_NOT_VALID);
					}
					if (!password.matches(Constant.PASSWORD_REGEX))
					{
						errors.add(Constant.MESSAGE_PASSWORD_NOT_VALID);
					}
					message = method + Constant.MESSAGE_ERROR;
					packet = Utils.getPacket(method, Constant.CODE_FIELD_NOT_VALID,
							message, errors);
				}
				else
				{
					User u = new User();
					u.setUsername(username);
					u.setName(name);
					u.setSalt(Encrypt.getSalt());
					u.setPassword(Encrypt.generateSecurePassword(password,
							u.getSalt()));
					
					String token = JwtToken.createJWT(username);
					Data d = new Data();
					d.setToken(token);
					User result = model.save(u);
					message = method + Constant.MESSAGE_SUCCESS;
					
					packet = Utils.getPacket(method, Constant.CODE_SUCCESS,
							message, d);
				}
			}
		}
		
		return Utils.packetToJson(packet);
	}
	
	@PostMapping(value = {"/logout"})
	public String logout(HttpServletRequest request)
	{
		ApiPacket packet;
		String method = "Logout";
		String message;
		int code;
		
		String username = Utils.checkToken(request.getCookies());
		User user = authService.findUser(username);
		if (user == null)
		{
			message = Constant.MESSAGE_TOKEN_NOT_VALID;
			code = Constant.CODE_TOKEN_NOT_VALID;
		}
		else
		{
			message = method + Constant.MESSAGE_SUCCESS;
			code = Constant.CODE_SUCCESS;
		}
		
		packet = Utils.getPacket(method, code, message);
		return Utils.packetToJson(packet);
	}
	
	@PostMapping(value = {"change-password"})
	public String logout(HttpServletRequest request,
			@RequestParam(name = "password", required = false) String password)
	{
		ApiPacket packet;
		System.out.println("Change password");
		String method = "Change password";
		String message;
		int code;
		Data data = null;
		String username = Utils.checkToken(request.getCookies());
		User user = authService.findUser(username);
		if (user == null)
		{
			message = Constant.MESSAGE_TOKEN_NOT_VALID;
			code = Constant.CODE_TOKEN_NOT_VALID;
		}
		else
		{
			if (password == null)
			{
				message = Constant.MESSAGE_PASSWORD_REQUIRE;
				code = Constant.CODE_FIELD_REQUIRED;
			}
			else
			{
				message = method + Constant.MESSAGE_SUCCESS;
				code = Constant.CODE_SUCCESS;
				user.setSalt(Encrypt.getSalt());
				user.setPassword(Encrypt.generateSecurePassword(password,
						user.getSalt()));
				model.update(user);
				String t = JwtToken.createJWT(user.getUsername());
				data = new Data();
				data.setToken(t);
			}
		}
		
		packet = Utils.getPacket(method, code, message, data);
		return Utils.packetToJson(packet);
	}
}
