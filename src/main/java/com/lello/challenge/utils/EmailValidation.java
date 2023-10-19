package com.lello.challenge.utils;

import com.lello.challenge.model.exception.ApiException;
import org.springframework.http.HttpStatus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidation {

    private EmailValidation() {
    }

    public static boolean isValidEmailAddressRegex(String email) {
        boolean isEmailValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailValid = true;
            }else {
                throw new ApiException(HttpStatus.BAD_REQUEST, "E-mail inválido.");
            }
        }else {
            throw new ApiException(HttpStatus.BAD_REQUEST, "E-mail inválido.");
        }
        return isEmailValid;
    }

}
