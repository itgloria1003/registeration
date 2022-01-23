package com.gloria.registeration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class EventRegisterationResponse extends EventRegisterationRequest{
    private Long id;

}