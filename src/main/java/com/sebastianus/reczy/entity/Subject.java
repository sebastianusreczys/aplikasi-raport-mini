package com.sebastianus.reczy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "mapel")
public class Subject {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nama;
}
