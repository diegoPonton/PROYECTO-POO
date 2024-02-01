/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectosegundoparcial;

import ManejoArchivos.ManejadorArchivos;
import Modelo.Cliente;
import Modelo.Principal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author danie
 */
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    
    
   @FXML
    private Button btnLogin;
    
    @FXML
    private TextField txCliente;
    
    @FXML
    private TextField txPassw;
    
    @FXML
    private Label lbMessage;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Se capturara el evento del boton
        btnLogin.addEventHandler(ActionEvent.ACTION, (t) -> {
            
            String correo = txCliente.getText();
            String password = txPassw.getText();
            login(correo, password);
            //App.changeScene(new Scene(new VBox(new Label("Hola"))));
        });
        
        
    } 
    
    /**
     * Encargado de poder iniciar sesion
     * @param usuario Correo del Usuario
     * @param password Constraseña del usuario
     */
    private void login(String usuario, String contrasena){
        Cliente user = new Cliente(usuario, contrasena);
        int indice = App.clientes.indexOf(user); 
//        if(App.clientes.get(indice).getContrasena().equals(contrasena)){
//            lbMessage.setText("holi");
//        }
        if(indice == -1){
            ManejadorArchivos.animateStyle(txCliente, "txt-error", 2000);
            lbMessage.setText("No se pudo encontrar el usuario");
            return;
        }
        if(!App.clientes.get(indice).getContrasena().equals(contrasena)){
            ManejadorArchivos.animateStyle(txPassw, "txt-error", 2000);
            ManejadorArchivos.animateStyle(txCliente, "txt-error", 2000);
            lbMessage.setText("No se pudo validar sus credenciales");
            return;
        }
        //Esta seccion entrara solo el usuario loguiado
        //Se puede simular la ventana de carga para mas realismo 
        //ya que el efecto sera inmediato
        lbMessage.setText("");
        
        //Agregando el usuasrio al pedido
        App.reserva.setCliente(App.clientes.get(indice));
        App.userLogin = App.clientes.get(indice);
        //Mostrando la ventana
        try{
            App.changeScene(App.loadFXML("Bienvenida"));
        }catch(IOException e){
            e.printStackTrace();
        }
        makeNewWindow();
        
    }
    
    /**
     * Muesta la ventana de las reservas
     */
    private void makeNewWindow(){
        Stage stageReservas = new Stage();
        stageReservas.setAlwaysOnTop(true);
        
        ListView<String> LvPedidos = new ListView<>();
        Scene scena = new Scene(LvPedidos,350,250);
        Thread hiloReserva = new Thread(()->{
            while(true){
                if(App.close){
                    break;
                }
                try {
                    Platform.runLater(()->{
                        LvPedidos.getItems().clear();
                    });
                    ArrayList<String> lineas = ManejadorArchivos.LeerArchivo("reservas.txt");
                    
                    for (String linea : lineas) {
                        String[] data = linea.split(",");
                        Platform.runLater(()->{
                            LvPedidos.getItems().add(data[1] + ", " + data[2]);
                        });
                        
                    }
                    
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
                
            }
        });
        
        hiloReserva.start();
        stageReservas.setScene(scena);
        stageReservas.setResizable(false);
        stageReservas.show();
    }
}
