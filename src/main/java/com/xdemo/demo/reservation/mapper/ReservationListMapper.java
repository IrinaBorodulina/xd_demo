package com.xdemo.demo.reservation.mapper;

import com.xdemo.demo.reservation.dto.ReservationDto;
import com.xdemo.demo.reservation.entity.Reservation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ReservationMapper.class})
public interface ReservationListMapper {

    List<Reservation> toEntityList(List<ReservationDto> model);

    List<ReservationDto> toDtoList(List<Reservation> model);

}
