package com.sebastianus.reczy.dao;

import com.sebastianus.reczy.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, String> {
    boolean existsByNis(String nisn);
}
