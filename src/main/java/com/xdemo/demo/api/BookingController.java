package com.xdemo.demo.api;

import com.xdemo.demo.reservation.entity.Reservation;
import com.xdemo.demo.reservation.service.BookingService;
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
    public Reservation get(@PathVariable Integer id) {
        return bookingService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        bookingService.deleteById(id);
    }

    @GetMapping("/user/{userId}")
    public List<Reservation> getAllByUserId(@PathVariable Integer userId) {
        return bookingService.getByUserId(userId);
    }

    @PostMapping()
    public Reservation add(@RequestBody Reservation reservation) {
        return bookingService.save(reservation);
    }
}
