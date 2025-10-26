package com.sebastianus.reczy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "semester")
public class Semester {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nama;
}
