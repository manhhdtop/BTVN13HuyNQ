package vn.topica.itlab4.util;

public class Constant
{
	// API message
	public static final String LOGIN_SUCCESS = "Login success.";
	public static final String ERROR_USER_NOT_FOUND = "Username not found.";
	public static final String LOGIN_FAILD = "Username or " +
			"password not correct.";
	
	// Some constant
	public static final int FILE_NAME_LENGTH = 255;
	public static final int TOKEN_RANDOM_LENGTH = 13;
	
	// HQL - Hibernate SQL
	// User Table
	public static final String SELECT_USERS = "FROM User";
	public static final String INSERT_USERS = "FROM User";
}
