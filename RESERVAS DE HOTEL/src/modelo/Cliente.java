package modelo;

public class Cliente {

    private final String cedula;
    private final String nombre;
    private final String apellido;
    private final String telefono;
    private final String correo;

    public Cliente(String cedula, String nombre, String apellido, String telefono, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String toCSV() {
        return cedula + "," + nombre + "," + apellido + "," + telefono + "," + correo;
    }
}
