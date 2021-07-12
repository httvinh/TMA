package tma.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tma.api.repository.StudentRepository;
import tma.api.entity.Student;

@RestController
@RequestMapping("/student-management")
public class StudentController {
    
    @Autowired
    private final StudentRepository studentRepository;

    StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/list") 
    public List<Student> studentList() {
        return studentRepository.findAll();
    }

    @GetMapping("/id-{studentId}") 
    public Student findStudent(@PathVariable(name = "studentId") Integer studentId){
        return studentRepository.findById(studentId).get();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody Student newStudent) {
        studentRepository.save(newStudent);
        return ResponseEntity.ok().body(newStudent);
    }

    @PostMapping("/update/{studentId}")
    public Student updateStudent(@PathVariable(name = "studentId") Integer studentId,
                                 @RequestBody Student newStudent) {

        //Student student = studentRepository.findById(studentId).get();
        //student.setName(newStudent.getName());
        //student.setGender(newStudent.getGender());
        //student.setYearBirth(newStudent.getYearBirth());
        //student.setSubjects(newStudent.getSubjects());
        //return studentRepository.save(student);
        
        newStudent.setId(studentId);
        return studentRepository.save(newStudent);
    }

    @DeleteMapping("/delete/id-{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable(name = "studentId") Integer studentId) {
        studentRepository.deleteById(studentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list/max-gpa") 
    public List<Student> maxGpaList() {
        return studentRepository.findMaxGPAList();
    }

    @GetMapping("/list/min-gpa") 
    public List<Student> minGpaList() {
        return studentRepository.findMinGPAList();
    }
}
