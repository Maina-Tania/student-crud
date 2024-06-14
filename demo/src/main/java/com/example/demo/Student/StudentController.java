package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping("add")
    public Student addStudents(@RequestBody Student student){
        return studentService.addStudents(student);
    }

    @GetMapping("all-students")
    public List <Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable Long id){
        return studentService.updateStudent(student, id);
    }
    @DeleteMapping("delete/{id}")
    public String deleteStudent(@PathVariable Long id){

        return studentService.deleteStudent(id);
    }
}
