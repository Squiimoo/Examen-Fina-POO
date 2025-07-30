package modelo;

import modelo.interfaces.Pago;

public class ServicioAdicional implements Pago {
    private final String descripcion;
    private final double costo;

    public ServicioAdicional(String descripcion, double costo) {
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    @Override
    public double calcularTotal() {
        return costo;
    }

    public String toCSV() {
        return descripcion + "," + costo;
    }
}
