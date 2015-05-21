package gui;

import jalgpall.Player;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class MängijadTab {
	public static ObservableList<Player> ftPlayers;
	public static ObservableList<Player> stPlayers;
	public static ListView<Player> ftList;
	public static ListView<Player> stList;

	public static BorderPane make() {
		BorderPane pane = new BorderPane();

		ftList = new ListView<Player>();
		ftList.setItems(ftPlayers);

		stList = new ListView<Player>();
		stList.setItems(stPlayers);

		pane.setLeft(ftList);
		pane.setRight(stList);

		return pane;

	}

	public static void updatePlayers() {
		ftList.setItems(ftPlayers);
		stList.setItems(stPlayers);
	}

}
