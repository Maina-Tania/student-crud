package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudents (Student student){
        return studentRepository.save(student);
    }
    public List<Student>  getStudents (){
        return  studentRepository.findAll();
    }
    public Student updateStudent(Student student, Long id) {
        Optional<Student> existingStudentOptional = studentRepository.findById(id);

        if (existingStudentOptional.isPresent()) {
            Student existingStudent = existingStudentOptional.get();
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setDob(student.getDob());

            return studentRepository.save(existingStudent);
        } else {
            throw new NoSuchElementException("Student with ID " + id + " not found");
        }
    }
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student with ID " + id + " not found"));
    }

    public String deleteStudent(Long id){
        studentRepository.deleteById(id);

        return "Student removed " + id;
    }
}
