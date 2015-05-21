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
				+ "Jalgpalli abimees aitab teil programmi paremini m�ista. \n"
				+ "M�ngu alustamiseks valiga men��st 'Fail' -> 'Uus' \n"
				+ "Alustava vile k�lades vajutage nuppu start. \n"
				+ "Kui m�ngus peaks toimuma viga v�i v�rav, on teil v�imalus see sisestada, vajutades vastavatele nuppudele kasutajaliideses \n"
				+ "M�ngu l�puvile k�lades vajutage nuppu 'ENDO!', mille peale m�ng l�petatakse ja v�ljastatakse statistika ekraanile ja logifaili.");
		
        root.getChildren().add(text);
		stage.setTitle("Jalpalli abimees");        
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
	}
}
