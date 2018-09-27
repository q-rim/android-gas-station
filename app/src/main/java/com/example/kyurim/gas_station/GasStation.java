package com.example.kyurim.gas_station;

import java.io.Serializable;

public class GasStation implements Serializable {

    private String lat;
    private String lng;
    private String price;
    private String dist;
    private String station;
    private String address;

    public GasStation(String lat, String lng, String price, String dist, String station, String address) {
        this.lat = lat;
        this.lng = lng;
        this.price = price;
        this.dist = dist;
        this.station = station;
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getPrice() {
        return price;
    }

    public String getDist() {
        return dist;
    }

    public String getStation() {
        return station;
    }

    public String getAddress() {
        return address;
    }
}
