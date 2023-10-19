package com.lello.challenge.model;


import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name= "users")
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    @Column(length = 511)
    private String description;

    @NotNull
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public UserModel(@NotNull String name, @NotNull String email, @NotNull String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UserModel(Long id, @NotNull String name, @NotNull String email, @NotNull String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UserModel() {
    }
}
