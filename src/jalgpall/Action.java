package jalgpall;

import java.util.concurrent.TimeUnit;

import application.Main;

/**
 * Abstraktne klass, mis omab kogu �ldis osa k�igele, mis toimub
 * jalgpallim�ngus. Klass on abstraktne sellel eesm�rgil, et sellest ei oleks
 * v�imalik teha isendit. Samas ei ole hetkel vajadust abstraktsete meetodite
 * j�rgi.
 */
public abstract class Action {
	protected Long time;
	protected Player player;
	protected Team team;

	/**
	 * Ilma muutujateta konstruktor. V�tab s�ssteemist kellaaja.
	 */
	Action() {
		this.time = TimeUnit.MINUTES.convert(System.nanoTime()
				- Main.soccerGame.getGameStartTime(), TimeUnit.NANOSECONDS) + 1;
	}

	/**
	 * V�imaldab luua kohe teases m�ngijat ja tiimi, kes vastava teoga hakkama
	 * sai.
	 * 
	 * @param player
	 *            Player isend, kes vastava teoga hakkama sai
	 * @param team
	 *            Team isend, mmeskond, kuhu m�ngija kuulub
	 */
	Action(Player player, Team team) {
		this();
		this.player = player;
		this.team = team;
	}

	/**
	 * V�ib juhtuda, et m�ngija objekti tuleb kuskilt kaugemalt ostida. Sellisel
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
