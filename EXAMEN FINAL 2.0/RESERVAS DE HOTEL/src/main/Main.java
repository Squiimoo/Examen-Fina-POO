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
        @SuppressWarnings("unused")
        ClienteController clienteController = new ClienteController(clienteView);
        HabitacionController habitacionController = new HabitacionController(habitacionView);
        @SuppressWarnings("unused")
        ReservaController reservaController = new ReservaController(reservaView, habitacionController);
        @SuppressWarnings("unused")
        LoginController loginController = new LoginController(login);

        // Mostrar login
        login.mostrar();
    }
}
