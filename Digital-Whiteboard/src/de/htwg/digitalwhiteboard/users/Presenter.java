package de.htwg.digitalwhiteboard.users;

public class Presenter extends AbstractUser{

	public Presenter(String username) {
		super(username);
	}

	@Override
	public void startIndexing() {
		this.indexer.startIndex();
	}



}
