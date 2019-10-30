package no.sandvika.springbreak.repository;

import no.sandvika.springbreak.domain.BookableItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookableItemRepository extends MongoRepository<BookableItem, Long> {
    BookableItem findByItemName(String itemName);

}
