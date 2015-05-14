package eventHandlers;

import gui.MängTab;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent ae) {
		Main.soccerGame.startGame();
		MängTab.functionBox.getChildren().clear();
		MängTab.functionBox.getChildren().addAll(MängTab.goalBtn,
				MängTab.foulBtn);
	}

}
