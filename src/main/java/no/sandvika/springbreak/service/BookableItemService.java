package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.domain.ItemLocation;
import no.sandvika.springbreak.domain.ItemResource;
import no.sandvika.springbreak.repository.BookableItemRepository;
import no.sandvika.springbreak.repository.ItemLocationRepository;
import no.sandvika.springbreak.repository.ItemResourceRepository;
import org.springframework.stereotype.Component;

@Component
public class BookableItemService {

    private final BookableItemRepository bookableItemRepository;
    private final ItemLocationRepository itemLocationRepository;
    private final ItemResourceRepository itemResourceRepository;

    public BookableItemService(BookableItemRepository bookableItemRepository, ItemLocationRepository itemLocationRepository, ItemResourceRepository itemResourceRepository) {
        this.bookableItemRepository = bookableItemRepository;
        this.itemLocationRepository = itemLocationRepository;
        this.itemResourceRepository = itemResourceRepository;

        BookableItem printer = createItem("Printer", "Sandvika");
        addResourceToItem("Grønt blekk", 1.0, printer);
        addResourceToItem("Blått blekk", 2.0, printer);

        BookableItem bil = createItem("Bil", "Kongsberg");
        addResourceToItem("Koppholder", 1.0, bil);
        addResourceToItem("Doerer", 4.0, bil);

        BookableItem printerFraDatabase = bookableItemRepository.findByItemName("Printer");
        Integer numberOfResouces = printerFraDatabase.getResources().size();

        Integer foo = 10;
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

}


