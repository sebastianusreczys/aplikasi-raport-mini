package com.sebastianus.reczy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "siswa")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_kelas")
    private ClassRoom kelas;

    private String nama;
    private String nisn;
}
