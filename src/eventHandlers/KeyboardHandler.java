package eventHandlers;

import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardHandler implements EventHandler<KeyEvent> {
	
	@Override
	public void handle(KeyEvent arg0) {
		Object o = arg0.getSource();
		TabPane tabs = (TabPane)o;
		int id = -1;
		boolean �ige = false;
		
		if (arg0.getCode().equals(KeyCode.F1)) {
			id = 0;
			�ige =  true;
		} else if (arg0.getCode().equals(KeyCode.F2)) {
			id = 1;
			�ige = true;
		} else if (arg0.getCode().equals(KeyCode.F3)) {
			id = 2;
			�ige = true;
		}
		
		if (�ige)
			tabs.getSelectionModel().select(id);
		
	}

}
