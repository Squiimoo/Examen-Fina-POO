package controlador;

import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import modelo.Habitacion;
import modelo.TipoHabitacion;
import vista.HabitacionView;

public final class HabitacionController {
    private final HabitacionView vista;
    private final String archivoHabitaciones = "data/habitaciones.csv";

    public HabitacionController(HabitacionView vista) {
        this.vista = vista;

        vista.botonGuardar.addActionListener((ActionEvent e) -> {
            int numero = Integer.parseInt(vista.campoNumero.getText());
            TipoHabitacion tipo = TipoHabitacion.valueOf((String) vista.comboTipo.getSelectedItem());
            double precio = Double.parseDouble(vista.campoPrecio.getText());
            
            Habitacion h = new Habitacion(numero, tipo, true, precio); // true = siempre disponible al crear
            guardarHabitacion(h);
            mostrarHabitaciones();
            limpiarFormulario();
        });

        mostrarHabitaciones();
        

    }

    private void guardarHabitacion(Habitacion h) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoHabitaciones, true))) {
            pw.println(h.toCSV());
        } catch (IOException e) {
        }
    }

    public void mostrarHabitaciones() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Número", "Tipo", "Disponible", "Precio"});

        try (BufferedReader br = new BufferedReader(new FileReader(archivoHabitaciones))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                modelo.addRow(datos);
            }
        } catch (IOException e) {
            // Ignorar si no existe
        }

        vista.tablaHabitaciones.setModel(modelo);
    }

    private void limpiarFormulario() {
        vista.campoNumero.setText("");
        vista.campoPrecio.setText("");
        vista.comboTipo.setSelectedIndex(0);
    }

}
