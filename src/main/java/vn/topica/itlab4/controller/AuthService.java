package vn.topica.itlab4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.topica.itlab4.bean.User;
import vn.topica.itlab4.cryptography.Encrypt;
import vn.topica.itlab4.model.UserModel;
import vn.topica.itlab4.util.Constant;

@Service
public class AuthService
{
	@Autowired
	private UserModel model;
	
	public User findUser(String username)
	{
		return model.findByUsername(username);
	}
	
	public boolean checkUsername(String username)
	{
		return model.findByUsername(username) != null;
	}
	
	public int checkLogin(String username, String password)
	{
		User user = model.findByUsername(username);
		if (user == null)
		{
			return Constant.USER_NOT_FOUND;
		}
		if (Encrypt.verifyPassword(password, user.getPassword(), user.getSalt()))
		{
			return Constant.LOGIN_FAILD;
		}
		return Constant.LOGIN_SUCCESS;
	}
}
