package org.example.airport.tablemodelsinjava;

import java.sql.Timestamp;

public class Trip {
    private int tripNum;
    private Company company;
    private String airplaneName;
    private String townFrom;
    private String townTo;
    private Timestamp timeOut;
    private Timestamp TimeIn;

    public int getTripNum() {
        return tripNum;
    }

    public void setTripNum(int tripNum) {
        this.tripNum = tripNum;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public String getTownFrom() {
        return townFrom;
    }

    public void setTownFrom(String townFrom) {
        this.townFrom = townFrom;
    }

    public String getTownTo() {
        return townTo;
    }

    public void setTownTo(String townTo) {
        this.townTo = townTo;
    }

    public Timestamp getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Timestamp timeOut) {
        this.timeOut = timeOut;
    }

    public Timestamp getTimeIn() {
        return TimeIn;
    }

    public void setTimeIn(Timestamp timeIn) {
        TimeIn = timeIn;
    }
}
