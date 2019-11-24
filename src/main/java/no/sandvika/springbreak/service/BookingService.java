package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.domain.Booking;
import no.sandvika.springbreak.domain.ItemLocation;
import no.sandvika.springbreak.repository.BookableItemRepository;
import no.sandvika.springbreak.repository.BookingRepository;
import no.sandvika.springbreak.repository.ItemLocationRepository;
import no.sandvika.springbreak.service.exceptions.BookingNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private BookableItemRepository bookableItemRepository;
    private ItemLocationRepository itemLocationRepository;

    public BookingService(BookingRepository bookingRepository,
                          BookableItemRepository bookableItemRepository,
                          ItemLocationRepository itemLocationRepository) {
        this.bookingRepository = bookingRepository;
        this.bookableItemRepository = bookableItemRepository;
        this.itemLocationRepository = itemLocationRepository;
    }

    @Transactional
    public void lagreNyLocation(String location) {
        itemLocationRepository.save(new ItemLocation(location));
    }

    @Transactional
    public void lagreBookableItems(String location) {
        ItemLocation lagretLocation = itemLocationRepository.findByLocationName(location);
        bookableItemRepository.save(lagBookableItemMedNavnOgLocation("Sjøelefanten", lagretLocation));
        bookableItemRepository.save(lagBookableItemMedNavnOgLocation("Printer", lagretLocation));
        bookableItemRepository.save(lagBookableItemMedNavnOgLocation("Partyløva", lagretLocation));
    }

    private static BookableItem lagBookableItemMedNavnOgLocation(String navn, ItemLocation itemLocation) {
        return new BookableItem(navn, itemLocation);
    }

    public Booking saveNewBookng(Booking Booking) {
        return bookingRepository.save(Booking);
    }

    public Booking getBooking(Long id) throws BookingNotFoundException {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            return booking.get();
        } else {
            throw new BookingNotFoundException();
        }
    }

    public Booking replaceBooking(Long id, Booking Booking) throws BookingNotFoundException {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            Booking updatedBooking = booking.get();
            updatedBooking.setBooker(Booking.getBooker());
            updatedBooking.setStart(Booking.getStart());
            updatedBooking.setEnd(Booking.getEnd());
            return bookingRepository.save(updatedBooking);
        } else {
            throw new BookingNotFoundException();
        }
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public List<Booking> getBookings(String itemName, String location, String booker) {
        return bookingRepository.findAll().stream()
                .filter(b -> itemName == null || b.getBookableItem().getItemName().equals(itemName))
                .filter(b -> location == null || b.getBookableItem().getItemLocation().getLocationName().equals(location))
                .filter(b -> booker == null || b.getBooker().equals(booker))
                .collect(Collectors.toList());
    }
}
