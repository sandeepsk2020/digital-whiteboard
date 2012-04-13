package de.htwg.digitalwhiteboard.session;

import java.util.HashMap;
import java.util.Map;

import de.htwg.digitalwhiteboard.users.Presenter;

public class SessionHandler {

	private final static SessionHandler instance = new SessionHandler();

	private static Map<Integer, ISession> activeSessions;

	private SessionHandler() {

	}

	public Map<Integer, ISession> getActiveSessions() {

		// TODO remove, just for demonstration
		if (activeSessions == null) {
			activeSessions = new HashMap<Integer, ISession>();

			activeSessions.put(1, new Session(new Presenter("test user1")));
			activeSessions.put(2, new Session(new Presenter("test user2")));
		}

		return activeSessions;
	}

	public static SessionHandler getInstance() {
		return instance;
	}

}
