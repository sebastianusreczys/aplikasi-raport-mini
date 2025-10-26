package com.sebastianus.reczy.service;

import com.sebastianus.reczy.dao.ClassRoomDao;
import com.sebastianus.reczy.dao.StudentDao;
import com.sebastianus.reczy.dto.StudentRequest;
import com.sebastianus.reczy.dto.StudentResponse;
import com.sebastianus.reczy.entity.ClassRoom;
import com.sebastianus.reczy.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ClassRoomDao classRoomDao;

    public StudentResponse createStudent(StudentRequest request){
        // cek apakah nis udah terdaftar apa belum di database
        if(studentDao.existsByNis(request.getNisn())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "NIS alredy exsits");
        }
        // cari id classRoom dari database
        ClassRoom classRoom = classRoomDao.findById(request.getKelasId()).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID ClassRoom not found")
        );
        // simpan object student
        Student student = Student.builder()
                .id(UUID.randomUUID().toString())
                .nama(request.getNama())
                .nisn(request.getNisn())
                .kelas(classRoom)
                .build();
        return mapToResponse(student);
    }

    public StudentResponse createUpdateStudent(StudentRequest request, String studentId){
        Student student = studentDao.findById(studentId).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found")
        );
        ClassRoom classRoom = classRoomDao.findById(request.getKelasId()).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Class not found")
        );
        Student updateStudent = Student.builder()
                .nisn(request.getNisn())
                .nama(request.getNama())
                .kelas(classRoom)
                .build();
        return mapToResponse(updateStudent);
    }

    public void deleteStudent(String id){
        studentDao.deleteById(id);
    }

    public StudentResponse getStudentById(String id){
        Student student = studentDao.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found")
        );
        return mapToResponse(student);
    }

    public List<StudentResponse> getAllStudents(){
       return studentDao.findAll()
               .stream()
               .map(this::mapToResponse)
               .toList();
    }

    public List<StudentResponse> getStudentByClass(String classId){
        return studentDao.findAll()
                .stream()
                .filter(student -> student.getKelas().getId().equals(classId))
                .map(this::mapToResponse)
                .toList();
    }

    private StudentResponse mapToResponse(Student student){
        return StudentResponse.builder()
                .id(student.getId())
                .nama(student.getNama())
                .nisn(student.getNisn())
                .namaKelas(student.getNama())
                .build();
    }
}
