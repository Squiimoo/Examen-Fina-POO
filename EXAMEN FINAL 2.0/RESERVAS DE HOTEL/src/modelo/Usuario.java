package modelo;

public abstract class Usuario {
    protected String usuario;
    protected String contrasena;

    public Usuario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public boolean verificarContrasena(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    public abstract String getRol();  // Ej: "Administrador" o "Recepcionista"

    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
