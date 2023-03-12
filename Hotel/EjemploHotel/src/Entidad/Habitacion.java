package Entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Habitacion implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigoHabitacion;
    private String tipoHabitacion;
    private int planta;
    private int numeroHabitacion;
    private double precio;
    private double descuentoEmpleado;
    private int codigoReserva;
    
	public int getCodigoHabitacion() {
		return codigoHabitacion;
	}
	public void setCodigoHabitacion(int codigoHabitacion) {
		this.codigoHabitacion = codigoHabitacion;
	}
	public String getTipoHabitacion() {
		return tipoHabitacion;
	}
	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}
	public int getPlanta() {
		return planta;
	}
	public void setPlanta(int planta) {
		this.planta = planta;
	}
	public int getNumeroHabitacion() {
		return numeroHabitacion;
	}
	public void setNumeroHabitacion(int numeroHabitacion) {
		this.numeroHabitacion = numeroHabitacion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getDescuentoEmpleado() {
		return descuentoEmpleado;
	}
	public void setDescuentoEmpleado(double descuentoEmpleado) {
		this.descuentoEmpleado = descuentoEmpleado;
	}
	public int getCodigoReserva() {
		return codigoReserva;
	}
	public void setCodigoReserva(int codigoReserva) {
		this.codigoReserva = codigoReserva;
	}
	public Habitacion(int codigoHabitacion, String tipoHabitacion, int planta, int numeroHabitacion, double precio,
			double descuentoEmpleado, int codigoReserva) {
		super();
		this.codigoHabitacion = codigoHabitacion;
		this.tipoHabitacion = tipoHabitacion;
		this.planta = planta;
		this.numeroHabitacion = numeroHabitacion;
		this.precio = precio;
		this.descuentoEmpleado = descuentoEmpleado;
		this.codigoReserva = codigoReserva;
	}

	
	 public int compareTo(Habitacion other) {
	        // We compare by room type first and then by room code
	        if (this.tipoHabitacion.compareTo(other.tipoHabitacion) != 0) {
	            return this.tipoHabitacion.compareTo(other.tipoHabitacion);
	        } else {
	        	return Integer.compare(this.codigoHabitacion, other.codigoHabitacion);
	        	}
	        }
	    

	public boolean estaDisponible(ArrayList<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            if (reserva.getCodigoHabitacion() == codigoHabitacion) {
                return false;
            }
        }
        return true;
	}
	public List<Reserva> getReservas(ArrayList<Reserva> reservas) {
		List<Reserva> reservasHabitacion = new ArrayList<>();
		for (Reserva reserva : reservas) {
			if (reserva.getCodigoHabitacion() == this.codigoHabitacion) {
				reservasHabitacion.add(reserva);
				
			}
		}
		return reservasHabitacion;
	}
	 
}