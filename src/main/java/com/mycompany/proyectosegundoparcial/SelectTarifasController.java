/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectosegundoparcial;

import Modelo.Principal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Double precio = Principal.getVuelo1().getPrecio();
        
    }    
    
}
