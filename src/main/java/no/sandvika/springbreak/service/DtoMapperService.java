package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.domain.Booking;
import no.sandvika.springbreak.domain.ItemLocation;
import no.sandvika.springbreak.dto.BookableItemDto;
import no.sandvika.springbreak.dto.BookingDto;
import org.springframework.stereotype.Service;

@Service
public class DtoMapperService {
    Booking toBooking(Long id, BookingDto bookingDto) {
        BookableItem bookableItem = toBookableItem(bookingDto.getItem());
        return new Booking(id, bookingDto.getBooker(), bookableItem, bookingDto.getStart(), bookingDto.getEnd());
    }

    BookingDto toBookingDto(Booking booking) {
        BookableItemDto bookableItemDto = toBookableItemDto(booking.getItem());
        return new BookingDto(booking.getBooker(), bookableItemDto, booking.getStart(), booking.getEnd());
    }

    private BookableItemDto toBookableItemDto(BookableItem bookableItem) {
        return new BookableItemDto(bookableItem.getItemName(), bookableItem.getItemLocation().getLocationName());
    }

    private BookableItem toBookableItem(BookableItemDto bookableItemDto) {
        ItemLocation itemLocation = toItemLocation(bookableItemDto.getLocation());
        return new BookableItem(-1L, bookableItemDto.getName(), itemLocation);
    }

    private ItemLocation toItemLocation(String location) {
        return new ItemLocation(-1L, location);
    }
}
