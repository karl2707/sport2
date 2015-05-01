package gui;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MängTab {
	public static BorderPane make() {
		BorderPane pane = new BorderPane();
		
		Text seis = new Text("0 - 0");
		seis.setFont(Font.font(100));
		
		pane.setTop(seis);
		
		BorderPane.setAlignment(seis, Pos.TOP_CENTER);
		
		return pane;
	}
}
