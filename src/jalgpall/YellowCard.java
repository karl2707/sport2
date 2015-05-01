package jalgpall;

public class YellowCard extends Action {

	public YellowCard() {
		super();
	}

	YellowCard(Player player, Team team) {
		super(player, team);
	}
	
	public String toString() {
		return "Kollane kaart " + super.toString();
	}

}
