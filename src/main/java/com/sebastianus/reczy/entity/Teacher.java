package com.sebastianus.reczy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "guru")
public class Teacher {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nama;
    private String nip;
}
