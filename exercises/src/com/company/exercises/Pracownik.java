package com.company.exercises;

public class Pracownik {
    private String name;
    private String surname;
    private int age;

    public Pracownik(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + age + ")";
    }
}
