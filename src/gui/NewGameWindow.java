package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class NewGameWindow {
	public static void make() {
		Stage newStage = new Stage();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(5, 25, 25, 25));

		Label head = new Label("Tere! Olete loomas uut mängu.");
		grid.add(head, 0, 0);

		Label pks = new Label("Sisestage põhikoosseisu suurus (koos väravavahiga): ");
		grid.add(pks, 0, 1);

		TextField pksTextField = new TextField();
		grid.add(pksTextField, 0, 2);

		Label pap = new Label("Sisestage poolaja pikkus: ");
		grid.add(pap, 0, 3);

		TextField papTextField = new TextField();
		grid.add(papTextField, 0, 4);
		
		Button btnSisesta = new Button("Edasi >");
		
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btnSisesta);
		grid.add(hbBtn, 0, 6);		
		
		Scene scene = new Scene(grid, 400, 300);
		newStage.setTitle("Uue mängu loomine");
		newStage.setScene(scene);
		newStage.setResizable(false);
		newStage.show();
	}
}
