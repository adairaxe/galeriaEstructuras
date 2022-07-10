/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controladores;

import TDAs.LinkedList;
import Interfaces.Album;
import ec.edu.espol.galeriaestructdatos.App;
import ec.edu.espol.model.Fotografia;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

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
    private void crearAlbum(ActionEvent event) throws IOException {      
        FXMLLoader loader = App.loadFXML("crearAlbum");
        Parent root= loader.load();
        App.scene.setRoot(root);
        
    }
     @FXML
    //aquí crearemos el linkedList<Album> tomándolo del archivo donde se guarda cada parteta creada
    //falta método para incorporar las fotos en caso de que existan
       private LinkedList<Album> crearLinkedAlbum(){
        LinkedList <Album> album = new LinkedList<>();
        try {
            Scanner input = new Scanner(new File(rutaAbsolutaAlbunmes));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                ArrayList<String> parametros= new ArrayList<>();
                if (line!="\n"){
                String[] linea = line.split(",");
                Album nuevoAlbum = new AlbumPublico(linea[0],linea[1]);
                album.addLast(nuevoAlbum);
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return album;
    }
    
    
}
