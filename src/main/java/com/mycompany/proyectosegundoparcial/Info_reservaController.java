/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectosegundoparcial;

import Modelo.Principal;
import Modelo.Tarifa;
import Modelo.Vuelo;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fabri
 */
public class Info_reservaController implements Initializable {

    @FXML
    private Label fecha1;
    
    @FXML
    private Label fecha2;
    
    @FXML
    private Label tramo1;
    
    @FXML
    private Label tramo2;
    
    @FXML
    private Label precio1;
    
    @FXML
    private Label precio2;
    
    @FXML
    private Label duracion1;
    
    @FXML
    private Label duracion2;
    
    @FXML
    private Label horasalida1;
    
    @FXML
    private Label horallegada1;
    
    @FXML
    private Label horasalida2;
    
    @FXML
    private Label horallegada2;
    
    @FXML
    private Label total;
    
    @FXML
    private Button det1;
    
    @FXML
    private Button det2;
    
    @FXML
    private Button continuar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        DecimalFormat df = new DecimalFormat("#.##");
        fecha1.setText(Principal.getFechaSalida());
        fecha2.setText(Principal.getFechaRegreso());
        duracion1.setText(String.valueOf("Duración: " + Principal.getVuelo1().getDuracion() + " horas"));
        duracion2.setText(String.valueOf("Duración: " + Principal.getVuelo2().getDuracion() + " horas"));
        tramo1.setText(Principal.getLlegada() + " a " + Principal.getSalida());
        tramo2.setText(Principal.getSalida() + " a " + Principal.getLlegada());
        precio1.setText(df.format(Principal.getPrecio1()));
        precio2.setText(df.format(Principal.getPrecio2()));
        horasalida1.setText(Principal.getVuelo1().getHoraSalida());
        horasalida2.setText(Principal.getVuelo2().getHoraSalida());
        horallegada1.setText(Principal.getVuelo1().getHoraLlegada());
        horallegada2.setText(Principal.getVuelo2().getHoraLlegada());
        total.setText("Valor de reserva: " + df.format(Principal.getPrecio1()+Principal.getPrecio2()));
        det1.addEventHandler(ActionEvent.ACTION, (t) -> {
            detalleVuelo(Principal.getVuelo1(), Principal.getTarifa1());
        });
        det2.addEventHandler(ActionEvent.ACTION, (t) -> {
            detalleVuelo(Principal.getVuelo2(), Principal.getTarifa2());
        });
        continuar.addEventHandler(ActionEvent.ACTION, (t) -> {
            try{
                BienvenidaController.changeScene(App.loadFXML("Datos_Personales"));
            } catch (IOException e){
                e.printStackTrace();
            }
        });
    }    

    private void detalleVuelo(Vuelo v, Tarifa t) {
        Stage DetalleVuelo = new Stage();
        VBox vbox = new VBox();
        Label vuelo = new Label("Vuelo: " + v.getNumeroVuelo());
        Label avion = new Label(v.getCodigoAvion());
        Label tarifa = new Label("Tarifa " + t.getTipo().toString());
        Button cerrar = new Button("Cerrar");
        cerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Close the stage
                DetalleVuelo.close();
            }
        });
        vbox.getChildren().addAll(vuelo, avion, tarifa);
        BorderPane bp = new BorderPane();
        bp.setCenter(vbox);
        BorderPane.setAlignment(cerrar, javafx.geometry.Pos.BOTTOM_RIGHT);
        bp.setBottom(cerrar);
        Scene escena = new Scene(bp, 200, 200);
        DetalleVuelo.setScene(escena);
        DetalleVuelo.setResizable(false);
        DetalleVuelo.show();
    }
}
