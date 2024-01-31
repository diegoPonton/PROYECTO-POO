/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectosegundoparcial;

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
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class LoginController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ImageView imagenV = new ImageView();

        principalGrid.add(imagenV,0,1);
        try(FileInputStream input = new FileInputStream("src\\main\\resources\\imagenes\\plane.png")){
            System.out.println("Leyo la imagen");
            Image image = new Image(input,  300, 300, false, false);
            imagenV.setImage(image);
        }catch (IOException e){
            System.out.println("No se puede acceder a la imagen");
        }
        botonEntrar.setOnAction(event -> {
            boolean iniciado = Principal.Iniciar_Sesion(tf.getText(), tf2.getText());
            if (iniciado){
                try {
                    App.setRoot("Bienvenida");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                MensajeError.setText("Usuario o contraseña incorrecta");
            }
        });
    }
    
    @FXML
    private Label MensajeError;
    
    @FXML
    private TextField tf;
    
    @FXML
    private TextField tf2;
    
    @FXML
    private GridPane principalGrid;

    @FXML
    private Label welcomeText;

    @FXML
    private Label inicioSesionTitle;
    
    @FXML
    private Button botonEntrar;
}
