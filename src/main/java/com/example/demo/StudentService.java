package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private ArrayList<Student> students = new ArrayList<>();

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String addStudent(Student student) {
        if (students.contains(student)) {
            return "姓名重复";
        } else {
            students.add(student);
            studentRepository.realSave(student.getName(), student.getGender(), student.getClassmate());
            return "添加成功";
        }
    }

    public List<Student> getAllStudent() {
        LinkedList<Student> studentLinkedList = new LinkedList<>();
        studentRepository.findAll().forEach(studentLinkedList::add);
        return studentLinkedList;
    }

    public Student findStudentByName(String name) {
        return studentRepository.findById(name).orElse(null);
    }

    public String deleteStudentByName(String name) {
        if (students.removeIf(student -> student.getName().equals(name))){
            studentRepository.deleteById(name);
            return "删除成功";
        } else {
            return "删除失败";
        }

    }


}
