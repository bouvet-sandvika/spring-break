package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.Booking;
import no.sandvika.springbreak.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Transactional
    public Booking saveBooking(Booking booking) {

        return bookingRepository.save(booking);
    }

    public Booking getBooking(Long id) {
        return bookingRepository.findById(id).orElseThrow();
    }

    public Booking replaceBooking(Long id, Booking booking){
        bookingRepository.findById(id).orElseThrow();
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id)  {
        bookingRepository.findById(id).orElseThrow();
        bookingRepository.deleteById(id);
    }

    public List<Booking> getBookings(String itemName, String location, String booker) {
        return bookingRepository.findAll().stream()
                .filter(b -> itemName == null || b.getItem().getItemName().equals(itemName))
                .filter(b -> location == null || b.getItem().getItemLocation().getLocationName().equals(location))
                .filter(b -> booker == null || b.getBooker().equals(booker))
                .collect(Collectors.toList());
    }
}
