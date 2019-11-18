package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.repository.BookableItemRepository;
import org.springframework.stereotype.Service;

@Service
public class BookableItemService {
    private BookableItemRepository bookableItemRepository;

    public BookableItemService(BookableItemRepository bookableItemRepository) {
        this.bookableItemRepository = bookableItemRepository;
    }

    public BookableItem getBookableItem(Long id) {
        return bookableItemRepository.findById(id).orElseThrow();
    }
}
