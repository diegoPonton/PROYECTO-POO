/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectosegundoparcial;

import Modelo.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author fabri
 */
public class Datos_PersonalesController implements Initializable {
    
    
    @FXML
    private VBox Vboxpadre;
    
    @FXML
    private Pane titulo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Pane nt = titulo;
        Vboxpadre.getChildren().removeAll(Vboxpadre.getChildren());
        Vboxpadre.getChildren().add(nt);
        for(int i=0;i<Principal.getViajeros();i++){
            Label nombre = new Label("Nombre:");
            nombre.setLayoutX(10);
            nombre.setLayoutY(10);
            Label apellido = new Label("Apellido:");
            apellido.setLayoutX(10);
            apellido.setLayoutY(10);
            Label pasaporte = new Label("Pasaporte:");
            pasaporte.setLayoutX(10);
            pasaporte.setLayoutY(10);
            Label correo = new Label("Correo:");
            correo.setLayoutX(10);
            correo.setLayoutY(10);
            TextField tfn = new TextField();
            tfn.setLayoutX(70);
            tfn.setLayoutY(10);
            TextField tfa = new TextField();
            tfa.setLayoutX(70);
            tfa.setLayoutY(10);
            TextField tfp = new TextField();
            tfp.setLayoutX(70);
            tfp.setLayoutY(10);
            TextField tfc = new TextField();
            tfc.setLayoutX(70);
            tfc.setLayoutY(10);
            Pane izq1 = new Pane();
            izq1.getChildren().addAll(nombre,tfn);
            Pane izq2 = new Pane();
            izq2.getChildren().addAll(apellido, tfa);
            Pane der1 = new Pane(pasaporte, tfp);
            Pane der2 = new Pane(correo, tfc);
            VBox izq = new VBox(izq1, izq2);
            VBox der = new VBox(der1, der2);
            Label pasajero = new Label("Pasajero " + String.valueOf(i+1) + ":");
            HBox hbox = new HBox(izq, der);
            VBox caja = new VBox(pasajero, hbox);
            Vboxpadre.getChildren().add(caja);
        }
        
        Button continuar = new Button("Continuar");
        continuar.addEventHandler(ActionEvent.ACTION, (t) -> {
            try{
                BienvenidaController.changeScene(App.loadFXML("Pago"));
            } catch (IOException e){
                e.printStackTrace();
            }
        });
        continuar.setLayoutX(350);
        continuar.setLayoutY(30);
        Pane np = new Pane(continuar);
        Vboxpadre.getChildren().add(np);
    }
}
