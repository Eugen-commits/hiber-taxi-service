package ru.digitalleague.hibertaxiservice.persistance.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.OffsetDateTime;


@Data
@Entity
public class TaxiDriveInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long driver_id;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String firstName;

    private int level;

    private String carModel;

    @Column(insertable = false)
    private OffsetDateTime create_dttm;
}
