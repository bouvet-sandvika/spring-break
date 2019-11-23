package no.sandvika.springbreak.controller;

import no.sandvika.springbreak.dto.BookingDto;
import no.sandvika.springbreak.dto.BookingsDto;
import no.sandvika.springbreak.service.BookingService;
import no.sandvika.springbreak.service.BookingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings")
    public BookingsDto getAllBookings(@RequestParam(value = "location", required = false) String location,
                                      @RequestParam(value = "booker", required = false) String booker,
                                      @RequestParam(value = "name", required = false) String itemName) {
        return bookingService.getBookings(itemName, location, booker);
    }

    @PostMapping("/bookings")
    public BookingDto postBooking(@RequestBody BookingDto booking) {
        return bookingService.saveNewBookng(booking);
    }

    @GetMapping("/bookings/{id}")
    public BookingDto getBooking(@PathVariable("id") Long id) {
        try {
            return bookingService.getBooking(id);
        } catch (BookingNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "booking not found", e);
        }
    }

    @PutMapping("/bookings/{id}")
    public BookingDto putMapping(@PathVariable("id") Long id, @RequestBody BookingDto booking) throws BookingNotFoundException {
        return bookingService.replaceBooking(id, booking);
    }

    @DeleteMapping("/bookings/{id}")
    public void geleteBooking(@PathVariable("id") Long id) {
        try {
            bookingService.deleteBooking(id);
        } catch (BookingNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "booking not found", e);
        }
    }
}