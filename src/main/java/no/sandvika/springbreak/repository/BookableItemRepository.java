package no.sandvika.springbreak.repository;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.domain.ItemLocation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookableItemRepository extends CrudRepository<BookableItem, Long> {
    BookableItem findByItemName(String itemName);

}
