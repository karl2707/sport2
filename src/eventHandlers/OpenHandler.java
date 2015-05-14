package eventHandlers;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import application.Main;

public class OpenHandler implements EventHandler<ActionEvent> {
	final FileChooser fileChooser = new FileChooser();

	public void handle(final ActionEvent e) {
		File file = fileChooser.showOpenDialog(Main.mainStage);
		if (file != null) {
			openFile(file);
		}
	}

	private void openFile(File file) {
		String path = file.getAbsolutePath();
		Main.doOpen(path);
	}
}
