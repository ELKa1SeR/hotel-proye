package Entidad;




// Clase modelo Trabajador
public class Trabajador extends Persona implements Comparable {
    private String codigoTrabajador;

    public Trabajador(String dni, String nombre, String apellido1, String apellido2, int telefono, String codigoTrabajador) {
        super(dni, nombre, apellido1, apellido2, telefono);
        this.codigoTrabajador = codigoTrabajador;
    }

    public String getCodigoTrabajador() {
        return codigoTrabajador;
    }

    public void setCodigoTrabajador(String codigoTrabajador) {
        this.codigoTrabajador = codigoTrabajador;
    }
    public int compareTo(Trabajador t) {
        return this.getDni().compareTo(t.getDni());
    }
}
