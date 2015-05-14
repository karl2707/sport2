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

        Tab m�ng = new Tab("M�ng (F1)");
        m�ng.setClosable(false);
        m�ng.setId("m�ng");
        m�ng.setContent(M�ngTab.make());
        
        
        Tab m�ngijad = new Tab("M�ngijad (F2)");
        m�ngijad.setClosable(false);
        m�ngijad.setContent(M�ngijadTab.make());
        
        Tab logi = new Tab("Logivaataja (F3)");
        logi.setClosable(false);
        logi.setContent(LogiTab.make());
        
        tabPane.getTabs().addAll(m�ng, m�ngijad, logi);
        
        tabPane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyboardHandler());
        
        borderPane.setCenter(tabPane);
	}
	
	
}
