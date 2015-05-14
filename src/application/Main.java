package application;

import gui.LogiTab;
import gui.MakeMenu;
import gui.MakeTabs;
import gui.MängijadTab;
import gui.NewGameWindow;
import jalgpall.Action;
import jalgpall.Game;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
		mainStage.setMinHeight(startScene.getHeight());
		mainStage.setMinWidth(startScene.getWidth());
		mainStage.setScene(startScene);
		mainStage.setResizable(false);
		mainStage.show();
	}

	public static void doGame() {
		soccerGame = new Game(NewGameWindow.getFirstTeam(),
				NewGameWindow.getSecondTeam());
		makeStage();
		MängijadTab.ftPlayers = FXCollections.observableArrayList(NewGameWindow
				.getFirstTeam().getMainplayers());
		MängijadTab.stPlayers = FXCollections.observableArrayList(NewGameWindow
				.getSecondTeam().getMainplayers());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		soccerGame = new Game(NewGameWindow.getFirstTeam(),
				NewGameWindow.getSecondTeam());
	}

	public static void kirjutaFaili(ArrayList<Action> actions)
			throws FileNotFoundException, IOException {
		String fileName = soccerGame.getTeamName(0) + soccerGame.getTeamName(1)
				+ soccerGame.getGameStartTime() + ".txt";
		BufferedWriter fw = new BufferedWriter(new FileWriter(
				new File(fileName)));

		fw.write(soccerGame.getTeamName(0) + " vs " + soccerGame.getTeamName(1));
		fw.newLine();
		fw.write(soccerGame.getTeamName(0) + " tegevus:");
		fw.newLine();
		for (Action action : actions) {
			if (soccerGame.getTeamList()[0].getMainplayers().contains(action.getPlayer()))
			fw.write(action.toString());
			fw.newLine();
		}
		fw.write(soccerGame.getTeamName(1) + " tegevus:");
		fw.newLine();
		for (Action action : actions) {
			if (soccerGame.getTeamList()[1].getMainplayers().contains(action.getPlayer()))
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

	public static void doOpen(String path) {
		File file = new File(path);
		StringBuilder info = new StringBuilder();

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			while (br.ready()) {
				info.append(br.readLine() + "\n");
			}
		} catch (IOException e) {
			System.out.println("Failist lugemine ebaõnnestus!");
			e.printStackTrace();
		}
		LogiTab.doLogi(info.toString());
		MakeTabs.tabPane.getSelectionModel().select(2);
	}
	
	public static void makeStage() {
		borderPane = new BorderPane();
		scene = new Scene(borderPane, 800, 600, Color.WHITE);
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		MakeMenu.make(borderPane, mainStage);
		MakeTabs.make(borderPane);
		mainStage.setScene(scene);
		mainStage.setMinHeight(scene.getHeight());
		mainStage.setMinWidth(scene.getWidth());
		mainStage.setResizable(true);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
