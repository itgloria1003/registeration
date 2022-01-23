package com.gloria.registeration.repo;

import java.util.List;

import com.gloria.registeration.domain.EventRegisteration;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRegisterationRepo extends JpaRepository<EventRegisteration, Long> {
    // EventRegisteration findByUserPhoneNumber<EventRegisteration>(String
    // userPhoneNumber);

    public List<EventRegisteration> findByUserPhoneNumber(String userPhoneNumber);
}
