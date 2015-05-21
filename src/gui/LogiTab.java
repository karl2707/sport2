package gui;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class LogiTab {
	static BorderPane pane;
	static Label log;

	public static BorderPane make() {
		pane = new BorderPane();
		log = new Label();
		pane.setCenter(log);
		return pane;
	}

	public static void doLogi(String info) {
		log.setText(info);
	}
}
