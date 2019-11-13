package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.Booking;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookableItemService {

    private List<Booking> bookings;

    public BookableItemService() {
        this.bookings = new ArrayList<>();
    }

    public Booking saveNewBookng(Booking booking) {
        bookings.add(booking);
        return booking;
    }

    public Booking getBooking(Long id) {
        return bookings.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
