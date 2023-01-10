package com.spring.service;

import com.spring.model.Student;

import java.util.List;

public interface StudentService {
    public Student addStudent(Student student);
    public Student getStudentById(long id);
    public List<Student> getAllStudents();
    public Student updateStudent(Student student);
    public Boolean deleteStudent(long id);
}
