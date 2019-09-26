package vn.topica.itlab4.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import vn.topica.itlab4.bean.User;
import vn.topica.itlab4.util.Constant;
import vn.topica.itlab4.util.ExtensionUtil;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

public class JwtToken
{
	private static Algorithm algorithm = Algorithm.HMAC256("secret");
	
	public static String createJWT(String username)
	{
		try
		{
			String dateFormat = "dd/MM/yyyy";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
			LocalDate localDate = DateTimeFormatter.ofPattern(dateFormat)
					.parse(simpleDateFormat.format(new Date()), LocalDate::from);
			Date expired = Date
					.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
			String token = JWT.create().withIssuer("issuer").withIssuedAt(new Date())
					.withExpiresAt(expired).withClaim("username", username).sign(algorithm);
			int index = token.indexOf(".") + Constant.TOKEN_RANDOM_LENGTH;
			token = token.substring(0, index)
					+ ExtensionUtil.randomString(Constant.TOKEN_RANDOM_LENGTH)
					+ token.substring(index);
			return token;
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
			int index = token.indexOf(".");
			token = token.substring(0, index)
					+ token.substring(index + Constant.TOKEN_RANDOM_LENGTH);
			JWTVerifier verifier = JWT.require(algorithm).withIssuer("issuer").build();
			JWT.require(algorithm).acceptExpiresAt(0);
			verifier.verify(token);
			
			DecodedJWT decode = JWT.decode(token);
			String username = decode.getClaim("username").asString();
			
			return Optional.of(new User());
		}
		catch (JWTVerificationException | NullPointerException e)
		{
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
