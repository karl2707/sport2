package gui;

import eventHandlers.KeyboardHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MakeTabs {
	public static void make(BorderPane borderPane) {
        
		TabPane tabPane = new TabPane();

        Tab mäng = new Tab("Mäng (F1)");
        mäng.setClosable(false);
        mäng.setId("mäng");
        //mäng.setContent();
        
        
        Tab mängijad = new Tab("Mängijad (F2)");
        mängijad.setClosable(false);
        mängijad.setContent(MängijadTab.make());
        
        Tab võistkonnad = new Tab("Võistkonnad (F3)");
        võistkonnad.setClosable(false);
        
        tabPane.getTabs().addAll(mäng, mängijad, võistkonnad);
        
        
        
        tabPane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyboardHandler());
        
        borderPane.setCenter(tabPane);
	}
	
	
}
