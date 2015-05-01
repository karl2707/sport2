package jalgpall;

import java.sql.Time;

public class Goal extends Action {
	
	public Goal() {
		super();
		// TODO Auto-generated constructor stub
	}

	Goal(Player player, Team team) {
		super(player, team);
	}

	public String toString() {
		return "Värav " + super.toString();
	}
}
