package ru.hogwarts.school.model;

import java.util.Objects;

public class Student {
    private Long id;
    private String name;
    private int age;
    private String house;
    private String pet;
    private boolean prefect;

    public Student(Long id, String name, int age, String house, String pet, boolean prefect) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.house = house;
        this.pet = pet;
        this.prefect = prefect;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public boolean isPrefect() {
        return prefect;
    }

    public void setPrefect(boolean prefect) {
        this.prefect = prefect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                prefect == student.prefect &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(house, student.house) &&
                Objects.equals(pet, student.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, house, pet, prefect);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", house='" + house + '\'' +
                ", pet='" + pet + '\'' +
                ", prefect=" + prefect +
                '}';
    }
}