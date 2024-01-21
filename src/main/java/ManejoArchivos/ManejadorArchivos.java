/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejoArchivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class ManejadorArchivos {
    
    /**
     * Este metodo lee el archivo y devuelve las lineas del mismo en formato ArrayList
     * @param nombrearchivo nombre del archivo
     * @return ArrayList 
     */
    public static ArrayList<String> LeerArchivo(String nombrearchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(nombrearchivo);
            fr = new FileReader(archivo,StandardCharsets.UTF_8);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
//                System.out.println(linea);
                lineas.add(linea);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lineas;

    }

    /**
     * Este metodo escribe un archivo linea por linea
     * @param nombreArchivo el nombre del archivo a Escribir
     * @param linea La linea que se desea escribir
     */
    public static void EscribirArchivo(String nombreArchivo, String linea) {

        FileWriter fichero = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombreArchivo,true);
            bw = new BufferedWriter(fichero);
            bw.write(linea+"\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    //fichero.close();
                    bw.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    /**
     * Este metodo verifica si para leer el archivo se debe saltar la primera
     * linea o no
     *
     * @param nombreArchivo El nombre de archivo a escribir
     * @param saltar Si se desea omitir la primera linea
     * @return ArrayList de las palabras de a linea
     */
    public static ArrayList<String[]> LeerValidando(String nombreArchivo, boolean saltar) {
        ArrayList<String> lineas = ManejadorArchivos.LeerArchivo(nombreArchivo);
        ArrayList<String[]> datos = new ArrayList<>();
        int i;
        if (saltar) {
            for (i = 1; i < lineas.size(); i++) {
                datos.add(lineas.get(i).split(","));
            }
        } else {
            for (i = 0; i < lineas.size(); i++) {
                datos.add(lineas.get(i).split(","));
            }
        }

        return datos;
    }
    
}
