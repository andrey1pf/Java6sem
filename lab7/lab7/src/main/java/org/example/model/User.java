package org.example.model;

public class User {
    private int id;
    private String name;
    private String email;

    public User(int id, String name, String email) {
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public int getId() {
        return id;
    }

    // конструкторы, геттеры и сеттеры
}
