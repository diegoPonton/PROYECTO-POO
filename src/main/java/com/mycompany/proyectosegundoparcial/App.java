package com.mycompany.proyectosegundoparcial;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;

/**
 * JavaFX App
 */
public class App extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Hola.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            // VINCULAMOS EL LA HOJA DE ESTILO CSS CON LA ESCENA
//
//            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());


            //
            stage.setTitle("Ventana Login");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
    
}
