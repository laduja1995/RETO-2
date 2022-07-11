package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection connection;

    String driver = "com.mysql.cj.jcbc.Driver";
    String cadenaConnexion = "jdbc:mysql://localhost:3306/";
    String nombreBaseDatos = "reto_g56_db";
    String usuario = "root";
    String contraseña = "";

    public Conexion() {

        try {

            Class.forName("driver");
            connection = DriverManager.getConnection("jdbc: mysql: //localhost/admint");

            connection = DriverManager.getConnection(cadenaConnexion+nombreBaseDatos,usuario,contraseña);
            Object conection = null;
            if (conection != null) {
                System.out.println("conexión exitosa");

            }
        } catch (ClassNotFoundException | SQLException e) {
            String jdbc = null;
            System.out.println("conexión fallida");

        }

    }

    public Connection getConnection() {
        return connection;
    }

}
