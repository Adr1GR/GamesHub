/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gameshub;

import javafx.stage.FileChooser;

/**
 *
 * @author adria
 */
public class Game {
    private String nombre;
    private String link;
    private Boolean favorito;
    private String urlImage;

    public Game(String nombre, String link, Boolean favorito, String urlImage) {
	this.nombre = nombre;
	this.link = link;
	this.favorito = favorito;
	this.urlImage = urlImage;
    }
    
    public Game() {
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getLink() {
	return link;
    }

    public void setLink(String link) {
	this.link = link;
    }

    public Boolean getFavorito() {
	return favorito;
    }

    public void setFavorito(Boolean favorito) {
	this.favorito = favorito;
    }

    public String getUrlImage() {
	return urlImage;
    }

    public void setUrlImage(String urlImage) {
	this.urlImage = urlImage;
    }
    
    
    
}
