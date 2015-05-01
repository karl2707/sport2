package gui;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InformationWindow {
	public static void make() {
		System.out.println("you");
		Parent root = new Group();
		Stage stage = new Stage();
        stage.setTitle("Jalpalli abimees");
        stage.setScene(new Scene(root, 100, 100));
        stage.setResizable(false);
        stage.show();
	}
}
