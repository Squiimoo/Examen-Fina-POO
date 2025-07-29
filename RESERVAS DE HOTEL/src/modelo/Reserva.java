package modelo;

import java.time.LocalDate;

public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private boolean checkInRealizado;
    private boolean checkOutRealizado;

    public Reserva(Cliente cliente, Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.checkInRealizado = false;
        this.checkOutRealizado = false;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public boolean isCheckInRealizado() {
        return checkInRealizado;
    }

    public boolean isCheckOutRealizado() {
        return checkOutRealizado;
    }

    public void realizarCheckIn() {
        this.checkInRealizado = true;
        habitacion.setDisponible(false);
    }

    public void realizarCheckOut() {
        this.checkOutRealizado = true;
        habitacion.setDisponible(true);
    }

    public String toCSV() {
        return cliente.getCedula() + "," + habitacion.getNumero() + "," + fechaEntrada + "," + fechaSalida;
    }
}
