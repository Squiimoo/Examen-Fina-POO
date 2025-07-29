package modelo;

public class Habitacion {
    private final int numero;
    private final TipoHabitacion tipo;
    private boolean disponible;
    private final double precio;

    public Habitacion(int numero, TipoHabitacion tipo, boolean disponible, double precio) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponible = disponible;
        this.precio = precio;
    }

    public int getNumero() {
        return numero;
    }

    public TipoHabitacion getTipo() {
        return tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public double getPrecio() {
        return precio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String toCSV() {
        return numero + "," + tipo + "," + disponible + "," + precio;
    }
}
