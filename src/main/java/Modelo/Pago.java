package Modelo;

import Enum.FormaPago;

public class Pago {
    private int idPago;
    private String codigoReserva;
    private double totalReserva;
    private byte descuento;
    private FormaPago formaPago;
    private double totalPagar;

    public Pago(int idPago, String codigoReserva, double totalReserva, byte descuento, FormaPago formaPago, double totalPagar) {
        this.idPago = idPago;
        this.codigoReserva = codigoReserva;
        this.totalReserva = totalReserva;
        this.descuento = descuento;
        this.formaPago = formaPago;
        this.totalPagar = totalPagar;
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

    public byte getDescuento() {
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

    public void setDescuento(byte descuento) {
        this.descuento = descuento;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
}
