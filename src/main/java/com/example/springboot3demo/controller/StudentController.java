package com.example.springboot3demo.controller;

import com.example.springboot3demo.model.Student;
import com.example.springboot3demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("add")
    public List<Student> addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("fetch")
    public List<Student> fetchStudent() {
        return studentService.fetchAllStudent();
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.findStudentById(id).orElseThrow(RuntimeException::new);
    }
}
