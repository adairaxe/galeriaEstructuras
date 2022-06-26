/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controladores;

import TDAs.LinkedList;
import Interfaces.Album;
import ec.edu.espol.model.Fotografia;
import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
/**
 * FXML Controller class
 *
 * @author USER
 */
public class BibliotecaController implements Initializable {

    private FileChooser fc= new FileChooser();
    
    @FXML
    private VBox vbalbumes;
    @FXML
    private Button btalbum;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        LinkedList<Album> albumes = new LinkedList<>();

    }    

    @FXML
    private void crearAlbum(ActionEvent event) {
        
        //commit de PRUEBA
        
        String rutaAbsoluta = Paths.get("portada").toString();
        String nombreAlbum = "album 1";
        File crea_carpeta = new File(nombreAlbum);
        
        if(crea_carpeta.exists())
            System.out.println("El nombre está ocupad");
        else
            crea_carpeta.mkdir();
    }
    
    
    
    
}
