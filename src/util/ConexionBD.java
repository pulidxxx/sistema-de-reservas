package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase que manipula la conexión a la base de datos.
 */

public class ConexionBD {
    private static ConexionBD instancia = null;
    private Connection conexion = null;
    private boolean conexionLibre = true;

    public static ConexionBD getInstancia() throws Exception {
        if (instancia == null) {
            try {
                instancia = new ConexionBD();
            } catch (Exception e) {
                throw new Exception(e);
            }
        }

        return instancia;
    }

    private ConexionBD() throws Exception {
        try {
            // Se registra el Driver y se crea la conexion
            String url = "jdbc:postgresql://localhost:5432/reservas";
            String usuario = "postgres";
            String password = "Hola123456";
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
            conexion.setAutoCommit(false);
        } catch (Exception e) {
            throw new Exception(e);
        }
     }

    public synchronized Connection tomarConexion() throws Exception {
        while (!conexionLibre) {
            try {
              wait();
            } catch (InterruptedException e) {
                throw new Exception(e);
            }
        }

        conexionLibre = false;
        notify();

        return conexion;
    }

    public synchronized void liberarConexion() throws Exception {
        while (conexionLibre) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new Exception(e);
            }
        }

        conexionLibre = true;
        notify();
    }

    public void cerrar() throws Exception {
        try {
            conexion.close();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void commit() throws Exception {
        try {
            conexion.commit();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public void rollback() throws Exception {
        try {
            conexion.rollback();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}
