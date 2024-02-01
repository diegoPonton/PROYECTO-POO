package Modelo;

public class Promocion {
    private double coordenadaX;
    private double coordenadaY;
    private String pais;
    private String codigo;
    private byte descuento;

    public Promocion(double coordenadaX, double coordenadaY, String pais, String codigo, byte descuento) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.pais = pais;
        this.codigo = codigo;
        this.descuento = descuento;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public String getPais() {
        return pais;
    }

    public String getCodigo() {
        return codigo;
    }

    public byte getDescuento() {
        return descuento;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescuento(byte descuento) {
        this.descuento = descuento;
    }
}
