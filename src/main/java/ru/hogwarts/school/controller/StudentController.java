package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {
    private static final String STUDENT_NOT_FOUND = "Student not found with id: ";

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long createStudent(@RequestBody Student student) {
        return studentService.createStudent(student).getId();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, STUDENT_NOT_FOUND + id));
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping
    public Collection<Student> filterStudents(
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String house) {
        return studentService.filterStudents(age, house);
    }
}

