package vista;

import java.awt.event.*;
import javax.swing.*;

public class ValidarCampo {

    public static void soloNumeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Solo se permiten números", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void soloLetras(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isLetter(c) && c != ' ' && c != '\b') {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Solo se permiten letras", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
