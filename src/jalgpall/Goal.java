package jalgpall;

public class Goal extends Action {

	public Goal() {
		super();
	}

	Goal(Player player, Team team) {
		super(player, team);
	}

	public String toString() {
		return "Värav " + super.toString();
	}
}
