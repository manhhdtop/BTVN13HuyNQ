package vn.topica.itlab4.util;

import vn.topica.itlab4.bean.ApiPacket;


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
	public static ApiPacket getPackets(String method, int code,
			String message)
	{
		ApiPacket packet = new ApiPacket();
		
		packet.setMethod(method);
		packet.setCode(code);
		packet.setMessage(message);
		packet.setDatas(new Object());
		
		return packet;
	}
	
	public static ApiPacket getPackets(String method, int code,
			String message, Object datas)
	{
		ApiPacket packet = new ApiPacket();
		
		packet.setMethod(method);
		packet.setCode(code);
		packet.setMessage(message);
		packet.setDatas(datas);
		
		return packet;
	}
	
}
