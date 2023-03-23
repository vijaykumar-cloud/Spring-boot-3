package com.example.springboot3demo.service;

import com.example.springboot3demo.model.Student;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    List<Student> studentList = new ArrayList<>();

    @Autowired
    private ObservationRegistry observationRegistry;

    public List<Student> addStudent(Student student) {
        studentList.add(student);
        //return studentList;
        return Observation.createNotStarted("addStudent", observationRegistry)
                .observe(() -> studentList);
    }

    public List<Student> fetchAllStudent() {
        return Observation.createNotStarted("fetchAllStudent", observationRegistry)
                .observe(() -> studentList);
    }

    public Optional<Student> findStudentById(int id) {
        Optional<Student> student =  studentList.stream()
                .filter(studentData -> studentData.id() == id)
                .findFirst();
        return Observation.createNotStarted("findStudentById", observationRegistry)
                .observe(() -> student);
    }
}
