/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectosegundoparcial;

import Modelo.Principal;
import Modelo.Vuelo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author fabri
 */
public class SeleccionController implements Initializable {
    
    private static String salida;
    private static String llegada;
    private ArrayList<Vuelo> vuelos = new ArrayList<>();
    
    @FXML
    private ComboBox<String> comboBox;
    
    @FXML
    private VBox vboxp;
    
    // Setter para el atributo salida
    public void setSalida(String salida) {
        this.salida = salida;
    }

    // Getter para el atributo salida
    public String getSalida() {
        return salida;
    }

    // Setter para el atributo llegada
    public void setLlegada(String llegada) {
        this.llegada = llegada;
    }

    // Getter para el atributo llegada
    public String getLlegada() {
        return llegada;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox.getItems().removeAll(comboBox.getItems());
        comboBox.getItems().addAll("Precio", "Duración");
        comboBox.getSelectionModel().select("Precio");
        for (Vuelo v :Principal.Vuelos){
            if(v.getOrigen().equals(salida) && v.getDestino().equals(llegada)){
                vuelos.add(v);
            } 
        }
        PopularLista("precio");
        comboBox.setOnAction(event ->{
           String opcionSeleccionada = comboBox.getSelectionModel().getSelectedItem();
           PopularLista(opcionSeleccionada); 
        });
    }
    
    private void PopularLista(String orden){
        if (orden.equals("precio")){
            Collections.sort(vuelos);
        } else {
            Collections.sort(vuelos, Vuelo.criterio2Comparator);
        }
        if (vboxp.getChildren().size() > 2) {
            vboxp.getChildren().remove(2, vboxp.getChildren().size());
        }
        for (Vuelo v: vuelos){
            HBox Hbox = new HBox();
            HBox Hbox1 = new HBox();
            HBox Hbox2 = new HBox();
            VBox Vbox1 = new VBox();
            VBox Vbox2 = new VBox();
            VBox Vbox3 = new VBox();
            Label Salida = new Label(v.getHoraSalida());
            Label Llegada = new Label(v.getHoraLlegada());
            Label Duracion = new Label("Duración: "+ String.valueOf(v.getDuracion())+" horas");
            Label Precio = new Label(String.valueOf(v.getPrecio()));
            Hbox1.getChildren().add(Duracion);
            Hbox2.getChildren().add(Precio);
            Vbox1.getChildren().add(Salida);
            Vbox2.getChildren().add(Hbox1);
            Vbox2.getChildren().add(Hbox2);
            Vbox3.getChildren().add(Llegada);
            Hbox.getChildren().add(Vbox1);
            Hbox.getChildren().add(Vbox2);
            Hbox.getChildren().add(Vbox3);
            Hbox.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    handleHboxClick(event, v);
                }
            });
            vboxp.getChildren().add(Hbox);
        }
    }
    
    private void handleHboxClick(MouseEvent event, Vuelo v){
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/SelectTarifa" + ".fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
            App.changeScene(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //TarifaController.setVuelo1(v);
    }
}
