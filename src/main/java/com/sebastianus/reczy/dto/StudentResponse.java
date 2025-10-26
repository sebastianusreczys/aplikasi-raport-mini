package com.sebastianus.reczy.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponse {

    private String id;
    private String nisn;
    private String nama;
    private String namaKelas;
}
