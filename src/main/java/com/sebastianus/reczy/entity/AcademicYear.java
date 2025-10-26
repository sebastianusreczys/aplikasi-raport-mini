package com.sebastianus.reczy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tahun_akademik")
public class AcademicYear {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String tahun;
}
