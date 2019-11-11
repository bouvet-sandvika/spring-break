package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.domain.ItemLocation;
import no.sandvika.springbreak.domain.ItemResource;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BookableItemService {
    public List<BookableItem> getAllBookableItems() {
        BookableItem printer = createItem("Printer", "Sandvika");
        addResourceToItem("Grønt blekk", 1.0, printer);
        addResourceToItem("Blått blekk", 2.0, printer);

        BookableItem partyLion = createItem("Partyløven", "Sandvika");
        addResourceToItem("BatteriProsent", 100.0, partyLion);

        return Arrays.asList(printer, partyLion);
    }

    private BookableItem createItem(String name, String location) {
        ItemLocation minLocation = new ItemLocation(location);
        BookableItem bookableItem = new BookableItem(name);
        bookableItem.setItemLocation(minLocation);
        return bookableItem;
    }

    private void addResourceToItem(String resourceName, Double amount, BookableItem bookableItem) {
        ItemResource itemResource = new ItemResource(resourceName, amount, bookableItem);
        bookableItem.addResource(itemResource);
    }
}
