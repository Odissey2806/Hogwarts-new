package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private long lastId = 0;

    public Student createStudent(Student student) {
        student.setId(++lastId);
        students.put(lastId, student);
        return student;
    }

    public Optional<Student> getStudentById(Long id) {
        return Optional.ofNullable(students.get(id));
    }

    public Student updateStudent(Long id, Student student) {
        if (!students.containsKey(id)) {
            throw new NoSuchElementException("Student not found with id: " + id);
        }
        student.setId(id);
        students.put(id, student);
        return student;
    }

    public void deleteStudent(Long id) {
        if (!students.containsKey(id)) {
            throw new NoSuchElementException("Student not found with id: " + id);
        }
        students.remove(id);
    }

    public Collection<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public Collection<Student> filterStudents(Integer age, String house) {
        return students.values().stream()
                .filter(student -> age == null || student.getAge() == age)
                .filter(student -> house == null || student.getHouse().equalsIgnoreCase(house))
                .collect(Collectors.toList());
    }
}