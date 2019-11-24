package no.sandvika.springbreak.web.controller;

import no.sandvika.springbreak.service.BookingService;
import no.sandvika.springbreak.service.exceptions.BookingNotFoundException;
import no.sandvika.springbreak.web.model.BookingModel;
import no.sandvika.springbreak.web.modelAssembler.BookingModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
public class BookingController {

    private BookingService bookingService;
    private BookingModelAssembler bookingModelAssembler;

    public BookingController(BookingService bookingService, BookingModelAssembler bookingModelAssembler) {
        this.bookingService = bookingService;
        this.bookingModelAssembler = bookingModelAssembler;
    }

    @GetMapping("/bookings")
    public CollectionModel<BookingModel> getBookings(@RequestParam(value = "location", required = false) String location,
                                                     @RequestParam(value = "booker", required = false) String booker,
                                                     @RequestParam(value = "name", required = false) String itemName) {
        return bookingModelAssembler.toCollectionModel(bookingService.getBookings(itemName, location, booker));
    }

    @PostMapping("/bookings")
    public BookingModel putMapping(@RequestBody BookingModel booking) {
        return bookingModelAssembler.toModel(bookingService.saveNewBookng(bookingModelAssembler.toEntity(booking)));
    }

    @PutMapping("/bookings/{id}")
    public BookingModel putMapping(@PathVariable("id") Long id, @RequestBody BookingModel booking) {
        try {
            return bookingModelAssembler.toModel(bookingService.replaceBooking(id, bookingModelAssembler.toEntity(booking)));
        } catch (BookingNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "booking not found", e);
        }
    }

    @GetMapping("/bookings/{id}")
    public BookingModel getBooking(@PathVariable("id") Long id) {
        try {
            return bookingModelAssembler.toModel(bookingService.getBooking(id));
        } catch (BookingNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "booking not found", e);
        }
    }

    @DeleteMapping("/bookings/{id}")
    public void geleteBooking(@PathVariable("id") Long id) {
        try {
            bookingService.deleteBooking(id);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "booking not found", e);
        }
    }
}