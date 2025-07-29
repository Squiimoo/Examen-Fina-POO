package controlador;

import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import vista.ClienteView;

public class ClienteController {
    private final ClienteView vista;
    private final String archivoClientes = "data/clientes.csv";

    public ClienteController(ClienteView vista) {
        this.vista = vista;

        vista.botonGuardar.addActionListener((ActionEvent e) -> {
            Cliente c = new Cliente(
                    vista.campoCedula.getText(),
                    vista.campoNombre.getText(),
                    vista.campoApellido.getText(),
                    vista.campoTelefono.getText(),
                    vista.campoCorreo.getText()
            );
            guardarCliente(c);
            mostrarClientes();
        });

        mostrarClientes();
    }

    private void guardarCliente(Cliente c) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoClientes, true))) {
            pw.println(c.toCSV());
        } catch (IOException e) {
        }
    }

    private void mostrarClientes() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new String[]{"Cédula", "Nombre", "Apellido", "Teléfono", "Correo"});

        try (BufferedReader br = new BufferedReader(new FileReader(archivoClientes))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                modelo.addRow(datos);
            }
        } catch (IOException e) {
            // Si el archivo no existe, no pasa nada
        }

        vista.tablaClientes.setModel(modelo);
    }
}
