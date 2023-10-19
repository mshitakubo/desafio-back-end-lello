package com.lello.challenge.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserUpdateDto {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
