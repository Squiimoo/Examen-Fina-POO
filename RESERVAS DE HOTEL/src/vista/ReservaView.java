package vista;

import java.awt.*;
import javax.swing.*;

public class ReservaView extends JPanel {
    public JTextField campoCedulaCliente;
    public JTextField campoNumeroHabitacion;
    public JTextField campoFechaEntrada;
    public JTextField campoFechaSalida;
    public JButton botonReservar;
    public JTable tablaReservas;

    public ReservaView() {
        setLayout(new BorderLayout());

        JPanel formulario = new JPanel(new GridLayout(5, 2, 10, 10));

        formulario.add(new JLabel("Cédula del Cliente:"));
        campoCedulaCliente = new JTextField();
        formulario.add(campoCedulaCliente);

        formulario.add(new JLabel("Número de Habitación:"));
        campoNumeroHabitacion = new JTextField();
        formulario.add(campoNumeroHabitacion);

        formulario.add(new JLabel("Fecha Entrada (AAAA-MM-DD):"));
        campoFechaEntrada = new JTextField();
        formulario.add(campoFechaEntrada);

        formulario.add(new JLabel("Fecha Salida (AAAA-MM-DD):"));
        campoFechaSalida = new JTextField();
        formulario.add(campoFechaSalida);

        botonReservar = new JButton("Reservar");
        formulario.add(new JLabel()); // espacio vacío
        formulario.add(botonReservar);

        add(formulario, BorderLayout.NORTH);

        tablaReservas = new JTable();
        add(new JScrollPane(tablaReservas), BorderLayout.CENTER);

        // Validaciones de campos
        ValidarCampo.soloNumeros(campoCedulaCliente);
        ValidarCampo.soloNumeros(campoNumeroHabitacion);
    }
}
