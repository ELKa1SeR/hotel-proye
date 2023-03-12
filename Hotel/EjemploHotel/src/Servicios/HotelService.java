package Servicios;

import java.util.ArrayList;

import Entidad.Hotel;
import Interface.HotelUI;

public class HotelService implements HotelUI{

	@Override
	public ArrayList<Hotel> getHoteles() {
		return null;
	//Hacer la logica de obtener de la base de datos la lista de todos hoteles. Se podrá ordenar por nombre por ejemplo.
	}

	@Override
	public Hotel getHotel(int id) {
		return null;
	//Hacer la logica de obtener el hotel de la base de datos por su id
	}
	
}
