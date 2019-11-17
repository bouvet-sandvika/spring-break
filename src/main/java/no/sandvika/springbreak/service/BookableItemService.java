package no.sandvika.springbreak.service;

import no.sandvika.springbreak.controller.BookingConflictException;
import no.sandvika.springbreak.controller.BookingNotFoundException;
import no.sandvika.springbreak.domain.Booking;
import no.sandvika.springbreak.dto.BookingDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookableItemService {

    private DtoMapperService dtoMapperService;
    private Map<Long, Booking> bookings;

    public BookableItemService(DtoMapperService dtoMapperService) {
        this.dtoMapperService = dtoMapperService;
        this.bookings = new HashMap<>();
    }

    public BookingDto saveNewBookng(BookingDto bookingDto) throws BookingConflictException {
        if (bookings.get(bookingDto.getId()) != null) {
            throw new BookingConflictException();
        }
        bookings.put(bookingDto.getId(), dtoMapperService.toBooking(bookingDto));
        return bookingDto;
    }

    public BookingDto getBooking(Long id) throws BookingNotFoundException {
        Booking booking = bookings.get(id);
        if (booking == null) {
            throw new BookingNotFoundException();
        }
        return dtoMapperService.toBookingDto(booking);
    }

    public BookingDto replaceBooking(Long id, BookingDto bookingDto) throws BookingNotFoundException {
        Booking booking = bookings.get(id);
        if (booking == null) {
            throw new BookingNotFoundException();
        }
        bookings.put(id, dtoMapperService.toBooking(bookingDto));
        return bookingDto;
    }

    public void deleteBooking(Long id) throws BookingNotFoundException {
        Booking booking = bookings.get(id);
        if (booking == null) {
            throw new BookingNotFoundException();
        }
        bookings.remove(id);
    }

    public List<BookingDto> getAllBookings() {
        return bookings.values().stream()
                .map(b -> dtoMapperService.toBookingDto(b))
                .collect(Collectors.toList());
    }
}
