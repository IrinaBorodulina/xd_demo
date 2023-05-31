package com.xdemo.demo.reservation.service;


import com.xdemo.demo.reservation.crud.ReservationCRUD;
import com.xdemo.demo.reservation.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final ReservationCRUD reservationCRUD;

    @Autowired
    public BookingService(ReservationCRUD reservationCRUD) {
        this.reservationCRUD = reservationCRUD;
    }

    public Reservation save(Reservation reservation) {
        return reservationCRUD.save(reservation);
    }

    public Reservation getById(Integer id) {
        return reservationCRUD.getById(id);
    }

    public List<Reservation> getAllByUserId(Integer userId) {
        return reservationCRUD.getByUserId(userId);
    }
}

