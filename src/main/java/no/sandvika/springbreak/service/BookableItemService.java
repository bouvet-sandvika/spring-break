package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.repository.BookableItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookableItemService {

    private BookableItemRepository bookableItemRepository;

    public BookableItemService(BookableItemRepository bookableItemRepository) {
        this.bookableItemRepository = bookableItemRepository;
    }

    public List<BookableItem> getBookableItems() {
        return bookableItemRepository.findAll();
    }

    public BookableItem getBookableItem(Long id) {
        return bookableItemRepository.findById(id).orElse(null);
    }

    public BookableItem saveBookableItem(BookableItem item) {
        return bookableItemRepository.save(item);
    }
}
