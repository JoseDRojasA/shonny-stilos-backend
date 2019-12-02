package com.shonny.backend.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class Utils {
	/**
	 * Hashes the passed password.
	 * 
	 * @param password to be hashed.
	 * @return the encrypted password, never <code>null</code>.
	 */
	public static String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}

	/**
	 * Verifies if the passed plain (not hashed) password matches with an already
	 * hashed one.
	 * 
	 * @param plainPassword  to be compared.
	 * @param hashedPassword the already hashed password.
	 * @return <code>true</code> if the two passwords match, <code>false</code>
	 *         otherwise.
	 */
	public static boolean passwordsMatch(String plainPassword, String hashedPassword) {
		return BCrypt.checkpw(plainPassword, hashedPassword);
	}
}
