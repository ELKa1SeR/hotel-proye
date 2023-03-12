package Entidad;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private int codigoReserva;
    private int codigoHabitacion;
    private String dni;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private boolean disponible;
    private int precio;

    public Reserva(int codigoReserva, int codigoHabitacion, String dni, LocalDate fechaEntrada, LocalDate fechaSalida, boolean disponible, int precio) {
        this.codigoReserva = codigoReserva;
        this.codigoHabitacion = codigoHabitacion;
        this.dni = dni;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.disponible = disponible;
        this.precio = precio;
    }

    public Reserva(Habitacion habitacion, String dni2, LocalDate fechaEntrada2, LocalDate fechaSalida2) {
		// TODO Auto-generated constructor stub
	}

	public int getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(int codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public int getCodigoHabitacion() {
        return codigoHabitacion;
    }

    public void setCodigoHabitacion(int codigoHabitacion) {
        this.codigoHabitacion = codigoHabitacion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    public boolean verificarDisponibilidad(Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
        List<Reserva> reservas = habitacion.getReservas(null);
        for (Reserva reserva : reservas) {
            LocalDate fechaInicio = reserva.getFechaEntrada();
            LocalDate fechaFin = reserva.getFechaSalida();
            if (fechaEntrada.isBefore(fechaFin) && fechaSalida.isAfter(fechaInicio)) {
                // Las fechas se solapan, la habitación no está disponible
                return false;
            }
        }
        // No hay reservas que se solapen con la nueva reserva, la habitación está disponible
        return true;
    }
}