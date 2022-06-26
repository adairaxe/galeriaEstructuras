/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import TDAs.ArrayList;
import ec.edu.espol.model.Fotografia;
import javafx.scene.image.Image;

public abstract class Album {
    
    private String nombre;   
    private Image portada;
    private String ruta;
    private ArrayList<Fotografia> fotos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getPortada() {
        return portada;
    }

    public void setPortada(Image portada) {
        this.portada = portada;
    }

    public ArrayList<Fotografia> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<Fotografia> fotos) {
        this.fotos = fotos;
    }
    
    
    public void sacarFotografia(){
        
    }
    
    
    public void agregarFotografia(){
        
    }
    
}
