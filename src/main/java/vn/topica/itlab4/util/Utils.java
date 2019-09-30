package vn.topica.itlab4.util;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import vn.topica.itlab4.bean.ApiPacket;
import vn.topica.itlab4.bean.User;
import vn.topica.itlab4.cryptography.Encrypt;
import vn.topica.itlab4.jwt.JwtToken;

import javax.servlet.http.Cookie;
import java.util.Date;
import java.util.Optional;


public class Utils
{
	/**
	 * This method create result to send result for api
	 *
	 * @param method  is name of api
	 * @param code    is status of result
	 * @param message is message of api
	 * @return object ApiPacket to Client
	 */
	public static ApiPacket getPacket(String method, int code,
			String message)
	{
		ApiPacket packet = new ApiPacket();
		
		packet.setMethod(method);
		packet.setCode(code);
		packet.setMessage(message);
		
		return packet;
	}
	
	public static ApiPacket getPacket(String method, int code,
			String message, Object datas)
	{
		ApiPacket packet = new ApiPacket();
		
		packet.setMethod(method);
		packet.setCode(code);
		packet.setMessage(message);
		packet.setDatas(datas);
		
		return packet;
	}
	
	public static String packetToJson(ApiPacket packet)
	{
		Gson gson = new Gson();
		return gson.toJson(packet, ApiPacket.class);
	}
	
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
	
	public static User checkToken(Cookie[] cookies)
	{
		User user = null;
		if (cookies != null)
		{
			for (Cookie c : cookies)
			{
				if (c.getName().equalsIgnoreCase("token"))
				{
					Optional<User> optional = JwtToken.decodeJWT(c.getValue());
					if (optional.isPresent())
					{
						user = optional.get();
					}
					break;
				}
			}
		}
		return user;
	}
}
