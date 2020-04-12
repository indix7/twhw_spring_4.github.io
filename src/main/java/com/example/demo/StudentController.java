package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class StudentController {
    private ArrayList<Student> students = new ArrayList<>();
    private final StudentService studentService;

    public StudentController(StudentRepository studentRepository, StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PostMapping("/findStudentByName")
    public Student findStudentByName(@RequestBody String name) {
        return studentService.findStudentByName(name);
    }

    @PostMapping("/deleteStudentByName")
    public String deleteStudentByName(@RequestBody String name) {
        return studentService.deleteStudentByName(name);
    }





}
