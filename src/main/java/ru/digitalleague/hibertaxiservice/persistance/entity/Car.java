package ru.digitalleague.hibertaxiservice.persistance.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String model;

    @Column(insertable = false)
    private OffsetDateTime createdttm;
}
