package eventHandlers;

import gui.M�ngTab;
import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class StartHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent ae) {
		Main.soccerGame.startGame();
		M�ngTab.functionBox.getChildren().clear();
		M�ngTab.functionBox.getChildren().addAll(M�ngTab.goalBtn,
				M�ngTab.foulBtn);
	}

}
