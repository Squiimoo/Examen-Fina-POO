package modelo;

public class Recepcionista extends Usuario {
    public Recepcionista(String usuario, String contrasena) {
        super(usuario, contrasena);
    }

    @Override
    public String getRol() {
        return "Recepcionista";
    }
}
