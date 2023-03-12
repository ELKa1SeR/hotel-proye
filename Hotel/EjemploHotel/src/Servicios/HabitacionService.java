package Servicios;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import Entidad.Habitacion;
import Entidad.Reserva;

public class HabitacionService  {

    private static final String RUTA_HABITACIONES = "habitaciones.dat";
    private static final String RUTA_RESERVAS = "reservas.dat";
	private static final String RESERVAS_FILE = null;
    
    private TreeMap<String, Habitacion> habitaciones;
    private ArrayList<Reserva> reservas;

    public HabitacionService() {
        habitaciones = leerHabitaciones();
        reservas = leerReservas();
    }
    
    private TreeMap<String, Habitacion> leerHabitaciones() {
        TreeMap<String, Habitacion> habitaciones = new TreeMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_HABITACIONES))) {
            habitaciones = (TreeMap<String, Habitacion>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el fichero de habitaciones: " + e.getMessage());
        }
        return habitaciones;
    }

    private ArrayList<Reserva> leerReservas() {
        ArrayList<Reserva> reservas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA_RESERVAS))) {
            reservas = (ArrayList<Reserva>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el fichero de reservas: " + e.getMessage());
        }
        return reservas;
    }
    
    public ArrayList<Habitacion> listarHabitacionesDisponibles() {
    	ArrayList<Habitacion> habitacionesDisponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones.values()) {
            if (habitacion.estaDisponible(reservas)) {
                habitacionesDisponibles.add(habitacion);
            }
        }
        return habitacionesDisponibles;
    }

    public ArrayList<Habitacion> listarHabitacionesDisponiblesPorTipo(String tipoHabitacion) {
    	ArrayList<Habitacion> habitacionesDisponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones.values()) {
            if (habitacion.getTipoHabitacion().equals(tipoHabitacion) && habitacion.estaDisponible(reservas)) {
                habitacionesDisponibles.add(habitacion);
            }
        }
        return habitacionesDisponibles;
    }

    public Habitacion getHabitacion(String codigoHabitacion) {
        return habitaciones.get(codigoHabitacion);
    }

   
    public Reserva crearReserva(String codigoHabitacion, String dni, LocalDate fechaEntrada, LocalDate fechaSalida) {
        Habitacion habitacion = habitaciones.get(codigoHabitacion);
        if (habitacion != null && habitacion.estaDisponible(reservas)) {
            Reserva reserva = new Reserva(habitacion, dni, fechaEntrada, fechaSalida);
            reservas.add(reserva);
            return reserva;
        }
        return null;
    }
    private void escribirReservas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_RESERVAS))) {
            oos.writeObject(reservas);
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero de reservas: " + e.getMessage());
        }
        
    }
        public ArrayList<Reserva> obtenerReservas(String dni) {
        	ArrayList<Reserva> reservas = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RESERVAS_FILE))) {
                while (true) {
                    Reserva reserva = (Reserva) ois.readObject();
                    if (reserva.getDni().equals(dni)) {
                        reservas.add(reserva);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                // No hacer nada, simplemente devolver la lista actual de reservas encontradas
            }
            return reservas;
        }

       
        public boolean cancelarReserva(int codigoReserva) {
            Reserva reserva = null;
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RESERVAS_FILE))) {
                while (true) {
                    Reserva r = (Reserva) ois.readObject();
                    if (r.getCodigoReserva() == codigoReserva) {
                        reserva = r;
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                // No hacer nada, simplemente devolver false
            }
            if (reserva != null) {
                
             if (reserva.getCodigoHabitacion()==codigoReserva) {
				
			}   guardarReservas(obtenerReservas(reserva.getDni()), RESERVAS_FILE);
                return true;
            } else {
                return false;  }
        }     
        
        private void guardarReservas(ArrayList<Reserva> obtenerReservas, String reservasFile) {
			// TODO Auto-generated method stub
			
		}

		private void cargarHabitaciones() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("habitaciones.dat"))) {
                habitaciones = (TreeMap<String, Habitacion>) ois.readObject();
            } catch (FileNotFoundException e) {
                System.out.println("El archivo de habitaciones no existe. Se creará uno nuevo.");
                guardarHabitaciones();
            } catch (IOException e) {
                System.out.println("Error al leer el archivo de habitaciones.");
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("Error al leer el archivo de habitaciones.");
                e.printStackTrace();
            }
        }

		private void guardarHabitaciones() {
			// TODO Auto-generated method stub
			
		}   
        
		public ArrayList<Integer> buscarHabitacionesDisponibles(LocalDate fechaEntrada, LocalDate fechaSalida, int tipoHabitacion) {
			ArrayList<Integer> habitacionesDisponibles = new ArrayList<>();
	        for (Reserva reserva : reservas) {
	            if (reserva.getCodigoHabitacion() == tipoHabitacion) {
	                LocalDate fechaSalidaReserva = reserva.getFechaSalida();
	                if (fechaEntrada.isAfter(fechaSalidaReserva) || fechaEntrada.isEqual(fechaSalidaReserva)) {
	                    habitacionesDisponibles.add(reserva.getCodigoHabitacion());
	                }
	            }
	        }
	        return habitacionesDisponibles;
	    }
    }