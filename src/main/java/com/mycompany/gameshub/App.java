package com.mycompany.gameshub;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static ArrayList<Game> games = new ArrayList<Game>();
    private static Scene scene;
    private File save = new File("D:\\Users\\adria\\Documents\\NetBeansProjects\\GamesHub\\src\\main\\resources\\save\\save.json");

    @Override
    public void start(Stage stage) throws IOException {
	if (save.length() != 0) {
	    games = loadJSON(save);
	}
	scene = new Scene(loadFXML("primary"), 1400, 700);
	Image icon = new Image(getClass().getResourceAsStream("/imgs/gameshub_icon.png"));
	stage.getIcons().add(icon);
	stage.setScene(scene);
	stage.setTitle("GamesHub alpha2.0");
	stage.setResizable(false);
	stage.show();
	setRoot("primary2.0");
    }

    //Metodo para cambiar la ventana actual
    static void setRoot(String fxml) throws IOException {
	scene.setRoot(loadFXML(fxml));
    }

    //Metodo para anyadir juego a la lista games de app
    static void addJuego(String nombre, String link, Boolean favorito, String urlImage) throws IOException {
	games.add(new Game(nombre, link, favorito, urlImage));
    }

    //Guardar juegos en archivo json
    static void saveJSON(ArrayList<Game> games, File file) throws IOException {
	Gson gson = new GsonBuilder().setPrettyPrinting().create();

	try {
	    FileWriter e = new FileWriter(file);
	    String json = gson.toJson(games);
	    System.out.println(json);
	    e.write(json);
	    e.close();
	} catch (Exception e) {

	}
    }

    //Cargar juegos del json
    static ArrayList<Game> loadJSON(File file) {
	ArrayList<Game> g = null;
	Gson gson = new Gson();
	try {
	    Reader reader = Files.newBufferedReader(file.toPath());
	    //pasar a objetos
	    Type listType = new TypeToken<ArrayList<Game>>() {
	    }.getType();
	    g = gson.fromJson(reader, listType);
	} catch (Exception e) {
	}
	return g;
    }

    private static Parent loadFXML(String fxml) throws IOException {
	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
	return fxmlLoader.load();
    }

    public static void main(String[] args) {
	try {
	    String filePath = "D:\\Users\\adria\\Documents\\NetBeansProjects\\GamesHub\\src\\main\\resources\\save\\save.json";
	    File save = new File(filePath);
	    if (save.createNewFile()) {
		System.out.println("File created: " + save.getName());
	    } else {
		System.out.println("File already exists.");
	    }
	} catch (IOException e) {
	    System.out.println("An error occurred.");
	    e.printStackTrace();
	}
	launch();
    }

    public static ArrayList<Game> getGames() {
	return games;
    }

    
    
}
