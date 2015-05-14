package eventHandlers;

import application.Main;
import gui.MängTab;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EndHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent ae) {
		Main.endGame();
		MängTab.doEnd();		
	}
	
}
