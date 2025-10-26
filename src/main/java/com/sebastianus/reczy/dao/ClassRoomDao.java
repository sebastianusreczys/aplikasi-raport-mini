package com.sebastianus.reczy.dao;

import com.sebastianus.reczy.entity.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomDao extends JpaRepository<ClassRoom, String> {
}
