package application;

import gui.MakeMenu;
import gui.MakeTabs;
import gui.MängijadTab;
import gui.NewGameWindow;
import jalgpall.Action;
import jalgpall.Game;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	public static Game soccerGame;
	private static BorderPane borderPane, startPane;
	private static Scene scene, startScene;
	public static Stage mainStage;
	public static Desktop desktop = Desktop.getDesktop();

	@Override
	public void start(Stage primaryStage) {

		mainStage = primaryStage;
		mainStage.getIcons().add(
				new Image(this.getClass().getResource("ball.png")
						.toExternalForm()));
		mainStage.setTitle("Jalgpall");

		startPane = new BorderPane();
		startPane.setId("pane");

		startScene = new Scene(startPane, 800, 600, Color.WHITE);
		startScene.getStylesheets()
				.addAll(this.getClass().getResource("application.css")
						.toExternalForm());

		// bind to take available space
		startPane.prefHeightProperty().bind(startScene.heightProperty());
		startPane.prefWidthProperty().bind(startScene.widthProperty());

		MakeMenu.make(startPane, mainStage);
		mainStage.setScene(startScene);
		mainStage.setResizable(false);
		mainStage.show();
	}

	public static void doGame() {
		soccerGame = new Game(NewGameWindow.getFirstTeam(),
				NewGameWindow.getSecondTeam());
		borderPane = new BorderPane();
		scene = new Scene(borderPane, 800, 600, Color.WHITE);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		MängijadTab.ftPlayers = FXCollections.observableArrayList(NewGameWindow
				.getFirstTeam().getMainplayers());
		MängijadTab.stPlayers = FXCollections.observableArrayList(NewGameWindow
				.getSecondTeam().getMainplayers());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		MakeMenu.make(borderPane, mainStage);
		MakeTabs.make(borderPane);
		soccerGame = new Game(NewGameWindow.getFirstTeam(),
				NewGameWindow.getSecondTeam());

		mainStage.setScene(scene);
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void kirjutaFaili(ArrayList<Action> actions)
			throws FileNotFoundException, IOException {
		String fileName = soccerGame.getTeamName(0) + soccerGame.getTeamName(1)
				+ soccerGame.getGameStartTime() + ".txt";
		BufferedWriter fw = new BufferedWriter(new FileWriter(
				new File(fileName)));
		for (Action action : actions) {
			fw.write(action.toString());
			fw.newLine();
		}
		fw.newLine();
		if (Main.soccerGame.winner() >= 0) {
			fw.write("Mängu võitis "
					+ Main.soccerGame.getTeamName(Main.soccerGame.winner()));
		} else {
			fw.write("Mäng jäi viiki!");
		}
		fw.newLine();
		fw.newLine();
		fw.write(soccerGame.getGameStartDate());
		fw.close();
	}

	public static void endGame() {
		Main.soccerGame.endGame();
		try {
			kirjutaFaili(soccerGame.getActions());
		} catch (IOException e) {
			System.out.println("Faili kirjutamisel tekkis viga!");
			e.printStackTrace();
		}
	}
}
