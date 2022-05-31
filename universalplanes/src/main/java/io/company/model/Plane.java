package io.company.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table()
public class Plane {

    @Id
    private long planeId;
    private String make;
    private String planePlate;
    private String manufacturer;
    private int capacity;
    private String type;

    @OneToMany(mappedBy = "plane")
    private List<Flight> flights = new ArrayList<>();





}
