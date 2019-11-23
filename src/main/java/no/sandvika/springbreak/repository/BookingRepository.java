package no.sandvika.springbreak.repository;

import no.sandvika.springbreak.domain.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookingRepository extends CrudRepository<Booking, Long> {
    List<Booking> findBookingsByBookableItem_Id(Long id);
}
