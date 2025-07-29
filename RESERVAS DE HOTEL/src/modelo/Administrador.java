package modelo;

public class Administrador extends Usuario {
    public Administrador(String usuario, String contrasena) {
        super(usuario, contrasena);
    }

    @Override
    public String getRol() {
        return "Administrador";
    }
}
