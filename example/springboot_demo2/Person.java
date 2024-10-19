package org.example.springboot_demo2;

public class Person {
    public String name;
    public int id;
    public String password;

    public Person(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "name : " + name + " id : " + id + " password : " + password;
    }
}
