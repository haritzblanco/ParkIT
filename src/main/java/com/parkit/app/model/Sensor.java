package com.parkit.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {

    @Id
    private int id;

    @ManyToOne
    private Parking parking;

    private String name;
    private boolean status;

}
