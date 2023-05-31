package com.xdemo.demo.reservation.repository;

import com.xdemo.demo.reservation.entity.Reservation;
import com.xdemo.demo.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    Optional<Reservation> findById(Integer id);

    List<Reservation> getByUserId(Integer userId);

    List<Reservation> findAllByUser(User user);
}

