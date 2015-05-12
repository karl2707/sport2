package jalgpall;

import java.util.ArrayList;

public class Team {
	private String teamName;
	private ArrayList<Player> mainplayers;
	private ArrayList<Player> benchplayers = null;
	private int index;

	public ArrayList<Player> getMainplayers() {
		return mainplayers;
	}

	public ArrayList<Player> getBenchplayers() {
		return benchplayers;
	}

	/**
	 * @param teamName
	 *            Meeskonna nimi.
	 */
	public Team(String teamName, ArrayList<Player> mainplayers, int index) {
		super();
		this.teamName = teamName;
		this.mainplayers = mainplayers;
		this.index = index;
	}

	public Team(String teamName, ArrayList<Player> mainplayers,
			ArrayList<Player> benchplayers, int index) {
		super();
		this.teamName = teamName;
		this.mainplayers = mainplayers;
		this.benchplayers = benchplayers;
		this.index = index;
	}

	String getTeamName() {
		return teamName;
	}

	public String toString() {
		return teamName;
	}

	public Player getPlayerNumber(int id) {
		for (Player a : mainplayers) {
			if (a.getNumber() == id)
				return a;
		}
		return mainplayers.get(0);
	}
}
