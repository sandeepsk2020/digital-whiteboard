package de.htwg.digitalwhiteboard.filerepository;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import de.htwg.digitalwhiteboard.users.IUser;

/**
 * Creates an index of available files.
 * 
 * @author Alexander Gelroth
 * 
 */
public class Indexer extends Thread {

	final private IUser user;

	private Set<File> userFiles = new HashSet<>();

	private File userRootDir;

	public Indexer(IUser user) {
		this.user = user;

		getUserDir();
	}

	private boolean getUserDir() {

		boolean success;

		userRootDir = new File(".\\user_repos\\" + user.getUserName() + "\\");

		if (userRootDir.isDirectory() && userRootDir.canRead()) {
			success = true;
		} else {
			success = userRootDir.mkdirs();
		}

		return success;
	}

	public void startIndex() {

		String[] list = userRootDir.list();

		for (String path : list) {
			userFiles.add(new File(path));
		}

	}

	public boolean stopIndex() {

		this.interrupt();

		return true;
	}

}
