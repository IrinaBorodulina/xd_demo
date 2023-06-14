package com.xdemo.demo.reservation.service;


import com.xdemo.demo.exc.NotFound;
import com.xdemo.demo.reservation.entity.Reservation;
import com.xdemo.demo.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationCrudService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationCrudService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation getById(Integer id) {
        return reservationRepository.findById(id).orElseThrow(NotFound::new);
    }

    public List<Reservation> getByUserId(Integer id) {
        return reservationRepository.getByUserId(id);
    }

    public int countByUserId(Integer id) {
        return reservationRepository.countReservationByUserId(id);
    }

    public void deleteById(Integer id) {
        reservationRepository.deleteById(id);
    }

}

