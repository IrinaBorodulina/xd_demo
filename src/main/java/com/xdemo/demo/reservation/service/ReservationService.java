package com.xdemo.demo.reservation.service;


import com.xdemo.demo.reservation.dto.ReservationDto;
import com.xdemo.demo.reservation.mapper.ReservationListMapper;
import com.xdemo.demo.reservation.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationMapper reservationMapper;
    private final ReservationListMapper reservationListMapper;
    private final ReservationCrudService reservationCrudService;

    @Autowired
    public ReservationService(ReservationMapper reservationMapper,
                              ReservationListMapper reservationListMapper,
                              ReservationCrudService reservationCrudService) {
        this.reservationMapper = reservationMapper;
        this.reservationListMapper = reservationListMapper;
        this.reservationCrudService = reservationCrudService;
    }

    public ReservationDto getDtoById(Integer id) {
        return reservationMapper.toDto(reservationCrudService.getById(id));
    }

    public List<ReservationDto> getDtoByUserId(Integer id) {
        return reservationListMapper.toDtoList(reservationCrudService.getByUserId(id));
    }

    public ReservationDto saveDto(ReservationDto reservation) {
        return reservationMapper.toDto(reservationCrudService.save(reservationMapper.toEntity(reservation)));
    }

    public void delete(Integer id) {
        reservationCrudService.deleteById(id);
    }

}

