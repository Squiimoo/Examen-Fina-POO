package controlador;

import java.awt.event.ActionEvent;
import java.io.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Habitacion;
import modelo.Reserva;
import modelo.TipoHabitacion;
import vista.ReservaView;

public class ReservaController {
    private final ReservaView vista;
    private final String archivoReservas = "data/reservas.csv";
    private final HabitacionController habitacionController;

    public ReservaController(ReservaView vista, HabitacionController habitacionController) {
        this.vista = vista;
        this.habitacionController = habitacionController;

        vista.botonReservar.addActionListener((var e) -> {
            String cedula = vista.campoCedulaCliente.getText().trim();
            String numeroHabTexto = vista.campoNumeroHabitacion.getText().trim();
            String fechaEntradaTexto = vista.campoFechaEntrada.getText().trim();
            String fechaSalidaTexto = vista.campoFechaSalida.getText().trim();
            
            // 🔒 Validación de campos vacíos
            if (cedula.isEmpty() || numeroHabTexto.isEmpty() || fechaEntradaTexto.isEmpty() || fechaSalidaTexto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
                return;
            }
            
            // 🔁 Resto del código (ya lo tenías)
            int numeroHabitacion = Integer.parseInt(numeroHabTexto);
            LocalDate entrada = LocalDate.parse(fechaEntradaTexto);
            LocalDate salida = LocalDate.parse(fechaSalidaTexto);
            
            if (reservaSuperpuesta(numeroHabitacion, entrada, salida)) {
                JOptionPane.showMessageDialog(null, "¡Esa habitación ya tiene una reserva en esas fechas!");
                return;
            }
            
            Cliente cliente = new Cliente(cedula, "Nombre", "Apellido", "0000000000", "mail@mail.com");
            Habitacion habitacion = new Habitacion(numeroHabitacion, TipoHabitacion.DOBLE, true, 50.0);
            Reserva r = new Reserva(cliente, habitacion, entrada, salida);
            
            guardarReserva(r);
            mostrarReservas();
            limpiarFormulario();
        });



        vista.botonCheckIn.addActionListener((ActionEvent e) -> {
            int fila = vista.tablaReservas.getSelectedRow();
            if (fila != -1) {
                @SuppressWarnings("unused")
                String cedula = vista.tablaReservas.getValueAt(fila, 0).toString();
                int numHab = Integer.parseInt(vista.tablaReservas.getValueAt(fila, 1).toString());
                realizarCheckIn(numHab);
                habitacionController.mostrarHabitaciones();

                JOptionPane.showMessageDialog(null, "Check-In realizado");
            }
        });

        vista.botonCheckOut.addActionListener((ActionEvent e) -> {
            int fila = vista.tablaReservas.getSelectedRow();
            if (fila != -1) {
                int numHab = Integer.parseInt(vista.tablaReservas.getValueAt(fila, 1).toString());
                realizarCheckOut(numHab);
                habitacionController.mostrarHabitaciones();

                JOptionPane.showMessageDialog(null, "Check-Out realizado");
            }
        });

        vista.botonBuscar.addActionListener((ActionEvent e) -> {
            String apellido = vista.campoBuscarApellido.getText().trim().toLowerCase();
            String fecha = vista.campoBuscarFecha.getText().trim();
            buscarReservas(apellido, fecha);
            limpiarFormulario();
        });

        vista.botonCancelar.addActionListener((ActionEvent e) -> {
            int fila = vista.tablaReservas.getSelectedRow();
            if (fila != -1) {
                String cedula = vista.tablaReservas.getValueAt(fila, 0).toString();
                int numeroHab = Integer.parseInt(vista.tablaReservas.getValueAt(fila, 1).toString());
                String fechaEntrada = vista.tablaReservas.getValueAt(fila, 2).toString();
                String fechaSalida = vista.tablaReservas.getValueAt(fila, 3).toString();
                
                cancelarReserva(cedula, numeroHab, fechaEntrada, fechaSalida);
                JOptionPane.showMessageDialog(null, "Reserva cancelada exitosamente");
                mostrarReservas();
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona una reserva para cancelar");
            }

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

    private void realizarCheckIn(int numeroHabitacion) {
        actualizarEstadoHabitacion(numeroHabitacion, false); // ocupada
        habitacionController.mostrarHabitaciones(); // actualiza tabla
    }

    private void realizarCheckOut(int numeroHabitacion) {
        actualizarEstadoHabitacion(numeroHabitacion, true); // disponible
        habitacionController.mostrarHabitaciones(); // actualiza tabla
    }


    @SuppressWarnings("CallToPrintStackTrace")
    private void actualizarEstadoHabitacion(int numeroHabitacion, boolean disponible) {
        File archivo = new File("data/habitaciones.csv");
        File temp = new File("data/temp.csv");

        try (
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            PrintWriter pw = new PrintWriter(new FileWriter(temp))
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int num = Integer.parseInt(partes[0]);
                if (num == numeroHabitacion) {
                    partes[2] = String.valueOf(disponible); // modificar disponibilidad
                    linea = String.join(",", partes);
                }
                pw.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        archivo.delete();
        temp.renameTo(archivo);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    private void buscarReservas(String apellidoFiltro, String fechaFiltro) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Cédula", "Habitación", "Entrada", "Salida"});

        try (BufferedReader br = new BufferedReader(new FileReader(archivoReservas))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String cedula = datos[0];
                String fechaEntrada = datos[2];
                String fechaSalida = datos[3];

                // Simular apellido buscándolo en clientes.csv
                String apellidoCliente = obtenerApellidoCliente(cedula).toLowerCase();

                boolean coincideApellido = apellidoFiltro.isEmpty() || apellidoCliente.contains(apellidoFiltro);
                boolean coincideFecha = fechaFiltro.isEmpty() || fechaEntrada.equals(fechaFiltro) || fechaSalida.equals(fechaFiltro);

                if (coincideApellido && coincideFecha) {
                    modelo.addRow(datos);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        vista.tablaReservas.setModel(modelo);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    private String obtenerApellidoCliente(String cedulaBuscada) {
        try (BufferedReader br = new BufferedReader(new FileReader("data/clientes.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos[0].equals(cedulaBuscada)) {
                    return datos[2]; // apellido
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @SuppressWarnings("CallToPrintStackTrace")
    private void cancelarReserva(String cedula, int numeroHab, String fechaEntrada, String fechaSalida) {
        File archivo = new File(archivoReservas);
        File temp = new File("data/tempReservas.csv");

        try (
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            PrintWriter pw = new PrintWriter(new FileWriter(temp))
        ) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                boolean mismaReserva =
                    datos[0].equals(cedula) &&
                    Integer.parseInt(datos[1]) == numeroHab &&
                    datos[2].equals(fechaEntrada) &&
                    datos[3].equals(fechaSalida);

                if (!mismaReserva) {
                    pw.println(linea); // escribir solo si no es la que se cancela
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        archivo.delete();
        temp.renameTo(archivo);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    private boolean reservaSuperpuesta(int numeroHab, LocalDate nuevaEntrada, LocalDate nuevaSalida) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoReservas))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int hab = Integer.parseInt(datos[1]);
                LocalDate entradaExistente = LocalDate.parse(datos[2]);
                LocalDate salidaExistente = LocalDate.parse(datos[3]);

                if (hab == numeroHab) {
                    // Si se solapan las fechas
                    boolean seCruzan = !(nuevaSalida.isBefore(entradaExistente) || nuevaEntrada.isAfter(salidaExistente));
                    if (seCruzan) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void limpiarFormulario() {
        vista.campoCedulaCliente.setText("");
        vista.campoNumeroHabitacion.setText("");
        vista.campoFechaEntrada.setText("");
        vista.campoFechaSalida.setText("");
        vista.campoBuscarApellido.setText("");
        vista.campoBuscarFecha.setText("");
    }

}



