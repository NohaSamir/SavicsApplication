package com.example.savicsapplication.data.source;

public class Patient {
    private String fullName;
    private int age;
    private String email;
    private char gender;

    public Patient(String fullName, int age, String email, char gender) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
