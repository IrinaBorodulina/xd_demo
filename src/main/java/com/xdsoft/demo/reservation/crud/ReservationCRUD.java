package com.xdsoft.demo.reservation.crud;

import com.xdsoft.demo.reservation.entity.Reservation;
import com.xdsoft.demo.reservation.repository.ReservationRepository;
import com.xdsoft.demo.exc.NotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationCRUD {

    private final ReservationRepository reservationRepository;

    public ReservationCRUD(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation getById(Integer id) {
        return reservationRepository.findById(id).orElseThrow(NotFound::new);
    }

    public List<Reservation> getByUserId(Integer id) {
        return reservationRepository.getByUserId(id);
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
