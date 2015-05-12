package application;

import gui.MakeMenu;
import gui.MakeTabs;
import gui.NewGameWindow;
import jalgpall.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	public static Game soccerGame;
	private static BorderPane borderPane, startPane;
	private static Scene scene, startScene;
	private static Stage mainStage;

	@Override
	public void start(Stage primaryStage) {
		
		mainStage = primaryStage;
		mainStage.getIcons().add(new Image(
				this.getClass().getResource("ball.png").toExternalForm()));
		mainStage.setTitle("Jalgpall");		

		startPane = new BorderPane();
		startPane.setId("pane");
		
		startScene = new Scene(startPane, 800, 600, Color.WHITE);
		startScene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		
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
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		MakeMenu.make(borderPane, mainStage);
		MakeTabs.make(borderPane);
		mainStage.setScene(scene);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
