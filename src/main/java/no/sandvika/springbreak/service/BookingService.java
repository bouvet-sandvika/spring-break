package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.Booking;
import no.sandvika.springbreak.dto.BookingDto;
import no.sandvika.springbreak.dto.BookingsDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private DtoMapperService dtoMapperService;
    private Map<Long, Booking> bookings;

    public BookingService(DtoMapperService dtoMapperService) {
        this.dtoMapperService = dtoMapperService;
        this.bookings = new HashMap<>();
    }

    public BookingDto saveNewBookng(BookingDto bookingDto) {
        Long lastId = bookings.keySet().stream()
                .sorted()
                .reduce((first, second) -> second)
                .orElse(null);
        Long nextId = (lastId != null) ? lastId + 1 : 1;
        bookings.put(nextId, dtoMapperService.toBooking(nextId, bookingDto));
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
        bookings.put(id, dtoMapperService.toBooking(id, bookingDto));
        return bookingDto;
    }

    public void deleteBooking(Long id) throws BookingNotFoundException {
        Booking booking = bookings.get(id);
        if (booking == null) {
            throw new BookingNotFoundException();
        }
        bookings.remove(id);
    }

    public BookingsDto getBookings(String itemName, String location, String booker) {
        List<BookingDto> bookings = this.bookings.values().stream()
                .filter(b -> itemName == null || b.getItem().getItemName().equals(itemName))
                .filter(b -> location == null || b.getItem().getItemLocation().getLocationName().equals(location))
                .filter(b -> booker == null || b.getBooker().equals(booker))
                .map(b -> dtoMapperService.toBookingDto(b))
                .collect(Collectors.toList());
        return new BookingsDto(bookings);
    }
}
