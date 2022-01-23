package com.gloria.registeration.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.gloria.registeration.dto.EventRegisterationRequest;

import org.springframework.context.MessageSource;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    private final MessageSource  messageSource;
    private final Event
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        return true;
    }

}
