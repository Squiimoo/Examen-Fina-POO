package vista;

import java.awt.*;
import javax.swing.*;

public class HabitacionView extends JPanel {
    public JTextField campoNumero;
    public JComboBox<String> comboTipo;
    public JTextField campoPrecio;
    public JCheckBox checkDisponible;
    public JButton botonGuardar;
    public JTable tablaHabitaciones;

    public HabitacionView() {
        setLayout(new BorderLayout());

        JPanel formulario = new JPanel(new GridLayout(5, 2, 10, 10));

        formulario.add(new JLabel("Número de habitación:"));
        campoNumero = new JTextField();
        formulario.add(campoNumero);

        formulario.add(new JLabel("Tipo de habitación:"));
        comboTipo = new JComboBox<>(new String[]{"INDIVIDUAL", "DOBLE", "SUITE"});
        formulario.add(comboTipo);

        formulario.add(new JLabel("Precio:"));
        campoPrecio = new JTextField();
        formulario.add(campoPrecio);

        formulario.add(new JLabel("Disponible:"));
        checkDisponible = new JCheckBox();
        formulario.add(checkDisponible);

        botonGuardar = new JButton("Guardar Habitación");
        formulario.add(new JLabel()); // espacio vacío
        formulario.add(botonGuardar);

        add(formulario, BorderLayout.NORTH);

        tablaHabitaciones = new JTable();
        add(new JScrollPane(tablaHabitaciones), BorderLayout.CENTER);

        // Validaciones de campos
        ValidarCampo.soloNumeros(campoNumero);
        ValidarCampo.soloNumeros(campoPrecio);
    }
}
