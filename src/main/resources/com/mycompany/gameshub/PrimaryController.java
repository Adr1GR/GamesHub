/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gameshub;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author adria
 */
public class PrimaryController implements Initializable {

    @FXML
    private Button OptionsButton;
    @FXML
    private Button GamesButton;
    @FXML
    private TableView<Game> tableFavoriteGames;
    @FXML
    private TableColumn<Game, String> tableGamesName;
    @FXML
    private TableColumn<Game, String> tableGamesLink;
    @FXML
    private TableColumn<Data, Void> tableGamesButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
	tableGamesName.setCellValueFactory(new PropertyValueFactory<Game, String>("nombre"));
	tableGamesLink.setCellValueFactory(new PropertyValueFactory<Game, String>("link"));

	for (Game g : App.getGames()) {
	    if (g.getFavorito()) {
		tableFavoriteGames.getItems().add(g);
	    }
	}
    }

    @FXML
    private void switchToGames() throws IOException {
	App.setRoot("games");
    }

}
