package vn.topica.itlab4.controller;

import vn.topica.itlab4.bean.User;
import vn.topica.itlab4.cryptography.Encrypt;
import vn.topica.itlab4.model.UserModel;
import vn.topica.itlab4.util.Constant;

public class AuthService
{
	public static boolean checkUsername(String username)
	{
		return UserModel.getUser(username) != null;
	}
	
	public static int checkLogin(String username, String password)
	{
		User user = UserModel.getUser(username);
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
