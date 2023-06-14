package com.xdemo.demo.api;

import com.xdemo.demo.reservation.dto.ReservationDto;
import com.xdemo.demo.reservation.service.ReservationService;
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

    @GetMapping("/{id}")
    public ReservationDto get(@PathVariable Integer id) {
        return reservationService.getDtoById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        reservationService.delete(id);
    }

    @GetMapping("/user/{userId}")
    public List<ReservationDto> getAllByUserId(@PathVariable Integer userId) {
        return reservationService.getDtoByUserId(userId);
    }

    @PostMapping()
    public ReservationDto add(@RequestBody ReservationDto reservation) {
        return reservationService.saveDto(reservation);
    }
}
