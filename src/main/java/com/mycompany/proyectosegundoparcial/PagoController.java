/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectosegundoparcial;

import Enum.FormaPago;
import ManejoArchivos.ManejadorArchivos;
import Modelo.Pago;
import Modelo.Principal;
import Modelo.Promocion;
import Modelo.Reserva;
import static com.mycompany.proyectosegundoparcial.BienvenidaController.stageReservas;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author fabri
 */
public class PagoController implements Initializable {
    
    private int desc;
    private FormaPago FP;
    
    public void setDescuento(int d){
        this.desc = d;
    }
    
    public int getDescuento(){
        return desc;
    }
    
    @FXML
    private RadioButton efectivo;
    
    @FXML
    private RadioButton tc;
    
    @FXML
    private TextField prom;
    
    @FXML
    private Label rc;
    
    @FXML
    private Label descuento;
    
    @FXML
    private Label total;
    
    @FXML
    private Button pagar;
    
    @FXML
    private Button cancelar;
    
    @FXML
    private ToggleGroup pago;
    
    @FXML
    private Pane pane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        double suma = Principal.getPrecio1() + Principal.getPrecio2();
        rc.setText(String.valueOf(suma));
        descuento.setText(String.valueOf(desc));
        total.setText(String.valueOf(suma*(1-(desc*0.01))));
        pago.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
            if (newToggle != null) {
                // Code to execute when a RadioButton is selected
                if (((RadioButton) newToggle).getText().equals("Efectivo")){
                    pane.getChildren().removeAll(pane.getChildren());
                    Label lbl_efectivo = new Label("Estimado cliente, tienes 24 horas para acercarte a realizar el pago. De lo contrario la reserva se anulará.");
                    pane.getChildren().add(lbl_efectivo);
                    FP = FormaPago.E;
                } else {
                    pane.getChildren().removeAll(pane.getChildren());
                    Label notar = new Label("Número de tarjeta:");
                    notar.setLayoutX(10);
                    notar.setLayoutY(10);
                    Label fecha = new Label("Fecha de Expiración:");
                    fecha.setLayoutX(10);
                    fecha.setLayoutY(10);
                    Label cvv = new Label("CVV:");
                    cvv.setLayoutX(10);
                    cvv.setLayoutY(10);
                    TextField tfnt = new TextField();
                    tfnt.setLayoutX(120);
                    tfnt.setLayoutY(10);
                    DatePicker dp = new DatePicker();
                    dp.setLayoutX(120);
                    dp.setLayoutY(10);
                    TextField tfcvv = new TextField();
                    tfcvv.setLayoutX(120);
                    tfcvv.setLayoutY(10);
                    VBox vbox1 = new VBox(notar, tfnt);
                    VBox vbox2 = new VBox(fecha, dp);
                    VBox vbox3 = new VBox(cvv, tfcvv);
                    pane.getChildren().addAll(vbox1,vbox2, vbox3);
                    FP = FormaPago.TC;
                }
            }
        });
        prom.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                for (Promocion p : Principal.Promociones){
                    if (newValue.equals(p.getCodigo()) && p.getPais().equals(Principal.getPais())){
                        desc = p.getDescuento();
                    }
                }                
            }
        });
        
        cancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CancelarCompra();
            }
        });
        
        pagar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Reserva reserva = new Reserva(Principal.cliente, Principal.getLlegada(), Principal.getSalida(), Principal.getFechaSalida(), Principal.getFechaRegreso(), Principal.getViajeros(), Principal.getVuelo1().getNumeroVuelo(), Principal.getVuelo2().getNumeroVuelo(), Principal.getTarifa1(), Principal.getTarifa2());
                ConfirmaciónController.reserva = reserva;
                reserva.RegistrarReserva();
                Pago pago = reserva.generarTransaccion(desc, FP);
                pago.RegistrarPago();
                Principal.szrReserva(reserva);
                try{
                    PagoController.changeScene(App.loadFXML("ConfirmaciónController"));
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
    }
    private void CancelarCompra() {
        Stage CC = new Stage();
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        Label titulo = new Label("Cancelar compra");
        Label mensaje = new Label("¿Está seguro de cancelar el proceso de compra?");
        Button si = new Button("Si");
        si.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Close the stage
                CC.close();
                BienvenidaController.stageReservas.close();
            }
        });
        Button no = new Button("No");
        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Close the stage
                CC.close();
            }
        });
        hbox.getChildren().addAll(si, no);
        vbox.getChildren().addAll(titulo, mensaje, hbox);
        Scene escena = new Scene(vbox, 200, 200);
        CC.setScene(escena);
        CC.setResizable(false);
        CC.show();
    }
    
    public static void changeScene(Parent root){
        stageReservas.sizeToScene();
        stageReservas.setScene(new Scene(root, 550,800));
    }
    
}
