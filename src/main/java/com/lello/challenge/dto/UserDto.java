package com.lello.challenge.dto;

import javax.validation.constraints.*;
import java.util.UUID;

public class UserDto {

    private UUID uuid;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
//    @Size(max = 400, message = "A descrição não pode conter mais de 400 caracteres")
    private String description;

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
