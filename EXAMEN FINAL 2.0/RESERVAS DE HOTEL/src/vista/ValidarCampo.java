package vista;

import java.awt.event.*;
import javax.swing.*;

public class ValidarCampo {

    public static void soloNumeros(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isISOControl(c)) return; // permite borrar/suprimir

                if (!Character.isDigit(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Solo números");
                }
            }
        });
    }


    public static void soloLetras(JTextField campo) {
        campo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isISOControl(c)) return; // permite borrar, suprimir, etc.

                if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Solo letras");
                }
            }
        });
    }

}
