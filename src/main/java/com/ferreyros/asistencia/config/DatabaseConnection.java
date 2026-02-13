package com.ferreyros.asistencia.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String url="jdbc:sqlserver://localhost:1433;databaseName=control_asistencia;encrypt=true;trustServerCertificate=true;";
    private static final String user="sa";
    private static final String password="admin123";
    private static final String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static Connection connection = null;
    public Connection connectionDB() throws SQLException {

        if (connection == null || connection.isClosed()){
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url,user,password);
                System.out.println("Se establecio la conexion satisfactoriamente");

            } catch (ClassNotFoundException e) {
                System.err.println("no se pudo encotrar el driver y no se hizo la conexion");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
