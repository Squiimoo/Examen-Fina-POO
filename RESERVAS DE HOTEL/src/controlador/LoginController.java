package controlador;

import java.awt.event.ActionEvent;
import modelo.Administrador;
import modelo.Recepcionista;
import modelo.Usuario;
import vista.ClienteView;
import vista.HabitacionView;
import vista.LoginView;
import vista.MenuPrincipalView;
import vista.ReservaView;

public class LoginController {
    private final LoginView vista;

    public LoginController(LoginView vista) {
        this.vista = vista;

        this.vista.botonIngresar.addActionListener((ActionEvent e) -> {
            String usuario = vista.campoUsuario.getText();
            String contrasena = new String(vista.campoContrasena.getPassword());
            
            // Usuarios de ejemplo (temporal, luego se puede cargar desde archivo)
            Usuario user = null;
            if (usuario.equals("will") && contrasena.equals("123456")) {
                user = new Administrador(usuario, contrasena);
            } else if (usuario.equals("recep") && contrasena.equals("1234")) {
                user = new Recepcionista(usuario, contrasena);
            }
            
            if (user != null) {
                vista.dispose();
                abrirMenu(user);
            } else {
                System.out.println("Credenciales incorrectas");
            }
        });
    }

    private void abrirMenu(Usuario usuario) {
        MenuPrincipalView menu = new MenuPrincipalView();

        // Vistas
        ClienteView clienteView = new ClienteView();
        HabitacionView habitacionView = new HabitacionView();
        ReservaView reservaView = new ReservaView();

        // Controladores asociados
        new ClienteController(clienteView);
        new HabitacionController(habitacionView);
        new ReservaController(reservaView);

        // Agregar pestañas
        menu.agregarPestania("Clientes", clienteView);
        menu.agregarPestania("Habitaciones", habitacionView);
        menu.agregarPestania("Reservas", reservaView);

        menu.setVisible(true);
    }

}
