package com.xdemo.demo.reservation.service;


import com.xdemo.demo.exc.NotFound;
import com.xdemo.demo.reservation.entity.Reservation;
import com.xdemo.demo.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public BookingService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation getById(Integer id) {
        return reservationRepository.findById(id).orElseThrow(NotFound::new);
    }

    public void deleteById(Integer id) {
        reservationRepository.deleteById(id);
    }

    public List<Reservation> getByUserId(Integer id) {
        return reservationRepository.getByUserId(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

}

