/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectosegundoparcial;

import Modelo.Reserva;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author fabri
 */
public class ConfirmaciónController implements Initializable {
    @FXML
    private Label contador;
    
    @FXML
    private Label codigo;
    
    @FXML
    private Button aceptar;
    
    public static Reserva reserva;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        codigo.setText(reserva.getCodigoReserva());
        aceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Close the stage
                BienvenidaController.stageReservas.close();
            }
        });
    }    
}