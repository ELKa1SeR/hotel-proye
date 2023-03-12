package Entidad;

import java.io.Serializable;

public class Persona implements Serializable, Comparable {

    private static final long serialVersionUID = 1L;

    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int telefono;

    public Persona(String dni, String nombre, String apellido1, String apellido2, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean getDni(Object obj) {
        if (obj instanceof Persona) {
            Persona persona = (Persona) obj;
            return this.dni.equals(persona.getDni());
        }
        return false;
    }

    public String getNombreCompleto() {
        return apellido1 + " " + apellido2 + ", " + nombre;
    }

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}