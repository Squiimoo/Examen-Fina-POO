package vista;

import java.awt.*;
import javax.swing.*;

public class ClienteView extends JPanel {
    public JTextField campoCedula;
    public JTextField campoNombre;
    public JTextField campoApellido;
    public JTextField campoTelefono;
    public JTextField campoCorreo;
    public JButton botonGuardar;
    public JTable tablaClientes;

    public ClienteView() {
        setLayout(new BorderLayout());

        JPanel formulario = new JPanel(new GridLayout(6, 2, 10, 10));

        formulario.add(new JLabel("Cédula:"));
        campoCedula = new JTextField();
        formulario.add(campoCedula);

        formulario.add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        formulario.add(campoNombre);

        formulario.add(new JLabel("Apellido:"));
        campoApellido = new JTextField();
        formulario.add(campoApellido);

        formulario.add(new JLabel("Teléfono:"));
        campoTelefono = new JTextField();
        formulario.add(campoTelefono);

        formulario.add(new JLabel("Correo:"));
        campoCorreo = new JTextField();
        formulario.add(campoCorreo);

        botonGuardar = new JButton("Guardar Cliente");
        formulario.add(new JLabel()); // espacio vacío
        formulario.add(botonGuardar);

        add(formulario, BorderLayout.NORTH);

        tablaClientes = new JTable(); // luego le pondremos modelo
        add(new JScrollPane(tablaClientes), BorderLayout.CENTER);

        // Validaciones de campos
        ValidarCampo.soloNumeros(campoCedula);
        ValidarCampo.soloLetras(campoNombre);
        ValidarCampo.soloLetras(campoApellido);
        ValidarCampo.soloNumeros(campoTelefono);
    }
}
