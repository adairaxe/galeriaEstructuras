/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import TDAs.ArrayList;
import TDAs.LinkedList;

/**
 *
 * @author USER
 */
public abstract class GenerarListas<E> {
    
    public abstract ArrayList<E> generarArrayList(String nombreArchivo);
    
    public abstract LinkedList<E> generarLinkedList(String nombreArchivo);
    
}
