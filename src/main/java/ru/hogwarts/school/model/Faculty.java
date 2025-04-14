package ru.hogwarts.school.model;

import java.util.Objects;

public class Faculty {
    private Long id;
    private String name;
    private String color;
    private String founder;
    private int foundingYear;
    private int numberOfStudents;

    public Faculty(Long id, String name, String color, String founder, int foundingYear, int numberOfStudents) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.founder = founder;
        this.foundingYear = foundingYear;
        this.numberOfStudents = numberOfStudents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public int getFoundingYear() {
        return foundingYear;
    }

    public void setFoundingYear(int foundingYear) {
        this.foundingYear = foundingYear;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return foundingYear == faculty.foundingYear &&
                numberOfStudents == faculty.numberOfStudents &&
                Objects.equals(id, faculty.id) &&
                Objects.equals(name, faculty.name) &&
                Objects.equals(color, faculty.color) &&
                Objects.equals(founder, faculty.founder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color, founder, foundingYear, numberOfStudents);
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", founder='" + founder + '\'' +
                ", foundingYear=" + foundingYear +
                ", numberOfStudents=" + numberOfStudents +
                '}';
    }
}


