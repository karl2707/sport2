package jalgpall;

import java.sql.Time;

public class Foul extends Action {
	
	public Foul() {
		super();
		// TODO Auto-generated constructor stub
	}

	Foul(Player player, Team team) {
		super(player, team);
	}

	public String toString() {
		return "Viga " + super.toString();
	}

}
