package com.xdemo.demo.reservation.mapper;

import com.xdemo.demo.reservation.dto.ReservationDto;
import com.xdemo.demo.reservation.entity.Reservation;
import com.xdemo.demo.reservation.service.ReservationCrudService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ReservationMapper {

    private static final Double FIXED_PRICE = 1000.0;

    @Autowired
    private ReservationCrudService reservationCrudService;

    @Mapping(source = "reservationInfo", target = "info")
    public abstract Reservation toEntity(ReservationDto model);

    @Mapping(source = "info", target = "reservationInfo")
    @Mapping(source = "user", target = "user", ignore = true)
    public abstract ReservationDto toDto(Reservation model);

    @AfterMapping
    protected void addPrice(Reservation entity, @MappingTarget ReservationDto dto) {
        int countOfUserReservations = reservationCrudService.countByUserId(entity.getUser().getId());
        float individualFactor = Math.min(countOfUserReservations * 0.1f, 0.3f); // max sale 30%
        if (entity.getInfo().equals("promo")) individualFactor = 1; // if info==promo sale 100%
        dto.setPrice(FIXED_PRICE - FIXED_PRICE * individualFactor);
    }

}
