package com.umc.umc.global.validation.validator;

import com.umc.umc.global.apiPayload.code.GeneralErrorCode;
import com.umc.umc.global.validation.annotation.CheckPage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {
    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || value < 1) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(GeneralErrorCode.PAGE_NOT_VALID.toString())
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
