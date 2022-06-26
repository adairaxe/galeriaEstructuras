/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import javafx.scene.image.Image;

public class Fotografia {
    
    private String descripcion, lugar, nombre;
    private Image foto, icono;
    

    public Fotografia(String descripcion, String lugar, String nombre) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.lugar = lugar;
        
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getIcono() {
        return icono;
    }

    public void setIcono(Image icono) {
        this.icono = icono;
    }

    @Override
    public String toString() {
        return "Fotografia{" + "descripcion=" + descripcion + ", lugar=" + lugar + ", nombre=" + nombre + ", foto=" + foto + ", icono=" + icono + '}';
    }
    
    
    


    
    
    
    
    
    
    
    
}
