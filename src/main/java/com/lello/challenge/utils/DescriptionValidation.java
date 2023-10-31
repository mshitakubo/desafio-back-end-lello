package com.lello.challenge.utils;

import com.lello.challenge.model.exception.ApiException;
import com.lello.challenge.service.user.exceptions.InvalidDescriptionException;
import org.springframework.http.HttpStatus;

public class DescriptionValidation {
    private DescriptionValidation() {
    }

    public static boolean isValidDescription(String description) {
        boolean descriptionIsValid = false;
        int descriptionLength = description.length();

        if(descriptionLength + 1 > 400){
            throw new InvalidDescriptionException("A descrição não pode conter mais de 400 caracteres.");
        }else {
            descriptionIsValid = true;
        }

        return descriptionIsValid;
    }

}
