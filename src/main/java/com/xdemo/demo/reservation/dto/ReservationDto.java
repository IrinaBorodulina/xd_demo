package com.xdemo.demo.reservation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xdemo.demo.user.dto.UserDto;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
public class ReservationDto {

    private Integer id;
    @JsonInclude(NON_NULL)
    private UserDto user;
    private String reservationInfo;
    private Double price;

}
