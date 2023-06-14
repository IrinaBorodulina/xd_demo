package com.xdemo.demo.user.dto;

import com.xdemo.demo.reservation.dto.ReservationDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private Integer id;
    private Integer birthYear;
    private List<ReservationDto> reservations = new ArrayList<>();

}
