package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.domain.Booking;
import no.sandvika.springbreak.domain.ItemLocation;
import no.sandvika.springbreak.domain.ItemResource;
import no.sandvika.springbreak.repository.BookableItemRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookableItemService {

    private final BookableItemRepository bookableItemRepository;

    public BookableItemService(BookableItemRepository bookableItemRepository ) {
        this.bookableItemRepository = bookableItemRepository;

        BookableItem bookableItem = new BookableItem("Printer");
        bookableItem.setItemLocation(new ItemLocation("Sandvika"));
        bookableItem.addBooking(new Booking("Kjell", LocalDate.now(), LocalDate.now().plusDays(5)));
        bookableItem.addResource(new ItemResource("Blekk", 5.0));
        bookableItemRepository.save(bookableItem);
    }
}


