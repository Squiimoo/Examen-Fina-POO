package controlador;

import java.awt.event.ActionEvent;
import java.io.*;
import java.time.LocalDate;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Habitacion;
import modelo.Reserva;
import modelo.TipoHabitacion;
import vista.ReservaView;

public class ReservaController {
    private final ReservaView vista;
    private final String archivoReservas = "data/reservas.csv";

    public ReservaController(ReservaView vista) {
        this.vista = vista;

        vista.botonReservar.addActionListener((ActionEvent e) -> {
            String cedula = vista.campoCedulaCliente.getText();
            int numeroHabitacion = Integer.parseInt(vista.campoNumeroHabitacion.getText());
            LocalDate entrada = LocalDate.parse(vista.campoFechaEntrada.getText());
            LocalDate salida = LocalDate.parse(vista.campoFechaSalida.getText());
            
            // Datos simulados (en producción, buscar desde archivos)
            Cliente cliente = new Cliente(cedula, "Nombre", "Apellido", "0000000000", "mail@mail.com");
            Habitacion habitacion = new Habitacion(numeroHabitacion, TipoHabitacion.DOBLE, true, 50.0);
            
            Reserva r = new Reserva(cliente, habitacion, entrada, salida);
            guardarReserva(r);
            mostrarReservas();
        });

        mostrarReservas();
    }

    private void guardarReserva(Reserva r) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoReservas, true))) {
            pw.println(r.toCSV());
        } catch (IOException e) {
        }
    }

    private void mostrarReservas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Cédula", "Habitación", "Entrada", "Salida"});

        try (BufferedReader br = new BufferedReader(new FileReader(archivoReservas))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                modelo.addRow(datos);
            }
        } catch (IOException e) {
            // Ignorar
        }

        vista.tablaReservas.setModel(modelo);
    }
}
