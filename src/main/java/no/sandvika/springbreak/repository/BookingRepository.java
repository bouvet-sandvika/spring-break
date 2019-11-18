package no.sandvika.springbreak.repository;

import no.sandvika.springbreak.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
