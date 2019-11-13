package no.sandvika.springbreak.controller;

import no.sandvika.springbreak.domain.Booking;
import no.sandvika.springbreak.service.BookableItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BookingController {

    private BookableItemService bookableItemService;

    public BookingController(BookableItemService bookableItemService) {
        this.bookableItemService = bookableItemService;
    }

    @PostMapping("/bookings")
    public Booking postBooking(@RequestBody Booking booking) {
        return bookableItemService.saveNewBookng(booking);
    }

    @GetMapping("/bookings/{id}")
    public Booking getBooking(@PathVariable("id") Long id){
        Booking booking = bookableItemService.getBooking(id);
        if (booking == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        return booking;
    }
}