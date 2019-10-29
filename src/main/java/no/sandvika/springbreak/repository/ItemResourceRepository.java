package no.sandvika.springbreak.repository;

import no.sandvika.springbreak.domain.ItemResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ItemResourceRepository extends CrudRepository<ItemResource, Long> {

}
