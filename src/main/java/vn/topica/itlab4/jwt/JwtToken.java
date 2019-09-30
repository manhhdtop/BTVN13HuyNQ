package vn.topica.itlab4.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import vn.topica.itlab4.bean.User;
import vn.topica.itlab4.model.UserModel;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

public class JwtToken
{
	private static Algorithm algorithm = Algorithm.HMAC256("secret");
	private static String attr = "username";
	
	public static String createJWT(String username)
	{
		try
		{
			String dateFormat = "dd/MM/yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
			LocalDate localDate = DateTimeFormatter.ofPattern(dateFormat)
					.parse(simpleDateFormat.format(new Date()), LocalDate::from);
			Date expired = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(expired);
			c.add(Calendar.DATE, 7);
			expired = c.getTime();
			return JWT.create().withIssuer("issuer").withIssuedAt(new Date())
					.withExpiresAt(expired).withClaim(attr, username).sign(algorithm);
		}
		catch (JWTCreationException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static Optional<User> decodeJWT(String token)
	{
		try
		{
			JWTVerifier verifier = JWT.require(algorithm).withIssuer("issuer").build();
			JWT.require(algorithm).acceptExpiresAt(0);
			verifier.verify(token);
			
			DecodedJWT decode = JWT.decode(token);
			String username = decode.getClaim(attr).asString();
			System.out.println(username);
			return Optional.of(UserModel.getUser(username));
		}
		catch (JWTVerificationException | NullPointerException e)
		{
			System.err.println(e.getMessage());
			return Optional.empty();
		}
	}
	
	public static void removeToken(String token)
	{
		JWTVerifier verifier = JWT.require(algorithm).acceptExpiresAt(0)
				.withIssuer("issuer").build();
		System.out.println(verifier.verify(token).getExpiresAt());
	}
	
}
