/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.gameshub;

import com.mycompany.gameshub.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author adria
 */
public class GamesController implements Initializable {

    private File save = new File("D:\\Users\\adria\\Documents\\NetBeansProjects\\GamesHub\\src\\main\\resources\\save\\save.json");

    @FXML
    private Button OptionsButton;
    @FXML
    private Button HomeButton;
    @FXML
    private Button newGameButton;
    @FXML
    private Button removeGameButton;
    @FXML
    private Button editGameButton;
    @FXML
    private TableView<Game> tableGames;
    @FXML
    private TableColumn<Game, String> tableGamesName;
    @FXML
    private TableColumn<Game, String> tableGamesLink;
    @FXML
    private TableColumn<Data, Void> tableGamesButton;
    @FXML
    private GridPane gridGames;

    private int count = 0;

    /**
     * Initializes the controller class.
     */
//    ObservableList<Game> list = FXCollections.observableArrayList(
//	  new Game("Juego1", "Link1")
//    );
//    private final TableView<Data> table = new TableView<>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
	// TODO
	tableGamesName.setCellValueFactory(new PropertyValueFactory<Game, String>("nombre"));
	tableGamesLink.setCellValueFactory(new PropertyValueFactory<Game, String>("link"));

	for (Game g : App.getGames()) {
	    tableGames.getItems().add(g);
	}

	createElements();

//	addButtonToTable();
//	tableGames.setItems(list);
    }

    @FXML
    private void switchToPrimary() throws IOException {
	App.setRoot("primary2.0");
    }

    @FXML
    private void switchToNewGame() throws IOException {
	App.setRoot("new_game");
    }

    public TableColumn<Game, String> getTableGamesName() {
	return tableGamesName;
    }

    public TableColumn<Game, String> getTableGamesLink() {
	return tableGamesLink;
    }

    //Boton para borrar juego
    @FXML
    private void deleteJuegoButton(ActionEvent event) throws IOException {
	for (Game g : App.getGames()) {
	    System.out.println(g.getNombre() + "    " + tableGames.getSelectionModel().getSelectedItem().getNombre());
	    if (g.getNombre() == tableGames.getSelectionModel().getSelectedItem().getNombre() && g.getLink() == tableGames.getSelectionModel().getSelectedItem().getLink()) {
		App.getGames().remove(g);
	    }
	}
	tableGames.getItems().removeAll(tableGames.getSelectionModel().getSelectedItem());
	App.saveJSON(App.getGames(), save);
    }

    private void createElements() {
	gridGames.getChildren().clear();

	for (int i = 0; i < 2; i++) {
	    for (int j = 0; j < 1; j++) {
		gridGames.getChildren().add(createPage(count));
		count++;
	    }
	}
    }

    public VBox createPage(int index) {
	ImageView imageView = new ImageView();

	File file = new File(App.getGames().get(index).getUrlImage());
	try {
	    BufferedImage bufferedImage = ImageIO.read(file);
	    Image image = new Image(file.toURI().toString());
	    imageView.setImage(image);
	    imageView.setFitWidth(150);
	    imageView.setFitHeight(220);

	    imageView.setSmooth(true);
	    imageView.setCache(true);
	    imageView.setDisable(true);
	} catch (Exception e) {
	}

	VBox pageBox = new VBox();
	pageBox.getChildren().add(imageView);
	pageBox.setStyle("-fx-border-color: blue;");

	imageView = null;
	return pageBox;
    }

}
