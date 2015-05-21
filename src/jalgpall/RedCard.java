package jalgpall;

public class RedCard extends Action {

	public RedCard(Player player, Team team) {
		super(player, team);
	}

	public RedCard() {
		super();
	}

	public String toString() {
		return "Punane kaart: " + super.toString();
	}
}
