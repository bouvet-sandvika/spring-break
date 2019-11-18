package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.Booking;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private Map<Long, Booking> bookings;

    public BookingService() {
        this.bookings = new HashMap<>();
    }

    public Booking saveBooking(Booking booking) {
        bookings.put(booking.getId(), booking);
        return booking;
    }

    public Booking getBooking(Long id) throws BookingNotFoundException {
        Booking booking = bookings.get(id);
        if (booking == null) {
            throw new BookingNotFoundException();
        }
        return booking;
    }

    public Booking replaceBooking(Long id, Booking booking) throws BookingNotFoundException {
        if (bookings.get(id) == null) {
            throw new BookingNotFoundException();
        }
        bookings.put(id, booking);
        return booking;
    }

    public void deleteBooking(Long id) throws BookingNotFoundException {
        Booking booking = bookings.get(id);
        if (booking == null) {
            throw new BookingNotFoundException();
        }
        bookings.remove(id);
    }

    public List<Booking> getBookings(String itemName, String location, String booker) {
        return this.bookings.values().stream()
                .filter(b -> itemName == null || b.getItem().getItemName().equals(itemName))
                .filter(b -> location == null || b.getItem().getItemLocation().getLocationName().equals(location))
                .filter(b -> booker == null || b.getBooker().equals(booker))
                .collect(Collectors.toList());
    }
}
