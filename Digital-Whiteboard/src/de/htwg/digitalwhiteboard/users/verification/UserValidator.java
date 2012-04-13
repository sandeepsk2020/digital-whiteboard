package de.htwg.digitalwhiteboard.users.verification;

import de.htwg.digitalwhiteboard.users.IUser;

public class UserValidator {

	private static UserValidator onlyInstance;

	public UserValidator() {
		// empty by design
	}

	public synchronized static UserValidator getOnlyInstance() {

		if (onlyInstance == null) {
			onlyInstance = new UserValidator();
		}

		return onlyInstance;
	}

	public IUser retreiveUser(String username) {

		return null;
	}

}
