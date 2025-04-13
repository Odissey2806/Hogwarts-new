package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FacultyService {
    private final Map<Long, Faculty> faculties = new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        faculties.put(lastId, faculty);
        return faculty;
    }

    public Optional<Faculty> getFacultyById(Long id) {
        return Optional.ofNullable(faculties.get(id));
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        if (!faculties.containsKey(id)) {
            throw new NoSuchElementException("Faculty not found with id: " + id);
        }
        faculty.setId(id);
        faculties.put(id, faculty);
        return faculty;
    }

    public void deleteFaculty(Long id) {
        if (!faculties.containsKey(id)) {
            throw new NoSuchElementException("Faculty not found with id: " + id);
        }
        faculties.remove(id);
    }

    public Collection<Faculty> getAllFaculties() {
        return new ArrayList<>(faculties.values());
    }

    public Collection<Faculty> filterFaculties(String color, String founder) {
        return faculties.values().stream()
                .filter(faculty -> color == null || faculty.getColor().equalsIgnoreCase(color))
                .filter(faculty -> founder == null || faculty.getFounder().equalsIgnoreCase(founder))
                .collect(Collectors.toList());
    }
}