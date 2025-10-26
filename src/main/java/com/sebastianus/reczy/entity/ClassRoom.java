package com.sebastianus.reczy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "kelas")
public class ClassRoom {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_guru")
    private Teacher guru;

    private String nama;
}
