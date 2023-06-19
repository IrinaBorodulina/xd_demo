package com.xdemo.demo.reservation.service;


import com.xdemo.demo.reservation.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationCrudService reservationCrudService;

    @Autowired
    public ReservationService(ReservationCrudService reservationCrudService) {
        this.reservationCrudService = reservationCrudService;
    }

    public Reservation getDtoById(Integer id) {
        return reservationCrudService.getById(id);
    }

    public List<Reservation> getDtoByUserId(Integer id) {
        return reservationCrudService.getByUserId(id);
    }

    public Reservation saveDto(Reservation reservation) {
        return reservationCrudService.save(reservation);
    }

    public void delete(Integer id) {
        reservationCrudService.deleteById(id);
    }

}

