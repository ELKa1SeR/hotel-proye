package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import Entidad.Hotel;
import Interface.HotelUI;
import Servicios.HotelService;

public class DbHotel {

	public Connection conexion;
	public Statement st;

	public void abreConexion()
	{
		try{
			conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/cuentas", "root", "");
			st = conexion.createStatement();
			System.out.println("Conexión abierta.");
		} catch (SQLException e1){
			MuestraError(e1);
		}

		// Mostrar o crear un hotel
		Hotel h = new Hotel(); // Opción 1: crear directamente el hotel
		System.out.println("Hotel creado: " + h.getNombre()); 

		// Opción 2: mostrar un hotel ya existente
		HotelUI hotelUI = new HotelService();
		Hotel hotelExistente = hotelUI.getHotel(1); // Obtener hotel con ID 1
		if (hotelExistente != null) {
			System.out.println("Hotel existente: " + hotelExistente.getNombre());
		} else {
			System.out.println("No se encontró un hotel con el ID especificado.");
		}
	}

	private void MuestraError(SQLException e) {
		// mostrar un mensaje de error en la interfaz de usuario seria de esta manera: (System.err.println("Error de SQL: " + e.getMessage());)
		e.printStackTrace();
	}

}
