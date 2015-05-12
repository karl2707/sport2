package gui;

import exceptions.IncorrectInputException;
import jalgpall.Player;
import jalgpall.Team;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import application.Main;

public class NewGameWindow {
	private static Team team;
	private static Team firstTeam;
	private static Team secondTeam;
	private static int poolajaPikkus;
	private static Stage newStage;

	public static Team getFirstTeam() {
		return firstTeam;
	}

	public static Team getSecondTeam() {
		return secondTeam;
	}

	static int getPoolajaPikkus() {
		return poolajaPikkus;
	}

	/**
	 * stluN - starting line-up size / algkoosseisu suurus htl - half time
	 * length / poolaja pikkus ft - first team / esimene meeskond ftN - first
	 * team size / esimese meeskonna suurus ftName - first team name / esimese
	 * meeskonna nimi st - second team / teine meeskond stN - second team size /
	 * teise meeskonna suurus stName - second team name / teise meeskonna nimi
	 */
	public static void make() {
		newStage = new Stage();
		newStage.initModality(Modality.APPLICATION_MODAL);
		newStage.getIcons().add(new Image(
				Main.class.getResource("ball.png").toExternalForm()));
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 25, 25, 15));

		Label stluN = new Label("Pıhikoosseisu suurus (koos vv-ga): ");
		grid.add(stluN, 0, 1);

		TextField stluNTextField = new TextField("1");
		grid.add(stluNTextField, 1, 1);

		Label htl = new Label("Poolaja pikkus minutites: ");
		grid.add(htl, 0, 2);

		TextField htlTextField = new TextField("45");
		grid.add(htlTextField, 1, 2);

		Label ft = new Label("Esimese meeskonna nimi: ");
		grid.add(ft, 0, 3);
		TextField ftTextField = new TextField("A");
		grid.add(ftTextField, 1, 3);
		Label ftN = new Label("Esimese meeskonna m‰ngijate arv:");
		grid.add(ftN, 0, 4);
		TextField ftNTextField = new TextField("1");
		grid.add(ftNTextField, 1, 4);

		Label st = new Label("Teise meeskonna nimi: ");
		grid.add(st, 0, 5);
		TextField stTextField = new TextField("B");
		grid.add(stTextField, 1, 5);
		Label stN = new Label("Teise meeskonna m‰ngijate arv:");
		grid.add(stN, 0, 6);
		TextField stNTextField = new TextField("1");
		grid.add(stNTextField, 1, 6);

		Button btnSisesta = new Button("Edasi >");

		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btnSisesta);
		grid.add(hbBtn, 0, 8, 2, 1);

		Label errorText = new Label();
		grid.add(errorText, 0, 8, 2, 1);

		btnSisesta.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				try {
					
					int stluN = Integer.parseInt(stluNTextField.getText());
					poolajaPikkus = Integer.parseInt(htlTextField.getText());

					String ftName = ftTextField.getText();
					int ftN = Integer.parseInt(ftNTextField.getText());

					String stName = stTextField.getText();
					int stN = Integer.parseInt(stNTextField.getText());

					if (ftN < stluN || stN < stluN || poolajaPikkus <= 0) {
						throw new IncorrectInputException();
					}
					else {
						makeNewTeamWindow(stluN, ftName, ftN, stName, stN, 0);
					}
				}

				catch (NumberFormatException | IncorrectInputException e) {
					errorText
							.setText("Sisestasite vale v‰‰rtuse. Proovige uuesti.");
				}
			}
		});

		Scene scene = new Scene(grid, 400, 300);
		newStage.setTitle("Uue m‰ngu loomine");
		newStage.setScene(scene);
		newStage.setResizable(false);
		newStage.show();

	}

	public static void makeNewTeamWindow(int stluN, String ftName, int ftN,
			String stName, int stN, int i) {
		GridPane grid = makeGridPane();
		grid.setPadding(new Insets(5, 25, 25, 10));

		String tName;
		int tN;
		
		if (i == 0) {
			tName = ftName;
			tN = ftN;
		} else {
			tName = stName;
			tN = stN;
		}

		grid.add(new Label("Meeskond " + tName), 0, 0);
		grid.add(new Label("Pıhikoosseisu m‰ngijad: "), 0, 1);
		grid.add(new Label("Nimi"), 0, 2);

		Label number = new Label("Number");
		HBox hbNumber = new HBox(10, number);
		hbNumber.setAlignment(Pos.CENTER_RIGHT);
		grid.add(hbNumber, 0, 2);

		GridPane maingrid = makeGridPane();
		grid.add(maingrid, 0, 3);

		GridPane benchgrid = makeGridPane();

		Button btnSisesta = new Button((i == 0) ? "Edasi >" : "Lıpeta");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btnSisesta);
		Label errorText = new Label();

		if (tN > stluN) {
			grid.add(hbBtn, 0, 6, 2, 1);
			grid.add(errorText, 0, 7, 2, 2);
		} else {
			grid.add(hbBtn, 0, 4, 2, 1);
			grid.add(errorText, 0, 5, 2, 2);
		}

		for (int j = 0; j < tN; j++) {
			if (j >= stluN) {
				if (j == stluN) {
					grid.add(new Label("Varum‰ngijad: "), 0, 4);
					grid.add(benchgrid, 0, 5);
				}
				TextField playerName = new TextField();
				benchgrid.add(playerName, 0, j - stluN);
				TextField playerNumber = new TextField();
				playerNumber.setPrefWidth(30);
				benchgrid.add(playerNumber, 1, j - stluN);
			} else {
				TextField playerName = new TextField();
				maingrid.add(playerName, 0, j);
				TextField playerNumber = new TextField();
				playerNumber.setPrefWidth(30);
				maingrid.add(playerNumber, 1, j);
			}
		}

		btnSisesta.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				try {
					ArrayList<Player> mainplayers = new ArrayList<>();
					ArrayList<Player> benchplayers = new ArrayList<>();
					for (int i = 0; i < stluN * 2; i += 2) {
						String playerName = ((TextField) maingrid.getChildren()
								.get(i)).getText().trim();
						int playerNumber = Integer
								.parseInt(((TextField) maingrid.getChildren()
										.get(i + 1)).getText().trim());
						Player player = new Player(playerName, playerNumber);
						mainplayers.add(player);
					}

					for (int i = 0; i < (tN - stluN) * 2; i += 2) {
						String playerName = ((TextField) benchgrid
								.getChildren().get(i)).getText().trim();
						int playerNumber = Integer
								.parseInt(((TextField) benchgrid.getChildren()
										.get(i + 1)).getText().trim());
						Player player = new Player(playerName, playerNumber);
						benchplayers.add(player);
					}

					if (benchplayers.size() > 0) {
						team = new Team(tName, mainplayers, benchplayers, (i == 0) ? 0 : 1);
					} else {
						team = new Team(tName, mainplayers, (i == 0) ? 0 : 1);
					}

					if (i == 0) {
						firstTeam = team;
						makeNewTeamWindow(stluN, ftName, ftN, stName, stN, 1);
					} else {
						secondTeam = team;
						newStage.close();
						Main.doGame();
					}
				}

				catch (NumberFormatException e) {
					errorText
							.setText("Sisestasite vale v‰‰rtuse.\nProovige uuesti.");
				}
			}
		});

		Scene scene = new Scene(grid, 250, grid.getPrefHeight());
		newStage.setTitle("Uue meeskonna loomine");
		newStage.setScene(scene);
	}

	public static GridPane makeGridPane() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		return grid;
	}
}
