package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDatabase {

    // Atributos de configuración de la base de datos
	
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cuentas";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    // Método para obtener una conexión a la base de datos (ya que la variable connection no voy a reutilizarla y devuelvo directamente la conexion
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    }

}