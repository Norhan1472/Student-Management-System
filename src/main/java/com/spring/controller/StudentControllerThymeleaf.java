package com.spring.controller;

import com.spring.model.Student;
import com.spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class StudentControllerThymeleaf {
    private final StudentService studentService;
    @GetMapping("/getStudents")
    public String getStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }
    //students/new
    @GetMapping("/formStudents")
    public String createStudentsForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student_form";
    }
    @PostMapping("/formStudents")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/api/getStudents";
    }
    @GetMapping("/updateFormStudent/{id}")
    public String updateStudentsForm(@PathVariable("id") long id,Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "update_student_form";
    }
    @PostMapping("/updateStudents/{id}")
    public String updateStudent(@ModelAttribute("student") Student student,
                                @PathVariable("id") Long id){

        System.out.println(student.getId());
        student.setId(id);
        studentService.updateStudent(student);
        return "redirect:/api/getStudents";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "redirect:/api/getStudents";
    }
}
