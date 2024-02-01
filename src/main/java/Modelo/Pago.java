package Modelo;

import Enum.FormaPago;
import ManejoArchivos.ManejadorArchivos;

public class Pago {
    private int idPago;
    private String codigoReserva;
    private double totalReserva;
    private int descuento;
    private FormaPago formaPago;
    private double totalPagar;
    private static int counter = 1;

    public Pago(String codigoReserva, double totalReserva, int descuento, FormaPago formaPago) {
        this.idPago = counter++;
        this.codigoReserva = codigoReserva;
        this.totalReserva = totalReserva;
        this.descuento = descuento;
        this.formaPago = formaPago;
        this.totalPagar = totalReserva * (1-(descuento/100));
    }

    public int getIdPago() {
        return idPago;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public double getTotalReserva() {
        return totalReserva;
    }

    public int getDescuento() {
        return descuento;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public void setTotalReserva(double totalReserva) {
        this.totalReserva = totalReserva;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
    
    /**
    * Método para escribir archivos de pagos
    */
    public void RegistrarPago(){
        String header = "idPago,codigoReserva,totalReserva,descuento,formaPago,totalPagar";
        String linea = String.valueOf(idPago)+","+codigoReserva+","+String.valueOf(totalReserva)+","+String.valueOf(descuento)+","+formaPago.toString()+","+String.valueOf(totalPagar);
        ManejadorArchivos.EscribirArchivo("pagos.txt", linea, header);
    }
}
