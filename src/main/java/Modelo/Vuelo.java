package Modelo;

public class Vuelo {
    private String origen;
    private String destingo;
    private double duracion;
    private String horaSalida;
    private String horaLlegada;
    private String numeroVuelo;
    private String codigoAvion;
    private double precio;

    public Vuelo(String origen, String destingo, double duracion,
                 String horaSalida, String horaLlegada, String numeroVuelo,
                 String codigoAvion, double precio) {
        this.origen = origen;
        this.destingo = destingo;
        this.duracion = duracion;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.numeroVuelo = numeroVuelo;
        this.codigoAvion = codigoAvion;
        this.precio = precio;
    }

    // GETTERS
    public String getOrigen() {
        return origen;
    }

    public String getDestingo() {
        return destingo;
    }

    public double getDuracion() {
        return duracion;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public String getCodigoAvion() {
        return codigoAvion;
    }

    public double getPrecio() {
        return precio;
    }

    // SETTERS

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setDestingo(String destingo) {
        this.destingo = destingo;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public void setCodigoAvion(String codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "origen='" + origen + '\'' +
                ", destingo='" + destingo + '\'' +
                ", duracion=" + duracion +
                ", horaSalida='" + horaSalida + '\'' +
                ", horaLlegada='" + horaLlegada + '\'' +
                ", numeroVuelo='" + numeroVuelo + '\'' +
                ", codigoAvion='" + codigoAvion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
