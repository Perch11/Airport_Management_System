package org.example.airport.readandinsert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class InsertDB {


    public static void ReadAndInsertInTableCompany(Connection con) {
        int i = 0;
        try {
            FileReader fileReader = new FileReader("C:\\Users\\Perch\\Desktop\\companies.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO company (company_name, found_date)" +
                    " VALUES (?, ?)");

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                preparedStatement.setString(1, data[0]);
                preparedStatement.setString(2, data[1]);
                i = preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            bufferedReader.close();
            fileReader.close();

            System.out.println("Data inserted into database successfully.");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ReadAndInsertInTablePassengers(Connection con) {
        int i = 0;
        try {
            FileReader fileReader = new FileReader("C:\\Users\\Perch\\Desktop\\passengers.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO passengers (pass_name,pass_phone,pass_country,pass_city)" +
                    " VALUES (?,?,?,?)");

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                preparedStatement.setString(1, data[0]);
                preparedStatement.setString(2, data[1]);
                preparedStatement.setString(3, data[2]);
                preparedStatement.setString(4, data[3]);
                i = preparedStatement.executeUpdate();
            }

            preparedStatement.close();
            bufferedReader.close();
            fileReader.close();

            System.out.println("Data inserted into database successfully.");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ReadAndInsertInTableTrip(Connection con) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        PreparedStatement preparedStatement;
        try {
            fileReader = new FileReader("C:\\Users\\Perch\\Desktop\\trip.txt");
            bufferedReader = new BufferedReader(fileReader);

            preparedStatement = con.prepareStatement("INSERT INTO trip (trip_number,company_id,airplane_name,town_from,town_to,time_out,time_in)" +
                    " VALUES (?,?,?,?,?,?,?)");

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                preparedStatement.setInt(1, Integer.parseInt(data[0]));
                preparedStatement.setInt(2, Integer.parseInt(data[1]));
                preparedStatement.setString(3, data[2]);
                preparedStatement.setString(4, data[3]);
                preparedStatement.setString(5, data[4]);
                preparedStatement.setTimestamp(6, Timestamp.valueOf(data[5]));
                preparedStatement.setTimestamp(7, Timestamp.valueOf(data[6]));
                preparedStatement.executeUpdate();
            }


            preparedStatement.close();
            bufferedReader.close();
            fileReader.close();

            System.out.println("Data inserted into database successfully.");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
