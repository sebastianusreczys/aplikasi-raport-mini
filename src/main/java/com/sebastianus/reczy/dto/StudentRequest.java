package com.sebastianus.reczy.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequest {
    private String nisn;
    private String nama;
    private String kelasId;
}
