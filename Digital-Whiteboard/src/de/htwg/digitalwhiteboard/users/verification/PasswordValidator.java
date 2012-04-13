package de.htwg.digitalwhiteboard.users.verification;

import de.htwg.digitalwhiteboard.users.IUser;

public class PasswordValidator {

	private static PasswordValidator onlyInstance;

	private PasswordValidator() {
		// singleton - empty by design
	}

	public synchronized static PasswordValidator getOnlyInstance() {

		if (onlyInstance == null) {
			onlyInstance = new PasswordValidator();
		}

		return onlyInstance;
	}

	public boolean validatePassword(IUser user, String password) {
		return false;
	}

}
