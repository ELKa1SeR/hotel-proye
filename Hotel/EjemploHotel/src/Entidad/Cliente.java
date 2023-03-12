package Entidad;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {
    private int numeroReservas;
	private String dni;

    public Cliente(String dni, String nombre, String apellido1, String apellido2, int telefono, int numeroReservas) {
        super(dni, nombre, apellido1, apellido2, telefono);
        this.numeroReservas = numeroReservas;
    }

    public int getNumeroReservas() {
        return numeroReservas;
    }

    public void setNumeroReservas(int numeroReservas) {
        this.numeroReservas = numeroReservas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + getDni() + '\'' +
                ", nombre='" + getNombre() + '\'' +
                ", apellido1='" + getApellido1() + '\'' +
                ", apellido2='" + getApellido2() + '\'' +
                ", telefono=" + getTelefono() +
                ", numeroReservas=" + numeroReservas +
                '}';
    }

    public boolean getDni(Object obj) {
        if (obj instanceof Persona) {
            Persona persona = (Persona) obj;
            return this.dni.equals(persona.getDni());
        }
        return false;
    }

	
	
}