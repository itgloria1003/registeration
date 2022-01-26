package com.gloria.registeration.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.logging.log4j.util.Strings;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.gloria.registeration.domain.EventRegisteration;
import com.gloria.registeration.dto.EventRegisterationRequest;
import com.gloria.registeration.dto.EventRegisterationResponse;
import com.gloria.registeration.repo.EventRegisterationRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EventRegisterationServiceImpl implements EventRegisterationService {

	private final EventRegisterationRepo eventRegRepo;

	private final ModelMapper modelMapper;

	@Override
	public EventRegisteration saveRegisteration(EventRegisteration reg) {
		log.info("Save user {} to database", reg.getUserFirstName());
		return eventRegRepo.save(reg);
	}

	@Override
	public List<EventRegisteration> findAll() {
		return eventRegRepo.findAll();
	}

	@Override
	public EventRegisterationResponse createRegisteration(@Valid EventRegisterationRequest request) {
		// TODO Auto-generated method stub
		EventRegisteration entity = modelMapper.map(request, EventRegisteration.class);
		 EventRegisteration save = eventRegRepo.save(entity);
	
		 EventRegisterationResponse response = modelMapper.map(request, EventRegisterationResponse.class
				 );
		 response.setId(save.getId());
		 return response;
	}

	@Override
	public boolean isDuplicate(String userPhoneNumber) {
		if (Strings.isNotEmpty(userPhoneNumber)){
			List<EventRegisteration> findByUserPhoneNumber = eventRegRepo.findByUserPhoneNumber(userPhoneNumber);
			return findByUserPhoneNumber!=null && findByUserPhoneNumber.size()>0; 
		
		} else {
			return false; 
		}
		}

}
