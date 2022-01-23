package com.gloria.registeration.dto;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import com.gloria.registeration.validation.ValidPhoneNumber;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter 

public class EventRegisterationRequest {

    private String eventCode;
    private String userFirstName;
    private String userLastName;
    private Integer age;
    @Pattern(regexp = "^$|[\\d]{8}$" , message = "Phone number should of 8 digits")
    @ValidPhoneNumber
    private String userPhoneNumber;

}
