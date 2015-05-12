package gui;

import jalgpall.Goal;
import jalgpall.Player;

import java.util.ArrayList;

import eventHandlers.GoalHandler;
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
	public static Text seis;

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

		goalBtn.setOnAction(new GoalHandler());

		return pane;
	}
}
