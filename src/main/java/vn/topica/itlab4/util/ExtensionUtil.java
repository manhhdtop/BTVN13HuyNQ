package vn.topica.itlab4.util;

import org.apache.commons.lang3.StringUtils;
import vn.topica.itlab4.cryptography.Encrypt;

import java.util.Date;

public class ExtensionUtil
{
	public static String removeAccent(String s)
	{
		s = s.toLowerCase().replaceAll("đ", "d");
		return StringUtils.stripAccents(s);
	}
	
	public static String randomString(int length)
	{
		return Encrypt.getSalt(length);
	}
	
	public static String generateFileName()
	{
		int length = Constant.FILE_NAME_LENGTH;
		String timestamp = new Date().getTime() + "";
		String s = Encrypt.getSalt(length - timestamp.length());
		s += timestamp;
		return s;
	}
	
}
