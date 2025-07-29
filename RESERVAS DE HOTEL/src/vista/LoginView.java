package vista;

import java.awt.*;
import javax.swing.*;

public class LoginView extends JFrame {
    public JTextField campoUsuario;
    public JPasswordField campoContrasena;
    public JButton botonIngresar;

    public LoginView() {
        setTitle("Login - Sistema de Reservas");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Usuario:"));
        campoUsuario = new JTextField();
        add(campoUsuario);

        add(new JLabel("Contraseña:"));
        campoContrasena = new JPasswordField();
        add(campoContrasena);

        botonIngresar = new JButton("Ingresar");
        add(new JLabel()); // espacio vacío
        add(botonIngresar);
    }

    public void mostrar() {
        setVisible(true);
    }
}
