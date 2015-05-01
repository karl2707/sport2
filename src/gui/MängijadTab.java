package gui;

import jalgpall.Player;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class MängijadTab {
	public static BorderPane make() {
		BorderPane pane = new BorderPane();
		
		ListView<Player> list = new ListView<>();
		
		ObservableList<Player> items = FXCollections.observableArrayList ();
		
		list.setItems(items);
		
		
		pane.setLeft(list);
		
		return pane;
		
	}
	
	private static void listBox() {
		
	}

}
