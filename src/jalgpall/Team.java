package jalgpall;

import java.util.ArrayList;

public class Team {
	private String teamName;
	private ArrayList<Player> players;

	/**
	 * @param teamName Meeskonna nimi.
	 */
	public Team(String teamName, ArrayList<Player> players) {
		super();
		this.teamName = teamName;
		this.players = players;
	}

	String getTeamName() {
		return teamName;
	}
	
	/**
	 * Lisatakse vigade listi uus viga.
	 * @param foul Vea objekt. 
	 */
	
	public String toString() {
		return teamName;
	}
	
	public Player getPlayerNumber(int id) {
		for (Player a: players) {
			if (a.getNumber() == id)
				return a;
		}
		return players.get(0);
	}
}
