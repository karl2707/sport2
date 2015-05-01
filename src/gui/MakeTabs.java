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

        Tab m�ng = new Tab("M�ng (F1)");
        m�ng.setClosable(false);
        m�ng.setId("m�ng");
        //m�ng.setContent();
        
        
        Tab m�ngijad = new Tab("M�ngijad (F2)");
        m�ngijad.setClosable(false);
        m�ngijad.setContent(M�ngijadTab.make());
        
        Tab v�istkonnad = new Tab("V�istkonnad (F3)");
        v�istkonnad.setClosable(false);
        
        tabPane.getTabs().addAll(m�ng, m�ngijad, v�istkonnad);
        
        
        
        tabPane.addEventHandler(KeyEvent.KEY_PRESSED, new KeyboardHandler());
        
        borderPane.setCenter(tabPane);
	}
	
	
}
