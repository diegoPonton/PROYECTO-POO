/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.proyectosegundoparcial;

/**
 *
 * @author Diego
 */

import Modelo.PickUp;
import Modelo.Reserva;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BienvenidaController implements Initializable{
    /**
     * Initializes the controller class.
     */
    public static Stage stageReservas;
    
    @FXML
    private Button btnPromociones;

    @FXML
    private Button btnReservar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Colocando eventos a los botones
        btnPromociones.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Stage stageMap = new Stage();
                    Parent rootPedidos = FXMLLoader.load(App.class.getResource("/fxml/map" + ".fxml"));
                    Scene scene = new Scene(rootPedidos,590,400);
                    stageMap.setScene(scene);
                    stageMap.setResizable(false);
                    
                    showPickup(rootPedidos, stageMap);
                    stageMap.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnReservar.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    App.reserva.setCliente(App.userLogin);
                    makeWindowPedidos();
                } catch (IOException ex) {
                    System.out.println("Ocurrio un error");
                }
            }
        });

    }
    
    /**
     * Muestra todos los pickups
     * @param root
     * @param stage 
     */
    private void showPickup(Parent root, Stage stage){
        Pane pa = (Pane) root;
        
        Thread hilo = new Thread(()->{
            for (PickUp pickup : App.pickups) {
                if(App.close){
                    break;
                }
                ImageView imv = new ImageView();
                String path ="arrow.png";
                try {
                    Image image = new Image(new FileInputStream(path),40,40,true, true);
                    imv.setImage(image);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                Random num = new Random();
                int timepo = num.nextInt(21);
                
                //Colocando el grafico
                Platform.runLater(()->{
                    imv.setLayoutX(pickup.getCoordenadaX());
                    imv.setLayoutY(pickup.getCoordenadaY());
                    pa.getChildren().add(imv);
                });
                
                //Colocamos un evento al pickup
                imv.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
                    showPopUp(pickup, pa);
                });
                
                try {
                    Thread.sleep(timepo * 1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        hilo.start();
        
        
    }

    /**
     *  Se encarara de crear la ventana donde se podra realizar el pedido
     * @throws IOException 
     */
    private void makeWindowPedidos() throws IOException {
        stageReservas = new Stage();
        Parent rootPedidos = FXMLLoader.load(App.class.getResource("/fxml/baseHelado" + ".fxml"));
        
        Scene scene = new Scene(rootPedidos);
        stageReservas.setScene(scene);
        stageReservas.initModality(Modality.APPLICATION_MODAL);
        stageReservas.setOnCloseRequest((e)->{
            //En caso de que se cierre la ventana se reetablecera los valores
            App.reserva = new Reserva();
            App.reserva.setCliente(App.userLogin);
        });
        stageReservas.show();
        
    }

    /**
     * Muestra los popUps
     * @param pickup
     * @param root 
     */
    private void showPopUp(PickUp pickup, Pane root){
        VBox cont = new VBox();
        String contSytle = "-fx-background-color: rgb(247,224,156);"
                + "-fx-border-radius:20;"
                + "-fx-background-radius:20";
        cont.setStyle(contSytle);
        
        cont.setMinHeight(150);
        cont.setMaxHeight(150);
        cont.setSpacing(10);
        cont.setPadding(new Insets(20,10,10,10));
        Label lbNombre = new Label("Heladeria ... ");
        lbNombre.setStyle("-fx-font-weight: bold;-fx-font-size: 15; ");
        Label lbUbi = new Label(pickup.getNombre());
        Label lbHorario = new Label("Horario: " + pickup.getHorario());
        
        HBox contHijo = new HBox();
        contHijo.setSpacing(30);
        contHijo.setPadding(new Insets(10, 10, 10, 10));
        Label lbcontador = new Label("Se cerrara en 5 segundos");
        Button btnCerrar = new Button("Cerrar");
        btnCerrar.setOnAction(e -> {
            root.getChildren().remove(cont);
        });
        
        cont.getChildren().addAll(lbNombre, lbUbi, lbHorario);
        contHijo.getChildren().addAll(lbcontador, btnCerrar);
        cont.getChildren().add(contHijo);
        
        Thread hiloTim = new Thread(()->{
            for (int i = 5; i > 0; i--) {
                int contnum = i;
                Platform.runLater(()->{
                    lbcontador.setText("Se cerrara en " + contnum  +" segundos");
                });
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            Platform.runLater(()->{
                root.getChildren().remove(cont);
            });
 
        });
        
        hiloTim.start();
        
        Platform.runLater(()->{
            if(pickup.getCoordenadaX() < 560/2 && pickup.getCoordenadaY() < 200){
                cont.setLayoutX(pickup.getCoordenadaX());
                cont.setLayoutY(pickup.getCoordenadaY()+50);
            }else if(pickup.getCoordenadaX() > 560/2 && pickup.getCoordenadaY() < 200){
                cont.setLayoutX(pickup.getCoordenadaX() - 200);
                cont.setLayoutY(pickup.getCoordenadaY());
            }else if(pickup.getCoordenadaX() > 560/2 && pickup.getCoordenadaY() > 200){
                cont.setLayoutX(pickup.getCoordenadaX() - 200);
                cont.setLayoutY(pickup.getCoordenadaY() - 160);
            }else{
                cont.setLayoutX(pickup.getCoordenadaX());
                cont.setLayoutY(pickup.getCoordenadaY() - 160);
            }
            
            root.getChildren().add(cont);
        });
        
    }
    

}
