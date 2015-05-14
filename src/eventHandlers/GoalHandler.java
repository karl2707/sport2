package eventHandlers;

import gui.MängTab;
import jalgpall.Goal;
import jalgpall.Player;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import application.Main;

public class GoalHandler implements EventHandler<ActionEvent> {
	private static Stage newStage;
	private static int playerID;
		
	public void handle(ActionEvent ae) {
		
		newStage = new Stage();
		newStage.initModality(Modality.APPLICATION_MODAL);
		newStage.getIcons().add(
				new Image(Main.class.getResource("ball.png").toExternalForm()));

		GridPane grid = makeGridPane();
		grid.add(new Label("Värava löönud meeskond"), 0, 0, 2, 1);

		Button ftBtn = new Button(Main.soccerGame.getTeamName(0));
		Button stBtn = new Button(Main.soccerGame.getTeamName(1));
		grid.add(ftBtn, 0, 1);
		grid.add(stBtn, 0, 2);

		ftBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				GridPane grid = makeGridPane();
				ArrayList<Player> mainPlayers = Main.soccerGame.getTeamList()[0]
						.getMainplayers();
				for (int j = 0; j < mainPlayers.size(); j++) {
					Button btn = new Button(mainPlayers.get(j).toString());
					grid.add(btn, 0, j);
					playerID = j;
					btn.setOnAction(new EventHandler<ActionEvent>() {

						public void handle(ActionEvent event) {

							Main.soccerGame.addAction(mainPlayers.get(playerID)
									.getNumber(), 0, new Goal());
							MängTab.seis.setText(Main.soccerGame.getStanding()[0]
									+ " - " + Main.soccerGame.getStanding()[1]);
							newStage.close();
						}
					});
				}
				Scene scene = new Scene(grid);
				newStage.setScene(scene);
			}
		});

		stBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				GridPane grid = makeGridPane();
				ArrayList<Player> mainPlayers = Main.soccerGame.getTeamList()[1]
						.getMainplayers();
				for (int j = 0; j < mainPlayers.size(); j++) {
					Button btn = new Button(mainPlayers.get(j).toString());
					grid.add(btn, 0, j);
					playerID = j;
					btn.setOnAction(new EventHandler<ActionEvent>() {

						public void handle(ActionEvent event) {

							Main.soccerGame.addAction(mainPlayers.get(playerID)
									.getNumber(), 1, new Goal());
							MängTab.seis.setText(Main.soccerGame.getStanding()[0]
									+ " - " + Main.soccerGame.getStanding()[1]);
							newStage.close();
						}
					});
				}
				Scene scene = new Scene(grid);
				newStage.setScene(scene);
			}
		});

		Scene scene = new Scene(grid);
		newStage.setScene(scene);
		newStage.setTitle("Värav");
		newStage.setResizable(false);
		newStage.show();
	}
	
	GridPane makeGridPane() {
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(10, 25, 25, 15));
		return grid;
	}

}
