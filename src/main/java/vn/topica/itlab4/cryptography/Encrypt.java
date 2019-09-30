package vn.topica.itlab4.cryptography;

import vn.topica.itlab4.util.Constant;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

public class Encrypt
{
	private static final Random random = new SecureRandom();
	private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_. ";
	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;
	private static final String ENCRYPT_TYPE = "PBKDF2WithHmacSHA1";
	
	public static String getSalt()
	{
		return getSalt(Constant.FILE_NAME_LENGTH);
	}
	
	public static String getSalt(int length)
	{
		StringBuilder returnValue = new StringBuilder(length);
		for (int i = 0; i < length; i++)
		{
			returnValue.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
		}
		return new String(returnValue);
	}
	
	private static byte[] hash(char[] password, byte[] salt)
	{
		PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
		Arrays.fill(password, Character.MIN_VALUE);
		try
		{
			SecretKeyFactory skf = SecretKeyFactory.getInstance(ENCRYPT_TYPE);
			return skf.generateSecret(spec).getEncoded();
		}
		catch (NoSuchAlgorithmException | InvalidKeySpecException e)
		{
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		}
		finally
		{
			spec.clearPassword();
		}
	}
	
	public static String generateSecurePassword(String password, String salt)
	{
		byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
		return Base64.getEncoder().encodeToString(securePassword);
	}
	
	public static boolean verifyPassword(String providedPassword, String securedPassword,
			String salt)
	{
		String newSecurePassword = generateSecurePassword(providedPassword, salt);
		return newSecurePassword.equals(securedPassword);
	}
}
