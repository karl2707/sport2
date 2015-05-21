package gui;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import eventHandlers.KeyboardHandler;

public class MakeTabs {
	public static TabPane tabPane;
	public static void make(BorderPane borderPane) {        
		tabPane = new TabPane();

        Tab mäng = new Tab("Mäng (F1)");
        mäng.setClosable(false);
        mäng.setId("mäng");
        mäng.setContent(MängTab.make());
        
        
        Tab mängijad = new Tab("Mängijad (F2)");
        mängijad.setClosable(false);
        mängijad.setContent(MängijadTab.make());
        
        Tab logi = new Tab("Logivaataja (F3)");
        logi.setClosable(false);
        logi.setContent(LogiTab.make());
        
        tabPane.getTabs().addAll(mäng, mängijad, logi);
        
        tabPane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyboardHandler());
        
        borderPane.setCenter(tabPane);
	}
	
	
}
