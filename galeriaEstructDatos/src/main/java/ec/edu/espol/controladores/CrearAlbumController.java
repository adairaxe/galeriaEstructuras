/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controladores;

import Interfaces.Album;
import Interfaces.Rutas;
import Interfaces.cargarFotos;
import ec.edu.espol.model.AlbumPublico;
import ec.edu.espol.model.Fotografia;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class CrearAlbumController extends Rutas implements Initializable {

    @FXML
    private TextField etnombre;
    @FXML
    private TextField etdescripcion;
    @FXML
    private Button btguardar;
    @FXML
    private ImageView ivportada;
    
    
    // atributos Agregados manualmente
    private Path rutaPortada;
    
    public final String rutaAbsolutaAlbunmes = "C:\\Users\\USER\\Documents\\NetBeansProjects\\galeriaEstructuras\\galeriaEstructDatos\\Albumes\\";
    
    public FileChooser fc= new FileChooser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    
    @FXML
    private void guardarAlbum(ActionEvent event) {
        
        String etNombre = etnombre.getText();
        String etDescripcion = etdescripcion.getText();
        Image ivPortada = ivportada.getImage();
        
        if(!etNombre.isEmpty() && !etDescripcion.isEmpty() && ivPortada != null){            
            Album nuevoAlbum = new AlbumPublico(etNombre, etDescripcion, ivPortada);             
            File creaAlbum = new File(rutaAbsolutaAlbunmes + nuevoAlbum.getNombre());

            if(creaAlbum.exists())               
                System.out.println("El nombre está ocupado");
            
            else{  
                guardarRegistro(etNombre, etDescripcion);
                creaAlbum.mkdir();
                cargarFotos.agregarPortadaAlbum(creaAlbum, rutaPortada);       
            }
        }
    }

    
    
    @FXML
    private void cargarPortada(MouseEvent event) {
        
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        File seledFile= fc.showOpenDialog(null);
        
        if (seledFile!= null){
            Image img = new Image(seledFile.toURI().toString());
            rutaPortada = seledFile.toPath();
            System.out.println("RUTA DE LA FOTO ORIGINAL");
            System.out.println(rutaPortada);
            ivportada.setImage(img);
        }
    }
        //aquí guardaremos los datos que cargaremos en un linkedlist Album para cargarlos en la interfaz
        private void guardarRegistro(String nombre, String descripcion) {
        try {
            
           File file= new File(rutaAbsolutaAlbunmes  + "Albumes.txt");
           //String path =rutaAbsolutaAlbunmes  + "Albumes.txt";
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            //bw.newLine();
            bw.write(nombre+","+descripcion);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
