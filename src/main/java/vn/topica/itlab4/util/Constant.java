package vn.topica.itlab4.util;

public class Constant
{
	// Check login code
	public static final int LOGIN_SUCCESS = 1;
	public static final int USER_NOT_FOUND = 0;
	public static final int LOGIN_FAILD = -1;
	
	// API code
	public static final int CODE_SUCCESS = 200;
	public static final int CODE_FIELD_REQUIRED = 410;
	public static final int CODE_FIELD_NOT_VALID = 411;
	public static final int CODE_USER_EXIST = 412;
	public static final int CODE_UNKNOWN = 413;
	public static final int CODE_TOKEN_NOT_VALID = 415;
	
	// API message
	public static final String MESSAGE_UNKNOWN = "Error code unknown.";
	public static final String MESSAGE_SUCCESS = " success.";
	public static final String MESSAGE_ERROR = " error.";
	public static final String MESSAGE_USER_NOT_FOUND = "Username not found.";
	public static final String MESSAGE_TOKEN_NOT_VALID = "Token not found or " +
			"not valid or expired";
	public static final String MESSAGE_USER_EXIST = "Username is existed.";
	public static final String MESSAGE_LOGIN_FAILD = "Username or password " +
			"not correct.";
	public static final String MESSAGE_USERNAME_REQUIRE = "Username is required.";
	public static final String MESSAGE_PASSWORD_REQUIRE = "Password is required.";
	public static final String MESSAGE_USERNAME_NOT_VALID = "Username is " +
			"not valid.";
	public static final String MESSAGE_PASSWORD_NOT_VALID = "Password is not valid.";
	
	// Some constant
	public static final int FILE_NAME_LENGTH = 255;
	public static final int TOKEN_RANDOM_LENGTH = 13;
	public static final String USERNAME_REGEX = "^(?=.*[A-Za-z])" +
			"[A-Za-z\\d]{4," +
			"50}$";
	public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z\\d])" +
			"[A-Za-z\\d@$!%*#?&]{6,50}$";
	
	// HQL - Hibernate SQL
	// User Table
	public static final String SELECT_USERS = "FROM User";
	public static final String SELECT_USER = "FROM User WHERE " +
			"username=:username";
	public static final String INSERT_USERS = "INSERT INTO User(username, " +
			"password, salt) VALUES(:username, :password, :salt)";
	
	// Cart table
	public static final String SELECT_Cart = "FROM Cart WHERE " +
			"username=:username";
}
