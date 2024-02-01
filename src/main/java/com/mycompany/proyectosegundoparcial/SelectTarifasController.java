/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectosegundoparcial;

import Modelo.Principal;
import Modelo.Tarifa;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author fabri
 */
public class SelectTarifasController implements Initializable {
    
    @FXML
    private VBox Vbox;
    
    @FXML
    private VBox Vbox1;
    
    @FXML
    private VBox Vbox2;
    
    @FXML
    private VBox Vbox3;
    
    @FXML
    private Label precio1;
    
    @FXML
    private Label precio2;
    
    @FXML
    private Label precio3;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Double precio;
        if(Principal.getRepetir()){
            precio = Principal.getVuelo1().getPrecio();
        } else{
            precio = Principal.getVuelo2().getPrecio();
        }
//        Vbox.getChildren().removeAll(Vbox.getChildren());
//        Vbox1.getChildren().removeAll(Vbox1.getChildren());
//        Vbox2.getChildren().removeAll(Vbox2.getChildren());
//        Vbox3.getChildren().removeAll(Vbox3.getChildren());
        ArrayList<Tarifa> tarifas = Principal.Tarifas;
        double v1 = precio + (precio * (tarifas.get(0).getPorcentaje()*0.01));
        double v2 = precio + (precio * (tarifas.get(1).getPorcentaje()*0.01));
        double v3 = precio + (precio * (tarifas.get(2).getPorcentaje()*0.01));
        precio1.setText(String.valueOf(v1));
        precio2.setText(String.valueOf(v2));
        precio3.setText(String.valueOf(v3));
        Vbox1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                handleVboxClick(event, tarifas.get(0), v1);
            }
        });
        Vbox2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                handleVboxClick(event, tarifas.get(1), v2);
            }
        });
        Vbox3.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                handleVboxClick(event, tarifas.get(2), v3);
            }
        });
    }
    
    public void Accionar(){
        
    }
    
    private void handleVboxClick(MouseEvent event, Tarifa t, double p){
        try {
            if(Principal.getRepetir()){
                String exsalida = Principal.getSalida();
                String exllegada = Principal.getLlegada();
                Principal.setSalida(exllegada);
                Principal.setLlegada(exsalida);
                Principal.setPrecio1(p);
                BienvenidaController.changeScene(App.loadFXML("Seleccion"));
                Principal.setRepetir(false);
                Principal.setTarifa1(t);
                
            } else{
                Principal.setPrecio2(p);
                BienvenidaController.changeScene(App.loadFXML("info_reserva"));
                Principal.setRepetir(true);
                Principal.setTarifa2(t);                
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
}
