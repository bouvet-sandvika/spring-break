package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.domain.ItemLocation;
import no.sandvika.springbreak.dto.BookingDto;
import no.sandvika.springbreak.dto.BookingsDto;
import no.sandvika.springbreak.repository.BookableItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {

    private BookableItemRepository bookableItemRepository;

    public BookingService(BookableItemRepository bookableItemRepository) {
        this.bookableItemRepository = bookableItemRepository;
    }

    @Transactional
    public void lagreBookableItems() {
        ItemLocation sandvikaLocation = new ItemLocation("Sandvika");
        bookableItemRepository.save(lagBookableItemMedNavnOgLocation("Sjøelefanten",sandvikaLocation));
        bookableItemRepository.save(lagBookableItemMedNavnOgLocation("Printer", sandvikaLocation));
        bookableItemRepository.save(lagBookableItemMedNavnOgLocation("Partyløva", sandvikaLocation));
    }

    private static BookableItem lagBookableItemMedNavnOgLocation(String navn, ItemLocation itemLocation) {
        return new BookableItem(navn, itemLocation);
    }

    public BookingDto saveNewBookng(BookingDto bookingDto) throws BookableItemNotFoundException {
        return null;
    }

    public BookingDto getBooking(Long id) throws BookingNotFoundException {
        return null;
    }

    public BookingDto replaceBooking(Long id, BookingDto bookingDto) throws BookingNotFoundException {
        return null;
    }

    public void deleteBooking(Long id) {
    }

    public BookingsDto getBookings(String itemName, String location, String booker) {
        return null;
    }
}
