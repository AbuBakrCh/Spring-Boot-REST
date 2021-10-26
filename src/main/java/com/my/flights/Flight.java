package com.my.flights;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="flights")
public class Flight {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="airline", unique = false, nullable = false)
    private String airlineName;

    private int emptySeats;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date departureDate;
    private String destination;
    private int totalSeats;
    private long price;
    @Transient
    private boolean isTransient=true;

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getEmptySeats() {
        return emptySeats;
    }

    public void setEmptySeats(int emptySeats) {
        this.emptySeats = emptySeats;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "airlineName='" + airlineName + '\'' +
                ", emptySeats=" + emptySeats +
                ", departureDate=" + departureDate +
                ", destination='" + destination + '\'' +
                ", totalSeats=" + totalSeats +
                ", price=" + price +
                '}';
    }
}
