package Servicios;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Entidad.Persona;
import Entidad.Trabajador;


public class TrabajadorService {
    private String fichero = "trabajadores.dat";

    public ArrayList<Trabajador> listadoTrabajadores() {
    	ArrayList<Trabajador> trabajadores = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            trabajadores = (ArrayList<Trabajador>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("No existe el fichero de trabajadores");
        } catch (IOException | ClassNotFoundException e) {
            ((Throwable) e).printStackTrace();
        }
        trabajadores.sort(null);
        return trabajadores;
    }

    public Trabajador getTrabajadorByDNI(String dni) {
    	ArrayList<Trabajador> trabajadores = listadoTrabajadores();
       for (Trabajador trabajador : trabajadores) {
           if (trabajador.getDni().equals(dni)) {
               return trabajador;
           }
       }
       return null;
    }

    public File actualizarFicheroTrabajador(Trabajador trabajador) {
       // Comprobamos si el trabajador ya existe en el fichero
       if (getTrabajadorByDNI(trabajador.getDni()) != null) {
           System.out.println("El trabajador ya existe en el fichero");
           return null;
       }
       // Si el trabajador no existe, lo añadimos al fichero
       try {
    	   ArrayList<Trabajador> trabajadores = listadoTrabajadores();
           trabajadores.add(trabajador);
           FileOutputStream fos = new FileOutputStream(fichero);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(trabajadores);
           oos.close();
           System.out.println("Trabajador añadido correctamente al fichero");
       } catch (IOException e) {
           e.printStackTrace();
       }
       return new File(fichero);
    }

    public void insertarTrabajador(Trabajador trabajador) {
        // Comprobamos que el trabajador no existe previamente
        if (getTrabajadorByDNI(trabajador.getDni()) == null) {
            try {
                // Abrimos el fichero de trabajadores en modo append
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero, true)) {
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
                // Escribimos el trabajador en el fichero
                oos.writeObject(trabajador);
                // Cerramos el ObjectOutputStream
                oos.close();
                System.out.println("Trabajador insertado correctamente.");
            } catch (IOException e) {
                System.err.println("Error al insertar el trabajador: " + e.getMessage());
            }
        } else {
            System.err.println("El trabajador ya existe en la base de datos.");
        }
    }
}