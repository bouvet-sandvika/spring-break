package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.domain.Booking;
import no.sandvika.springbreak.domain.ItemLocation;
import no.sandvika.springbreak.domain.ItemResource;
import no.sandvika.springbreak.repository.BookableItemRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookableItemServiceImpl implements BookableItemService {

    private final BookableItemRepository bookableItemRepository;

    public BookableItemServiceImpl(BookableItemRepository bookableItemRepository) {
        this.bookableItemRepository = bookableItemRepository;

        BookableItem printer = createItem("Printer", "Sandvika");
        addResourceToItem("Grønt blekk", 1.0, printer);
        addResourceToItem("Blått blekk", 2.0, printer);
        addBookingToItem("KES", LocalDate.now(), LocalDate.now().plusDays(5), printer);

        BookableItem bil = createItem("Bil", "Kongsberg");
        addResourceToItem("Koppholder", 1.0, bil);
        addResourceToItem("Doerer", 4.0, bil);
        addBookingToItem("ULE", LocalDate.now(), LocalDate.now().plusDays(10), bil);
    }

    private BookableItem createItem(String name, String location) {
        ItemLocation minLocation = new ItemLocation(location);
        BookableItem bookableItem = new BookableItem(name);
        bookableItem.setItemLocation(minLocation);
        return bookableItemRepository.save(bookableItem);
    }

    private void addResourceToItem(String resourceName, Double amount, BookableItem bookableItem) {
        ItemResource itemResource = new ItemResource(resourceName, amount, bookableItem);
        bookableItem.addResource(itemResource);
        bookableItemRepository.save(bookableItem);
    }

    private void addBookingToItem(String name, LocalDate start, LocalDate end, BookableItem bookableItem) {
        Booking booking = new Booking(name, bookableItem, start, end);
        bookableItem.addBooking(booking);
        bookableItemRepository.save(bookableItem);
    }

    @Override
    public BookableItem getByName(String name) {
        return bookableItemRepository.findByItemName(name);
    }
}


