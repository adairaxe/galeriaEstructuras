/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import TDAs.LinkedList;
import ec.edu.espol.model.Fotografia;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author USER
 */
public abstract class Album {
    String nombre;
    String descripcion;
    Image portada;
    LinkedList<Fotografia> fotos;


    
    public Album(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.portada = new Image(getClass().getResourceAsStream("Portada/Portada.png"));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Image getPortada() {
        return portada;
    }

    public void setPortada(Image portada) {
        this.portada = portada;
    }

    public LinkedList<Fotografia> getFotos() {
        return fotos;
    }

    public void setFotos(LinkedList<Fotografia> fotos) {
        this.fotos = fotos;
    }
    
    
  
}