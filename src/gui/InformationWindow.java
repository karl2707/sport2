package gui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class InformationWindow {
	public static void make() {
		Group root = new Group();
		Stage stage = new Stage();
		Label text = new Label("Tere! \n"
				+ "Jalgpalli abimees aitab teil programmi paremini mõista. \n"
				+ "Mängu alustamiseks valiga menüüst 'Fail' -> 'Uus' \n"
				+ "Alustava vile kõlades vajutage nuppu start. \n"
				+ "Kui mängus peaks toimuma viga või värav, on teil võimalus see sisestada, vajutades vastavatele nuppudele kasutajaliideses \n"
				+ "Mängu lõpuvile kõlades vajutage nuppu 'ENDO!', mille peale mäng lõpetatakse ja väljastatakse statistika ekraanile ja logifaili.");
		
        root.getChildren().add(text);
		stage.setTitle("Jalpalli abimees");        
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
	}
}
