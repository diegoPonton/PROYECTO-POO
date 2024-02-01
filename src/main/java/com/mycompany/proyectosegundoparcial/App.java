package com.mycompany.proyectosegundoparcial;

import Modelo.Cliente;
import Modelo.PickUp;
import Modelo.Principal;
import Modelo.Reserva;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.image.Image;


/**
 * JavaFX App
 */
public class App extends Application {
    
    private static Scene scene;
    private static Stage stagePrincipal;
    

    public static Reserva reserva = new Reserva();
    
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<PickUp> pickups = new ArrayList<>();
    public static Cliente userLogin = null;
    public static boolean close = false;
    @Override
    public void init() throws Exception  {
        super.init();
        
        //Se cargaran todos los datos
        clientes = Cliente.clientes("clientes.txt");
        pickups = PickUp.pickup("promociones.txt");
    }
    
    
   
   
    @Override
    public void start(Stage stage) throws IOException {
        stagePrincipal = stage; //Se copia la direccion de memoria
        try{
        //FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/login" + ".fxml"));
        //Parent root = fxmlLoader.load();
        scene = new Scene(loadFXML("Login"), 750, 480);
        stage.setScene(scene);
        stage.setMinWidth(375);
        stage.setMinHeight(450);
        stage.getIcons().add(new Image(new FileInputStream("arrow.png")));
        stage.setOnCloseRequest(e -> {
            close = true;
            Platform.exit();
        });
        
        stage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    /**
     * Cuando se requiera cambiar la scene del stage principal
     * 
     * @param root
     */
    public static void changeScene(Parent root){
        double ancho = stagePrincipal.getScene().getWidth();
        double alto = stagePrincipal.getScene().getHeight();
        
        stagePrincipal.setScene(new Scene(root, ancho,alto));
        
    }
    

    public static void main(String[] args) {
        launch();
        Principal.Principal();
    }
}