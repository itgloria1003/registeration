package com.gloria.registeration.service;

import java.util.List;

import javax.validation.Valid;

import com.gloria.registeration.domain.EventRegisteration;
import com.gloria.registeration.dto.EventRegisterationRequest;
import com.gloria.registeration.dto.EventRegisterationResponse;

public interface EventRegisterationService {
    public EventRegisteration saveRegisteration(EventRegisteration reg);

    public List<EventRegisteration> findAll();

    public boolean isDuplicate(String userPhoneNumber);

	public EventRegisterationResponse createRegisteration(@Valid EventRegisterationRequest request);
}
