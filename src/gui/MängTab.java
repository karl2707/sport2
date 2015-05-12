package gui;

import jalgpall.Goal;
import jalgpall.Player;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import application.Main;

public class MängTab {
	private static Stage newStage;
	private static Text seis;
	private static int playerID;

	public static BorderPane make() {
		BorderPane pane = new BorderPane();

		seis = new Text(Main.soccerGame.getStanding()[0] + " - "
				+ Main.soccerGame.getStanding()[1]);
		seis.setFont(Font.font(40));
		Label ftT = new Label(Main.soccerGame.getTeamName(0));
		ftT.setFont(Font.font(40));
		Label stT = new Label(Main.soccerGame.getTeamName(1));
		stT.setFont(Font.font(40));

		HBox infoBox = new HBox();
		infoBox.setAlignment(Pos.TOP_CENTER);
		infoBox.setPadding(new Insets(15, 12, 15, 12));
		infoBox.setSpacing(20);
		infoBox.getChildren().addAll(ftT, seis, stT);
		pane.setTop(infoBox);

		VBox functionBox = new VBox();
		functionBox.setAlignment(Pos.CENTER);
		pane.setCenter(functionBox);

		Button goalBtn = new Button("GOLAZO!");
		goalBtn.setAlignment(Pos.TOP_CENTER);
		functionBox.getChildren().add(goalBtn);

		goalBtn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				newStage = new Stage();
				newStage.initModality(Modality.APPLICATION_MODAL);
				newStage.getIcons().add(
						new Image(Main.class.getResource("ball.png")
								.toExternalForm()));

				GridPane grid = new GridPane();
				grid.add(new Label("Värava löönud meeskond"), 0, 0, 2, 1);

				Button ftBtn = new Button(Main.soccerGame.getTeamName(0));
				Button stBtn = new Button(Main.soccerGame.getTeamName(1));
				grid.add(ftBtn, 0, 1);
				grid.add(stBtn, 0, 2);

				ftBtn.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						GridPane grid = new GridPane();
						ArrayList<Player> mainPlayers = Main.soccerGame
								.getTeamList()[0].getMainplayers();
						for (int j = 0; j < mainPlayers.size(); j++) {
							Button btn = new Button(mainPlayers.get(j)
									.toString());
							grid.add(btn, 0, j);
							playerID = j;
							btn.setOnAction(new EventHandler<ActionEvent>() {

								public void handle(ActionEvent event) {

									Main.soccerGame
											.addAction(mainPlayers
													.get(playerID).getNumber(),
													0, new Goal());
									seis.setText(Main.soccerGame.getStanding()[0]
											+ " - "
											+ Main.soccerGame.getStanding()[1]);
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
						GridPane grid = new GridPane();
						ArrayList<Player> mainPlayers = Main.soccerGame
								.getTeamList()[1].getMainplayers();
						for (int j = 0; j < mainPlayers.size(); j++) {
							Button btn = new Button(mainPlayers.get(j)
									.toString());
							grid.add(btn, 0, j);
							playerID = j;
							btn.setOnAction(new EventHandler<ActionEvent>() {

								public void handle(ActionEvent event) {

									Main.soccerGame
											.addAction(mainPlayers
													.get(playerID).getNumber(),
													1, new Goal());
									seis.setText(Main.soccerGame.getStanding()[0]
											+ " - "
											+ Main.soccerGame.getStanding()[1]);
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
		});

		return pane;
	}
}
