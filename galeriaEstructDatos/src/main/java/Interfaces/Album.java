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

    public Album(String nombre, String descripcion, Image portada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.portada = portada;
    }
  
}