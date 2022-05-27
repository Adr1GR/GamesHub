/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gameshub;

/**
 *
 * @author adria
 */
public class Data {

    private int id;
    private String name;

    private Data(int id, String name) {
	this.id = id;
	this.name = name;
    }

    public int getId() {
	return id;
    }

    public void setId(int ID) {
	this.id = ID;
    }

    public String getName() {
	return name;
    }

    public void setName(String nme) {
	this.name = nme;
    }

    @Override
    public String toString() {
	return "id: " + id + " - " + "name: " + name;
    }

}
