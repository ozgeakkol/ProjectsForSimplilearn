package com.domain;

public class Developer {
    private String name;
    private String surname;
    private String email;

    public Developer(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nSurname: " + this.surname + "\nemail: " + this.email;
    }
}
