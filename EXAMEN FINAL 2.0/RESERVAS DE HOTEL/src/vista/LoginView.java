package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginView extends JFrame {
    public JTextField campoUsuario;
    public JPasswordField campoContrasena;
    public JButton botonIngresar;

    public LoginView() {
        setTitle("🔐 Login - Sistema de Reservas");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel fondo = new JPanel();
        fondo.setBackground(new Color(245, 245, 250));
        fondo.setBorder(new EmptyBorder(20, 30, 20, 30));
        fondo.setLayout(new BoxLayout(fondo, BoxLayout.Y_AXIS));
        add(fondo);

        JLabel titulo = new JLabel("Bienvenido al sistema");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titulo.setForeground(new Color(60, 60, 90));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        fondo.add(titulo);
        fondo.add(Box.createVerticalStrut(20));

        // Panel de usuario
        JPanel panelUsuario = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelUsuario.setBackground(new Color(245, 245, 250));
        JLabel labelUsuario = new JLabel("Usuario:");
        labelUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        campoUsuario = new JTextField(20);
        campoUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panelUsuario.add(labelUsuario);
        panelUsuario.add(campoUsuario);
        fondo.add(panelUsuario);
        fondo.add(Box.createVerticalStrut(10));

        // Panel de contraseña
        JPanel panelContrasena = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelContrasena.setBackground(new Color(245, 245, 250));
        JLabel labelContrasena = new JLabel("Contraseña:");
        labelContrasena.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        campoContrasena = new JPasswordField(20);
        campoContrasena.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panelContrasena.add(labelContrasena);
        panelContrasena.add(campoContrasena);
        fondo.add(panelContrasena);
        fondo.add(Box.createVerticalStrut(20));

        // Botón
        botonIngresar = new JButton("Ingresar");
        botonIngresar.setFont(new Font("Segoe UI", Font.BOLD, 15));
        botonIngresar.setBackground(new Color(100, 149, 237));
        botonIngresar.setForeground(Color.WHITE);
        botonIngresar.setFocusPainted(false);
        botonIngresar.setAlignmentX(Component.CENTER_ALIGNMENT);
        fondo.add(botonIngresar);
    }

    public void mostrar() {
        setVisible(true);
    }
}