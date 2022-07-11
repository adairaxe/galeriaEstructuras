/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controladores;

import TDAs.LinkedList;
import ec.edu.espol.model.Fotografia;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.HBox;

import javafx.stage.FileChooser;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author USER
 */


public class VistaFotosGeneralController implements Initializable {
    private LinkedList<Fotografia> fotosAlbum;
    @FXML
    private ScrollPane spfotopequena;
    @FXML
    private ImageView ivfotoGrande;
    @FXML
    private Button btCargar;
    
    @FXML
    private ScrollPane panealbum;
    @FXML
    private HBox hbalbumes;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Aquí buscaremos las imágenes para añadir al album

        btCargar.setOnAction(event -> {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");

        // Agregar filtros para facilitar la busqueda
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
            
        // Obtener la imagen seleccionada
        File imgFile = fileChooser.showOpenDialog(null);

        
        // Mostar la imagen
        if (imgFile != null) {
           Image image = new Image("file:" + imgFile.getAbsolutePath());
           ivfotoGrande.setImage(image);
           
        }
       
    });
    }
    //va existir un archivo con formato NombreDeLaFoto+","+Formato
    public void cargarFotos(String album){
        
    }
    public void guardarFoto (String Ruta){
        
    }
    public String obtenerFormato (String Ruta){
        String formato;
        String[] format = Ruta.split("\\.");
        int ultimo =format.length-1;
        formato = format[ultimo];
    return formato;
    }


 
    
    

}
