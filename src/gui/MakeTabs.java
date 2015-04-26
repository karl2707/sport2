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

        Tab m�ng = new Tab();
        m�ng.setText("M�ng (F1)");
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label("Tab"));
        hbox.setAlignment(Pos.CENTER);
        m�ng.setContent(hbox);
        
        
        
        Tab m�ngijad = new Tab();
        m�ngijad.setText("M�ngijad (F2)");
        HBox hbox1 = new HBox();
        hbox1.getChildren().add(new Label("Tab"));
        hbox1.setAlignment(Pos.CENTER);
        m�ngijad.setContent(hbox);
        
        tabPane.getTabs().addAll(m�ng, m�ngijad);
        
        borderPane.setCenter(tabPane);
	}
}
