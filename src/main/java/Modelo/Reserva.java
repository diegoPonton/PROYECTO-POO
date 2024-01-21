package Modelo;

public class Reserva {
    private Cliente cliente;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String fechaSalida;
    private String fechaRegresa;
    private int numeroPasajeros;
    private int numeroVueloIda;
    private int numeroVueloRegreso;
    private Tarifa tarifaIda;
    private Tarifa tarifaRegreso;
    private String codigoReserva;

    public Reserva(Cliente cliente, String ciudadOrigen, String ciudadDestino, String fechaSalida, String fechaRegresa, int numeroPasajeros, int numeroVueloIda, int numeroVueloRegreso, Tarifa tarifaIda, Tarifa tarifaRegreso, String codigoReserva) {
        this.cliente = cliente;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fechaSalida = fechaSalida;
        this.fechaRegresa = fechaRegresa;
        this.numeroPasajeros = numeroPasajeros;
        this.numeroVueloIda = numeroVueloIda;
        this.numeroVueloRegreso = numeroVueloRegreso;
        this.tarifaIda = tarifaIda;
        this.tarifaRegreso = tarifaRegreso;
        this.codigoReserva = codigoReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "cliente=" + cliente +
                ", ciudadOrigen='" + ciudadOrigen + '\'' +
                ", ciudadDestino='" + ciudadDestino + '\'' +
                ", fechaSalida='" + fechaSalida + '\'' +
                ", fechaRegresa='" + fechaRegresa + '\'' +
                ", numeroPasajeros=" + numeroPasajeros +
                ", numeroVueloIda=" + numeroVueloIda +
                ", numeroVueloRegreso=" + numeroVueloRegreso +
                ", tarifaIda=" + tarifaIda +
                ", tarifaRegreso=" + tarifaRegreso +
                ", codigoReserva='" + codigoReserva + '\'' +
                '}';
    }


    // FALTA LA FUNCION PAGAR RESERVA
}
