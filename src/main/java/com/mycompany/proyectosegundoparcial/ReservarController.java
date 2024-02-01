/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectosegundoparcial;

import Modelo.Destino;
import Modelo.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

/**
 * FXML Controller class
 *
 * @author fabri
 */
public class ReservarController implements Initializable {
    
    @FXML
    private ComboBox<String> cborigen;
    
    @FXML
    private ComboBox<String> cbdestino;
    
    @FXML
    private DatePicker dpsalida;
    
    @FXML
    private DatePicker dpregreso;
    
    @FXML
    private Spinner<Integer> spinner;
    
    @FXML
    private Button boton;
    
    @FXML
    private Label lblmsj;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cborigen.getItems().removeAll(cborigen.getItems());
        cborigen.getItems().addAll("Cuenca, Guayaquil, Quito");
        ArrayList<Destino> destinos = new ArrayList<>();
        cbdestino.getItems().removeAll(cbdestino.getItems());
        for(Destino d: destinos){
            cbdestino.getItems().add(d.getCiudad());
        }
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1));
        boton.setOnAction(event-> {
            if (cborigen.getSelectionModel().getSelectedItem() != null &&
                cbdestino.getSelectionModel().getSelectedItem() != null &&
                dpsalida.getValue() != null &&
                dpregreso.getValue() != null &&
                spinner.getValue() != null
                ){
                Principal.setSalida(cborigen.getSelectionModel().getSelectedItem());
                Principal.setLlegada(cbdestino.getSelectionModel().getSelectedItem());
                Principal.setFechaSalida(dpsalida.getValue().toString());
                Principal.setFechaRegreso(dpregreso.getValue().toString());
                Principal.setViajeros(spinner.getValue());
                try{
                    App.changeScene(App.loadFXML("Seleccion"));
                }catch(IOException e){
                    e.printStackTrace();
                }
            } else {
                lblmsj.setText("Por favor ingrese todos los datos solicitados.");
            }
        });
    }    
    
}
