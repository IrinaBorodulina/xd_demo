package com.xdsoft.demo.api;

import com.xdsoft.demo.reservation.entity.Reservation;

import com.xdsoft.demo.reservation.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserve")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/{id}")
    public Reservation get(@PathVariable("id") Integer id) {
        return bookingService.getById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Reservation> getAllByUserId(@PathVariable("userId") Integer userId) {
        return bookingService.getAllByUserId(userId);
    }

    @PostMapping()
    public Reservation add(@RequestBody Reservation reservation) {
        return bookingService.save(reservation);
    }
}
