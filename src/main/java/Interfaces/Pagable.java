package Interfaces;

import Modelo.Pago;

public interface Pagable {
    abstract Pago generarTransaccion();
}
