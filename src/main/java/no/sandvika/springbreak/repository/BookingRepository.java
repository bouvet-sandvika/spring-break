package no.sandvika.springbreak.repository;

import no.sandvika.springbreak.domain.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findAllByBookableItem_ItemLocation_LocationName(String locationName);
    List<Booking> findAllByBooker(String booker);
    List<Booking> findAllByBookableItem_ItemName(String itemName);
}
