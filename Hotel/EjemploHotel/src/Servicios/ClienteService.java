package Servicios;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import Entidad.Cliente;


public class ClienteService  {
    private final String FILE_CLIENTES = "clientes.dat";
    private TreeMap<String, Cliente> clientes;

    public ClienteService() {
        clientes = new TreeMap<>();
        cargarClientes();
    }

    @SuppressWarnings("unchecked")
	private void cargarClientes() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_CLIENTES))) {
            clientes = (TreeMap<String, Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listadoClientes() {
        return new ArrayList<>(clientes.values());
    }

    
    public Cliente getClienteByDNI(String DNI) {
        return clientes.get(DNI);
    }
    
    public static void insertarCliente(Cliente cliente) {
        // Comprobamos que el cliente no existe previamente
        if (buscarCliente(cliente.getDni()) == null) {
            try {
                // Abrimos el fichero de clientes en modo append
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.dat", true)) {
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
                // Escribimos el cliente en el fichero
                oos.writeObject(cliente);
                // Cerramos el ObjectOutputStream
                oos.close();
                System.out.println("Cliente insertado correctamente.");
            } catch (IOException e) {
                System.err.println("Error al insertar el cliente: " + e.getMessage());
            }
        } else {
            System.err.println("El cliente ya existe en la base de datos.");
        }
    }

	private static Object buscarCliente(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	public File actualizarFicheroCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	public File actualizarFicheroCliente(ClienteService cliente) {
		// TODO Auto-generated method stub
		return null;
	}
    
    
}