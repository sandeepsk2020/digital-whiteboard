package de.htwg.digitalwhiteboard.users;

import de.htwg.digitalwhiteboard.filerepository.Indexer;

public abstract class AbstractUser implements IUser {

	protected String username;

	protected String firstname;

	protected String lastname;

	protected String email;

	protected Indexer indexer;

	public AbstractUser(String username) {
		this.username = username;
		this.indexer = new Indexer(this);
	}

	@Override
	public String getUserName() {
		return username;
	}
}
