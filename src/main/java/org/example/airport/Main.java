package org.example.airport;


import org.example.airport.dbconection.ConnectionDB;
import org.example.airport.readandinsert.InsertDB;
import org.example.airport.services.PassengerService;
import org.example.airport.tablemodelsinjava.Passenger;

import java.sql.Connection;
import java.sql.SQLException;

import static org.example.airport.services.PassengerService.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = ConnectionDB.getConnection();

        InsertDB.ReadAndInsertInTableTrip(con);

        ConnectionDB.closeConnection(con);




    }
}
