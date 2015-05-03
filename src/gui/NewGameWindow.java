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

		// Label head = new Label("Tere! Olete loomas uut mängu.");
		// grid.add(head, 0, 0);

		Label pks = new Label("Põhikoosseisu suurus (koos vv-ga): ");
		grid.add(pks, 0, 1);

		TextField pksTextField = new TextField("11");
		grid.add(pksTextField, 1, 1);

		Label pap = new Label("Poolaja pikkus minutites: ");
		grid.add(pap, 0, 2);

		TextField papTextField = new TextField("45");
		grid.add(papTextField, 1, 2);

		Label ft = new Label("Esimese meeskonna nimi: ");
		grid.add(ft, 0, 3);
		TextField ftTextField = new TextField();
		grid.add(ftTextField, 1, 3);
		Label ftN = new Label("Esimese meeskonna mängijate arv:");
		grid.add(ftN, 0, 4);
		TextField ftNTextField = new TextField();
		grid.add(ftNTextField, 1, 4);

		Label st = new Label("Teise meeskonna nimi: ");
		grid.add(st, 0, 5);
		TextField stTextField = new TextField();
		grid.add(stTextField, 1, 5);
		Label stN = new Label("Teise meeskonna mängijate arv:");
		grid.add(stN, 0, 6);
		TextField stNTextField = new TextField();
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
					int pksN = Integer.parseInt(pksTextField.getText());
					int papN = Integer.parseInt(papTextField.getText());

					String ftName = ftTextField.getText();
					int ftN = Integer.parseInt(ftNTextField.getText());

					String stName = stTextField.getText();
					int stN = Integer.parseInt(stNTextField.getText());

					newStage.hide();

					if (!(ftN < pksN && stN < pksN)) {
						makeTeamsWindow(pksN, papN, ftName, ftN, stName, stN);
					}
				}

				catch (NumberFormatException e) {
					errorText
							.setText("Sisestasite vale väärtuse. Proovige uuesti.");
				}
			}
		});

		Scene scene = new Scene(grid, 400, 300);
		newStage.setTitle("Uue mängu loomine");
		newStage.setScene(scene);
		newStage.setResizable(false);
		newStage.show();
	}

	public static void makeTeamsWindow(int pksN, int papN, String ftName,
			int ftN, String stName, int stN) {
		Stage newStage = new Stage();

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(5, 25, 25, 25));

		Label text = new Label("Sisestage mängija nimi ja number");
		grid.add(text, 0, 0);

		for (int i = 0; i < ftN; i++) {
			TextField playerName = new TextField();
			grid.add(playerName, 0, i + 1);
			TextField playerNumber = new TextField();
			grid.add(playerNumber, 1, i + 1);
		}

		Scene scene = new Scene(grid);
		newStage.setTitle("Uue meeskonna loomine");
		newStage.setScene(scene);
		newStage.setResizable(false);
		newStage.show();

	}
}
