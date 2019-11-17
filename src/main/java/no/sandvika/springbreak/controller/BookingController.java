package no.sandvika.springbreak.controller;

import no.sandvika.springbreak.domain.Booking;
import no.sandvika.springbreak.dto.BookingDto;
import no.sandvika.springbreak.service.BookableItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BookingController {

    private BookableItemService bookableItemService;

    public BookingController(BookableItemService bookableItemService) {
        this.bookableItemService = bookableItemService;
    }

    @GetMapping("/bookings")
    public List<BookingDto> getAllBookings() {
        return bookableItemService.getAllBookings();
    }

    @GetMapping("/bookings/{id}")
    public BookingDto getBooking(@PathVariable("id") Long id) throws BookingNotFoundException {
        return bookableItemService.getBooking(id);
    }

    @PostMapping("/bookings")
    public BookingDto postBooking(@RequestBody BookingDto booking) throws BookingConflictException {
        return bookableItemService.saveNewBookng(booking);
    }

    @PutMapping("/bookings/{id}")
    public BookingDto putMapping(@PathVariable("id") Long id, @RequestBody BookingDto booking) throws BookingNotFoundException {
        return bookableItemService.replaceBooking(id, booking);
    }

    @DeleteMapping("/bookings/{id}")
    public void geleteBooking(@PathVariable("id") Long id) throws BookingNotFoundException {
        bookableItemService.deleteBooking(id);
    }
}