package de.htwg.digitalwhiteboard.session;

import de.htwg.digitalwhiteboard.users.IUser;

public class Session implements ISession {

	private IUser user;

	public Session(IUser user) {
		this.user = user;
	}

	@Override
	public IUser getUser() {
		return user;
	}

}
