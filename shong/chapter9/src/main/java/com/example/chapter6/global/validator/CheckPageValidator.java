package com.example.chapter6.global.validator;

import com.example.chapter6.global.annotation.CheckPage;
import com.example.chapter6.global.apiPayload.code.GeneralErrorCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || value < 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(GeneralErrorCode.BAD_REQUEST.getMessage())
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
