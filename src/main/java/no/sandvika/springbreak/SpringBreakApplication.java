package no.sandvika.springbreak;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.domain.Booking;
import no.sandvika.springbreak.service.BookableItemService;
import no.sandvika.springbreak.service.BookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class SpringBreakApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SpringBreakApplication.class, args);

        BookingService bookingService = ctx.getBean(BookingService.class);
        String location = "Sandvika";
        bookingService.lagreNyLocation(location);
        bookingService.lagreBookableItems(location);
        bookingService.lagreBooking();
    }
}
