package ru.digitalleague.hibertaxiservice.persistance.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CityQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long city_id;

    private String name;

    private String queue;
}
