package org.example.airport.services;

import org.example.airport.tablemodelsinjava.Passenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class PassengerService {


    Set<Passenger> list = new HashSet<>();

    public void getALLDataInTablePassenger(Connection con) {

        try {
            PreparedStatement st = con.prepareStatement("select * from passengers");


            ResultSet rs = st.executeQuery();

            while (rs.next()) {


                int id = rs.getInt("pass_id");
                String name = rs.getString("pass_name");
                String phone = rs.getString("pass_phone");
                String country = rs.getString("pass_country");
                String city = rs.getString("pass_city");

                list.add(new Passenger(id, name, phone, country, city));
                System.out.println(list);
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Passenger getDataInTablePassenger(Connection con, int passId) {
            checkId(passId);
        Passenger p;
        try {
            PreparedStatement st = con.prepareStatement("select * from passengers where pass_id = ?");

            st.setInt(1, passId);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("pass_id");
                String name = rs.getString("pass_name");
                String phone = rs.getString("pass_phone");
                String country = rs.getString("pass_country");
                String city = rs.getString("pass_city");

                p = new Passenger(id, name, phone, country, city);
                list.add(p);
                return p;
            }

            rs.close();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private void checkId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("'passenger id' always is positive number: ");
        }
    }

    public void sout(){
        System.out.println(list);
    }
}
