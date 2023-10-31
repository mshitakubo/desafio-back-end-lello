package com.lello.challenge.utils;

import com.lello.challenge.service.user.exceptions.InvalidEmailException;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
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
            } else {
                throw new InvalidEmailException("E-mail inválido.");
            }
        } else {
            throw new InvalidEmailException("E-mail inválido.");
        }
        return isEmailValid;
    }

}
