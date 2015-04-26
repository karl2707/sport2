package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MakeTabs {
	public static void make(BorderPane borderPane) {
        
		TabPane tabPane = new TabPane();

        Tab mäng = new Tab();
        mäng.setText("Mäng (F1)");
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label("Tab"));
        hbox.setAlignment(Pos.CENTER);
        mäng.setContent(hbox);
        
        
        
        Tab mängijad = new Tab();
        mängijad.setText("Mängijad (F2)");
        HBox hbox1 = new HBox();
        hbox1.getChildren().add(new Label("Tab"));
        hbox1.setAlignment(Pos.CENTER);
        mängijad.setContent(hbox);
        
        tabPane.getTabs().addAll(mäng, mängijad);
        
        borderPane.setCenter(tabPane);
	}
}
