package com.sebastianus.reczy.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "kelas_mapel")
public class ClassSubject {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_kelas")
    private ClassRoom classRoom;

    @ManyToOne
    @JoinColumn(name = "id_mapel")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "id_guru")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "id_tahun_akademik")
    private AcademicYear academicYear;

    @ManyToOne
    @JoinColumn(name = "id_semester")
    private Semester semester;
}
