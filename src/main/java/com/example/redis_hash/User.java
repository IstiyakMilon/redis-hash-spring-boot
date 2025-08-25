package com.example.redis_hash;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class User implements Serializable {

    private String id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String gender;

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(String id, String name, int age, String email, String phone, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
