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
        MenuItem saveMenuItem = new MenuItem("Salvesta");
        MenuItem exitMenuItem = new MenuItem("Välju");
        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        failMenu.getItems().addAll(newMenuItem, saveMenuItem,
            new SeparatorMenuItem(), exitMenuItem);

        Menu abiMenu = new Menu("Abi");

        menuBar.getMenus().addAll(failMenu, abiMenu);
	}
}
