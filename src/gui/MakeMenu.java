package gui;

import javafx.application.Platform;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MakeMenu {
	public static void make(BorderPane borderPane, Stage primaryStage) {
		MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        borderPane.setTop(menuBar);

        // File menu - new, save, exit
        Menu failMenu = new Menu("Fail");
        MenuItem newMenuItem = new MenuItem("Uus");
        MenuItem openMenuItem = new MenuItem("Ava");
        MenuItem saveMenuItem = new MenuItem("Salvesta");
        MenuItem exitMenuItem = new MenuItem("Välju");
                
        failMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem,
            new SeparatorMenuItem(), exitMenuItem);

        Menu abiMenu = new Menu("Abi");
        MenuItem abiMenuItem = new MenuItem("Programmist");

        abiMenu.getItems().add(abiMenuItem);
        
        menuBar.getMenus().addAll(failMenu, abiMenu);
        
        
        // sündmusete käsitlejad
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());
        abiMenuItem.setOnAction(event -> InformationWindow.make());
        newMenuItem.setOnAction(event -> NewGameWindow.make());
        
	}
}
