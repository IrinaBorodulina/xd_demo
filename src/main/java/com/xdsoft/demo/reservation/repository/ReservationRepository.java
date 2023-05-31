package com.xdsoft.demo.reservation.repository;

import com.xdsoft.demo.reservation.entity.Reservation;
import com.xdsoft.demo.user.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    Optional<Reservation> findById(Integer id);

    List<Reservation> getByUserId(Integer userId);

    List<Reservation> findAllByUser(User user);
}

