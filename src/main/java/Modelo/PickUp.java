/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import ManejoArchivos.ManejadorArchivos;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class PickUp {
    private double coordenadaX;
    private double coordenadaY;
    private String pais;
    private String codigo;
    private String descuento;

    /**
     * Contructor de los pickups
     * @param coordenadaX
     * @param coordenadaY
     * @param pais
     * @param codigo
     * @param descuento
     */
    public PickUp(double coordenadaX, double coordenadaY, String codigo, String pais, String descuento) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.pais = pais;
        this.codigo = codigo;
        this.descuento = descuento;
    }
    
    
    /**
     * Obtiene todos los objetos de un archivo
     * @param ruta Ruta del archivo
     * @return Lista de objetos
     */
    public static ArrayList<PickUp> pickup(String ruta){
        ArrayList<PickUp> pickups = new ArrayList<>();
        ArrayList<String[]> datPickup = ManejadorArchivos.LeerValidando(ruta, false);
        for (String[] dataPick : datPickup) {
            pickups.add(new PickUp(Double.parseDouble(dataPick[0]), Double.parseDouble(dataPick[1]), dataPick[2],
                dataPick[3], dataPick[4]));
        }
        
        return pickups;
    }

    /**
     * Obtiene la coordenada X
     * @return 
     */
    public double getCoordenadaX() {
        return coordenadaX;
    }

    /**
     * Obtiene la coordenada Y
     * @return 
     */
    public double getCoordenadaY() {
        return coordenadaY;
    }

    /**
     * Obtiene el nombre del país
     * @return 
     */
    public String getPais() {
        return pais;
    }
    /**
     * Obtiene el código
     * @return 
     */

    public String getCodigo() {
        return codigo;
    }
    /**
     * Retorna el descuento
     * @return 
     */
    public String getDescuento(){
        return descuento;
    }
    
}
