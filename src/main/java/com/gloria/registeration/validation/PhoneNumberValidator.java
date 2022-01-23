package com.gloria.registeration.validation;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.gloria.registeration.dto.EventRegisterationRequest;
import com.gloria.registeration.service.EventRegisterationService;

import org.springframework.context.MessageSource;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    private final MessageSource  messageSource;
    private final EventRegisterationService service;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        
        return !service.isDuplicate(value);
    }

}
