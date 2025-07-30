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
    public JButton botonCheckIn;
    public JButton botonCheckOut;
    public JTextField campoBuscarApellido;
    public JTextField campoBuscarFecha;
    public JButton botonBuscar;
    public JButton botonCancelar;




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


        // Botonera inferior (acciones de reserva)
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        botonReservar = new JButton("Reservar");
        botonCheckIn = new JButton("Check-In");
        botonCheckOut = new JButton("Check-Out");
        botonCancelar = new JButton("Cancelar Reserva");

        panelBotones.add(botonReservar);
        panelBotones.add(botonCheckIn);
        panelBotones.add(botonCheckOut);
        panelBotones.add(botonCancelar);

        add(panelBotones, BorderLayout.SOUTH);

        JPanel panelBusqueda = new JPanel(new GridLayout(2, 3, 10, 5));
        panelBusqueda.setBorder(BorderFactory.createTitledBorder("Buscar reservas"));

        
        panelBusqueda.add(new JLabel("Buscar por apellido:"));
        campoBuscarApellido = new JTextField();
        panelBusqueda.add(campoBuscarApellido);

        panelBusqueda.add(new JLabel()); // vacío

        panelBusqueda.add(new JLabel("Buscar por fecha (AAAA-MM-DD):"));
        campoBuscarFecha = new JTextField();
        panelBusqueda.add(campoBuscarFecha);

        botonBuscar = new JButton("Buscar");
        panelBusqueda.add(botonBuscar);

        setLayout(new BorderLayout());
        add(panelBusqueda, BorderLayout.NORTH);

        // Panel central que contiene formulario + tabla
        JPanel panelCentro = new JPanel(new BorderLayout());
        // Formulario arriba dentro del centro
        panelCentro.add(formulario, BorderLayout.NORTH);
        // Tabla debajo del formulario
        tablaReservas = new JTable();
        panelCentro.add(new JScrollPane(tablaReservas), BorderLayout.CENTER);
        add(panelCentro, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);


        // Validaciones de campos
        ValidarCampo.soloNumeros(campoCedulaCliente);
        ValidarCampo.soloNumeros(campoNumeroHabitacion);
    }
}
