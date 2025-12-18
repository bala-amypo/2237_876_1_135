package com.example.demo.entiry;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

    @Column(unique = true)
    private String email;
    private String password;
    private String role;
    private LocalDate createdAt;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this. = fullName;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }

    public LocalDate getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDate createdAt){
        this.createdAt = createdAt;
    }

    public User(String fullName,String email,String password,String role){
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User (){}
}