package main;

import controlador.ClienteController;
import controlador.HabitacionController;
import controlador.LoginController;
import controlador.ReservaController;
import vista.*;

public class Main {
    
    public static void main(String[] args) {
        // Crear vistas
        LoginView login = new LoginView();
        ClienteView clienteView = new ClienteView();
        HabitacionView habitacionView = new HabitacionView();
        ReservaView reservaView = new ReservaView();

        // Conectar controladores
        new ClienteController(clienteView);
        new HabitacionController(habitacionView);
        new ReservaController(reservaView);
        new LoginController(login);

        // Mostrar login
        login.mostrar();
    }
}
