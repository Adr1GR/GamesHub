/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gameshub;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author adria
 */
public class NewGameController implements Initializable {

    private File save = new File("D:\\Users\\adria\\Documents\\NetBeansProjects\\GamesHub\\src\\main\\resources\\save\\save.json");

    @FXML
    private Button acceptNewGameButton;
    @FXML
    private Button backNewGameButton;
    @FXML
    private TextField newGameLink;
    @FXML
    private TextField newGameURL;
    @FXML
    private TextField newGameName;
    @FXML
    private Text estadoNewGame;
    @FXML
    private CheckBox favoriteCheckNewGame;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
    }

    @FXML
    private void switchToGames() throws IOException {
	App.setRoot("games");
    }

    //Boton para añadir un juego "aceptar"
    @FXML
    private void addJuegoButton() throws IOException {
	String nombre = newGameName.getText();
	String link = newGameLink.getText();
	boolean favorito;
	if (favoriteCheckNewGame.isSelected()){
	    favorito = true;
	} else {
	    favorito = false;
	}
	String urlImage = newGameURL.getText();
	if (newGameName.getText() != "" && newGameLink.getText() != "") {
	    App.addJuego(nombre, link, favorito, urlImage);
	    estadoNewGame.setText(newGameName.getText() + " added successfully");
	    App.saveJSON(App.getGames(), save);
	} else {
	    estadoNewGame.setText("Error adding game");
	}
    }
}
