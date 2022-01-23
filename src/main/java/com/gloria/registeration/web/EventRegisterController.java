package com.gloria.registeration.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gloria.registeration.domain.EventRegisteration;
import com.gloria.registeration.dto.EventRegisterationRequest;
import com.gloria.registeration.dto.EventRegisterationResponse;
import com.gloria.registeration.service.EventRegisterationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EventRegisterController {

    private final EventRegisterationService eventRegService;

    @GetMapping(value = "/registerations")
    public ResponseEntity<List<EventRegisteration>> getEventRegs() {
        return ResponseEntity.ok().body(eventRegService.findAll());
    }
    @PostMapping("/registeration")
    ResponseEntity<EventRegisterationResponse> register(@Valid @RequestBody EventRegisterationRequest request) {
        // persisting the user
//        return ResponseEntity.created(null);
        return ResponseEntity.ok().body(eventRegService.createRegisteration(request));

    }

}
