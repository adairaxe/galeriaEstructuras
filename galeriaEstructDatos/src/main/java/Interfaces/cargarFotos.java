/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import TDAs.ArrayList;
import ec.edu.espol.model.Fotografia;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 *
 * @author USER
 */
public class cargarFotos {
    
    
    
    public static ArrayList<Fotografia> cargarAlbumPorNombre(String nombreAlbum){
        
        
        return null;
    }
    
    
    
    public static void agregarPortadaAlbum(File nombreAlbum, Path rutaOrigen){
        try {
            Path rutaFueraAlbum = Paths.get(nombreAlbum.getAbsolutePath());
            String stringDentroAlbum = rutaFueraAlbum.toString() + "/" + nombreAlbum.getName() + ".png";
            Path rutaDentroAlbum = Paths.get(stringDentroAlbum);
            System.out.println(rutaDentroAlbum);
            
            Files.copy(rutaOrigen, rutaDentroAlbum, REPLACE_EXISTING);
            System.out.println(rutaDentroAlbum);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
