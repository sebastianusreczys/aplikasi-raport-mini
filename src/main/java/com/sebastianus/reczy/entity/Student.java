package com.sebastianus.reczy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "siswa")
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_kelas")
    private ClassRoom kelas;

    private String nama;
    private String nisn;
}
