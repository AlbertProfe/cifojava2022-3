package io.company.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Flight {

    @Id
    private Long flightId;
    private String originAirport;
    private String destinationAirport;
    private String flightCode;
    //day and hour-min
    private LocalDate departureTime;
    private LocalDate arrivalTime;
    //minutes
    private int duration;

    @JsonIgnore
    @JoinColumn(name="PLANE_FK")
    @ManyToOne()
    private Plane plane;

}