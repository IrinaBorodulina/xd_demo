package com.xdemo.demo.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.xdemo.demo.reservation.entity.Reservation;
import com.xdemo.demo.reservation.service.ReservationService;
import com.xdemo.demo.utils.Views;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserve")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @JsonView(Views.Response.class)
    @GetMapping("/{id}")
    public Reservation get(@PathVariable Integer id) {
        return reservationService.getDtoById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        reservationService.delete(id);
    }

    @JsonView(Views.Response.class)
    @GetMapping("/user/{userId}")
    public List<Reservation> getAllByUserId(@PathVariable Integer userId) {
        return reservationService.getDtoByUserId(userId);
    }

    @JsonView(Views.Response.class)
    @PostMapping()
    public Reservation add(@RequestBody
                           @JsonView(Views.Request.class) Reservation reservation) {
        return reservationService.saveDto(reservation);
    }
}
