/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.controladores;

import TDAs.LinkedList;
import Interfaces.Album;
import TDAs.ArrayList;
import ec.edu.espol.galeriaestructdatos.App;
import ec.edu.espol.model.AlbumPublico;
import ec.edu.espol.model.Fotografia;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
/**
 * FXML Controller class
 *
 * @author USER
 */
public class BibliotecaController implements Initializable {
    public final String rutaAbsolutaAlbunmes = "C:.\\Albumes\\";

    private FileChooser fc= new FileChooser();
    
    @FXML
    private VBox vbalbumes;
    @FXML
    private Button btalbum;

    
    private LinkedList <Album> albumes;
   

    @FXML
    private ScrollPane panelalbumes;
    @FXML
    private HBox hbalbumes;
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crearLinkedAlbum();
        //LinkedList<Album> albumes = new LinkedList<>();

    }    

    @FXML
    private void crearAlbum(ActionEvent event) throws IOException {      
        FXMLLoader loader = App.loadFXML("crearAlbum");
        Parent root= loader.load();
        App.scene.setRoot(root);
        
    }
    
    @FXML
    //aqu?? crearemos el linkedList<Album> tom??ndolo del archivo donde se guarda cada parteta creada
    private void crearLinkedAlbum(){
        //LinkedList <Album> album = new LinkedList<>();
        try {
            Scanner input = new Scanner(new File(rutaAbsolutaAlbunmes));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                //ArrayList<String> parametros= new ArrayList<>();
                if (!line.equals("\n")){
                    String[] linea = line.split(",");
                    Album nuevoAlbum = new Album(linea[0],linea[1]) {};
                    albumes.addLast(nuevoAlbum);
                }
            }
            input.close();
        } catch (FileNotFoundException ex) {
        }
        //return album;
    }
    
    @FXML
    //al borrar un album debemos removeer del linker, borrar carpeta y borrar registro del archivo

    private Album elimininarAlbum (int i){
    //eliminamos del tda
    Album album = albumes.remove(i);
    //eliminamos la carpeta
        File f = new File(rutaAbsolutaAlbunmes + album.getNombre());	
        if (f.delete())
            System.out.println("Se elimin?? la carpeta " + album.getNombre() );
        else
            System.out.println("Hubo un problema contacte al desarrollador");
    
        removeLineFromFile (rutaAbsolutaAlbunmes  + "Albumes.txt",album.getNombre()+","+album.getDescripcion());
        return album;
    }
    //c??digo tomado de http://pacholalala.blogspot.com/2009/09/eliminar-una-linea-de-un-archivo-de.html 
    //para borrar una linea de un archivo cr??ditos a su autor

    public void removeLineFromFile(String file, String lineToRemove) {

        try {

        File inFile = new File(file);
        if (!inFile.isFile()) {
            System.out.println("El par??metro no existe en el archivo");
        return;
        }
         //Construct the new file that will later be renamed to the original filename. 
        File tempFile = new File(inFile.getAbsolutePath() + ".tmp");
        BufferedReader br = new BufferedReader(new FileReader(file));
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
        String line = null;

        //Read from the original file and write to the new 
        //unless content matches data to be removed.
        while ((line = br.readLine()) != null) {
   
            if (!line.trim().equals(lineToRemove)) {
                pw.println(line);
                pw.flush();
            }
        }
         pw.close();
         br.close();
   
         //Delete the original file
         if (!inFile.delete()) {
            System.out.println("Could not delete file");
         return;
         } 
   
  //Rename the new file to the filename the original file had.
        if (!tempFile.renameTo(inFile))
            System.out.println("Could not rename file");
   
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            System.out.println("Algun problema existi??");
        }
  
    }    
    
       
    public void cargarAlbumes(java.util.ArrayList<Album> albumes){
        /*Album hola = new AlbumPublico("hola", "holaaa");
        Image portada = new Image(getClass().getResourceAsStream("Portada/Portada.png"));
        hola.setPortada(portada);
        ImageView imgviewPrueba = new ImageView(hola.getPortada());*/
        for(Album album : albumes){
            
            // EJEMPLO Image img = new Image("img/"+p.getNomfile());
            //Image imgPortada = new Image("RUTA_ARCHIVO_ALBUMES/"+ album.getPortada());
            ImageView imgview = new ImageView(album.getPortada());
            imgview.setOnMouseClicked(
                    (MouseEvent e)->
                    {
                try {
                    FXMLLoader loader = App.loadFXML("vistaFotosGeneral");
                    Parent root= loader.load();
                    App.scene.setRoot(root);
                    
//                        hbalbumes.getChildren().clear();
//                        Text titulo = new Text(p.getTitulo());
//                        Text sinopsis = new Text(p.getSinopsis());
//                        sinopsis.setWrappingWidth(200);
//                        hbalbumes.getChildren().add(titulo);
//                        hbalbumes.getChildren().add(sinopsis);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                    }
            );
            hbalbumes.getChildren().add(imgview);
        }
        //hbalbumes.getChildren().add(imgviewPrueba);
    }
    

}
