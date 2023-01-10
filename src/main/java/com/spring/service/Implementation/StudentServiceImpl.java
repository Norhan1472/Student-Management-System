package com.spring.service.Implementation;

import com.spring.dao.StudentRepo;
import com.spring.model.Student;
import com.spring.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    @Override
    public Student addStudent(Student student) {

        return studentRepo.save(student);
    }
    @Override
    public Student getStudentById(long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Boolean deleteStudent(long id) {
        studentRepo.deleteById(id);
        return TRUE;
    }
}
