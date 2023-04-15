package org.example.airport.dbconection;

import org.example.airport.tablemodelsinjava.Passenger;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/airport";
    private static final String USERNAME = "postgres";
    private static final String PASS = "1107";
    private static java.sql.Connection connection;
    List<Passenger> list = new ArrayList<>();

    public static java.sql.Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASS);
            System.out.println("bacvec");
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void closeConnection(java.sql.Connection connection) {
        if (connection == null) {
            throw new NullPointerException("Connection is null:");
        }
        try {
            System.out.println("pakvec");
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
