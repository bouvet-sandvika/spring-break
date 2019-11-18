package no.sandvika.springbreak.repository;

import no.sandvika.springbreak.domain.ItemLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ItemLocationRepository extends CrudRepository<ItemLocation, Long> {

}
