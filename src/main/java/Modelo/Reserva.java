package Modelo;

import static Enum.TipoTarifa.*;
import Enum.FormaPago;
import ManejoArchivos.ManejadorArchivos;
import java.io.Serializable;

public class Reserva implements Serializable{
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
    
    public String getCodigoReserva(){
        return codigoReserva;
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
    
    public Pago generarTransaccion(byte descuento, FormaPago formaPago){
        double precioIda = 0;
        double precioRegreso = 0;
        byte multIda = 0;
        byte multRegreso = 0;
        for(Vuelo v: Principal.Vuelos){
            if(v.getNumeroVuelo().equals(numeroVueloIda)){
                precioIda = v.getPrecio();
            }
            if(v.getNumeroVuelo().equals(numeroVueloRegreso)){
                precioRegreso = v.getPrecio();
            }
        }
        switch(tarifaIda.getTipo()){
            case S:
                multIda = 1;
                break;
            case M:
                multIda = 15;
                break;
            case L:
                multIda = 30;
                break;
        }
        switch(tarifaIda.getTipo()){
            case S:
                multIda = 1;
                break;
            case M:
                multIda = 15;
                break;
            case L:
                multIda = 30;
                break;
        }
        double total = (precioIda * multIda)+(precioRegreso * multRegreso);
        Pago pago = new Pago(codigoReserva, total, descuento, formaPago);
        return pago;
    }

    // FALTA LA FUNCION PAGAR RESERVA
    
    /**
    * Método para escribir archivos de reservas
    */
    public void RegistrarReserva(){
        String header = "CodigoReserva,cedulaCliente,ciudadOrigen,ciudadDestino,fechaSalida,fechaRegreso,numPasajeros,numVueloIda,nomVueloRegreso,tipoTaraifaIda,tipoTarifaRegreso";
        String linea = codigoReserva+","+cliente.getCedula()+","+ciudadOrigen+","+ciudadDestino+","+fechaSalida+","+fechaRegresa+","+String.valueOf(numeroPasajeros)+","+String.valueOf(numeroVueloIda)+","+String.valueOf(numeroVueloRegreso)+","+tarifaIda.getTipo()+","+tarifaRegreso.getTipo();
        ManejadorArchivos.EscribirArchivo("reservas.txt", header, linea);
    }
    
}
