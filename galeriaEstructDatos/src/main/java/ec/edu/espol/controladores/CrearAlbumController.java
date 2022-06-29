/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controladores;

import Interfaces.Album;
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
public class CrearAlbumController implements Initializable {

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
    
    public final String rutaAbsoluta = "C:\\Users\\USER\\Documents\\NetBeansProjects\\galeriaEstructuras\\galeriaEstructDatos\\Albumes\\";

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
            
            Fotografia foto = new Fotografia(ivPortada);
            
            Album nuevoAlbum = new AlbumPublico(etNombre, etDescripcion, ivPortada);      
            String nombreAlbum = nuevoAlbum.getNombre();
            
            File creaAlbum = new File(rutaAbsoluta + nombreAlbum);
            

            if(creaAlbum.exists())
                
                System.out.println("El nombre está ocupado");
            else{
                
                creaAlbum.mkdir();
                
                String rutaDestino = rutaAbsoluta + "/" + nombreAlbum +" /" + "fot.png";
                Path d = Paths.get(rutaDestino);
                
//                Path rutaAlbumCreado_prueba = Paths.get(creaAlbum.getPath().toString() + ".png");
//                System.out.println("ruta Pueba");
//                String stringrutaAlbumCreado = creaAlbum.toPath().toString()+".png";
//                Path rutaAlbumCreado = Paths.get(stringrutaAlbumCreado);
//                System.out.println("RUTA DE LA carpeta DESTINo");
//                System.out.println(rutaAlbumCreado);
                
                try {                    
                    Files.copy(rutaPortada, d, REPLACE_EXISTING);
                    System.out.println("Se copio el archivo");
                } catch (IOException ex) {
                    System.out.println(ex);
                }   
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
    
}
