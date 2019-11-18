package no.sandvika.springbreak.repository;

import no.sandvika.springbreak.domain.ItemLocation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ItemLocationRepository extends MongoRepository<ItemLocation, Long> {

}
