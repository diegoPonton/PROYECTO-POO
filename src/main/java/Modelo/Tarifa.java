package Modelo;

import Enum.TipoTarifa;

import java.util.ArrayList;

public class Tarifa {
    private String nombre;
    private TipoTarifa tipo;
    private ArrayList<String> listaCaracteristicas;
    private byte porcentaje;

    public Tarifa(String nombre, TipoTarifa tipo, ArrayList<String> listaCaracteristicas, byte porcentaje) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.listaCaracteristicas = listaCaracteristicas;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoTarifa getTipo() {
        return tipo;
    }

    public ArrayList<String> getListaCaracteristicas() {
        return listaCaracteristicas;
    }

    public byte getPorcentaje() {
        return porcentaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(TipoTarifa tipo) {
        this.tipo = tipo;
    }

    public void setListaCaracteristicas(ArrayList<String> listaCaracteristicas) {
        this.listaCaracteristicas = listaCaracteristicas;
    }

    public void setPorcentaje(byte porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "Tarifa{" +
                "nombre='" + nombre + '\'' +
                ", tipo=" + tipo +
                ", listaCaracteristicas=" + listaCaracteristicas +
                ", porcentaje=" + porcentaje +
                '}';
    }
}
