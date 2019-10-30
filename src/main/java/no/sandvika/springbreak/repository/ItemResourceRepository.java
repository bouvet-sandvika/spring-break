package no.sandvika.springbreak.repository;

import no.sandvika.springbreak.domain.ItemResource;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ItemResourceRepository extends MongoRepository<ItemResource, Long> {

}
