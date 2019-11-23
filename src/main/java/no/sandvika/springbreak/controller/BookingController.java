package no.sandvika.springbreak.controller;

import no.sandvika.springbreak.dto.BookingDto;
import no.sandvika.springbreak.dto.BookingsDto;
import no.sandvika.springbreak.service.BookableItemNotFoundException;
import no.sandvika.springbreak.service.BookingNotFoundException;
import no.sandvika.springbreak.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
        try {
            return bookingService.saveNewBookng(booking);
        } catch (BookableItemNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "bookable item not found", e);
        }
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
        bookingService.deleteBooking(id);
    }
}