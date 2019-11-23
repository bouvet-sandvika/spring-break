package no.sandvika.springbreak.repository;

import no.sandvika.springbreak.domain.BookableItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookableItemRepository extends CrudRepository<BookableItem, Long> {
    BookableItem findByItemName(String itemName);
}
