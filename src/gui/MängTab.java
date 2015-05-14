package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import application.Main;
import eventHandlers.FoulHandler;
import eventHandlers.GoalHandler;
import eventHandlers.StartHandler;

public class MängTab {
	public static Text seis;
	private static Button strtBtn;
	public static Button goalBtn;
	public static Button foulBtn;
	public static VBox functionBox;
	public static VBox ftInfoBox;
	public static VBox stInfoBox;

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

		functionBox = makeVBox();
		functionBox.setAlignment(Pos.CENTER);
		pane.setCenter(functionBox);

		strtBtn = new Button("ALUSTA!");
		strtBtn.setAlignment(Pos.TOP_CENTER);

		goalBtn = new Button("GOLAZO!");
		goalBtn.setAlignment(Pos.TOP_CENTER);

		foulBtn = new Button("FOULE!");
		foulBtn.setAlignment(Pos.TOP_CENTER);

		functionBox.getChildren().add(strtBtn);

		ftInfoBox = makeVBox();
		ftInfoBox.setPrefWidth(300);
		ftInfoBox.setAlignment(Pos.TOP_LEFT);
		stInfoBox = makeVBox();
		stInfoBox.setPrefWidth(300);
		stInfoBox.setAlignment(Pos.TOP_RIGHT);
		pane.setLeft(ftInfoBox);
		pane.setRight(stInfoBox);
		
		goalBtn.setOnAction(new GoalHandler());
		foulBtn.setOnAction(new FoulHandler());
		strtBtn.setOnAction(new StartHandler());
		

		return pane;
	}

	static VBox makeVBox() {
		VBox box = new VBox();
		box.setSpacing(10);
		box.setPadding(new Insets(10, 25, 25, 15));
		return box;
	}
}
