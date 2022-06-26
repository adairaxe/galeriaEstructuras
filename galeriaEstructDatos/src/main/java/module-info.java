module ec.edu.espol.galeriaestructdatos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens ec.edu.espol.galeriaestructdatos to javafx.fxml;
    exports ec.edu.espol.galeriaestructdatos;
    
    opens ec.edu.espol.controladores to javafx.fxml;
    exports ec.edu.espol.controladores;
    
    
}
