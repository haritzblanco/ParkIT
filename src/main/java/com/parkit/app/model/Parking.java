package com.parkit.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Parking {

    @Id
    private int id;

    private String name;
    private String Address;
    private int capacity;
    private float priceperhour;
    private float priceperday;
    private float pricepermonth;

}
