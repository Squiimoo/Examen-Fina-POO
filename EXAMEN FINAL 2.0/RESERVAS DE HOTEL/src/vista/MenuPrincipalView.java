package vista;

import javax.swing.*;

public class MenuPrincipalView extends JFrame {
    public JTabbedPane pestanias;

    public MenuPrincipalView() {
        setTitle("Menú Principal - Sistema de Hotel");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        pestanias = new JTabbedPane();
        setContentPane(pestanias);
    }

    public void agregarPestania(String titulo, JPanel panel) {
        pestanias.addTab(titulo, panel);
    }
}
