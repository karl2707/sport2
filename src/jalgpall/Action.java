package jalgpall;

import java.util.concurrent.TimeUnit;

import application.Main;

/**
 * Abstraktne klass, mis omab kogu üldis osa kõigele, mis toimub
 * jalgpallimängus. Klass on abstraktne sellel eesmärgil, et sellest ei oleks
 * võimalik teha isendit. Samas ei ole hetkel vajadust abstraktsete meetodite
 * järgi.
 */
public abstract class Action {
	protected Long time;
	protected Player player;
	protected Team team;

	/**
	 * Ilma muutujateta konstruktor. Võtab süssteemist kellaaja.
	 */
	Action() {
		this.time = TimeUnit.MINUTES.convert(System.nanoTime()
				- Main.soccerGame.getGameStartTime(), TimeUnit.NANOSECONDS) + 1;
	}

	/**
	 * Võimaldab luua kohe teases mängijat ja tiimi, kes vastava teoga hakkama
	 * sai.
	 * 
	 * @param player
	 *            Player isend, kes vastava teoga hakkama sai
	 * @param team
	 *            Team isend, mmeskond, kuhu mängija kuulub
	 */
	Action(Player player, Team team) {
		this();
		this.player = player;
		this.team = team;
	}

	/**
	 * Võib juhtuda, et mängija objekti tuleb kuskilt kaugemalt ostida. Sellisel
	 * juhul on mugavam kaasas kanda juba loodud isendi signatuuri.
	 * 
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Player getPlayer() {
		return player;
	}

	public String getTime() {
		return time.toString();
	}

	public String toString() {
		return player + " @ " + time;
	}
}
