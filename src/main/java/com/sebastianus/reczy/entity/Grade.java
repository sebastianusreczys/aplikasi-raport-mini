package com.sebastianus.reczy.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "nilai")
public class Grade {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_siswa", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_kelas_mapel", nullable = false)
    private ClassSubject classSubject;

    private BigDecimal nilaiTugas;
    private BigDecimal nilaiUlangan;
    private BigDecimal nilaiUas;
    private BigDecimal totalNilai;

    @Column(columnDefinition = "TEXT")
    private String deskripsi;
}
