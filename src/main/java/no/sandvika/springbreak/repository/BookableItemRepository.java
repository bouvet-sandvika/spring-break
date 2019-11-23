package no.sandvika.springbreak.repository;

import no.sandvika.springbreak.domain.BookableItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface BookableItemRepository extends CrudRepository<BookableItem, Long> {
    Optional<BookableItem> findByItemLocation_LocationNameAndItemName(String locationName, String itemName);
}
