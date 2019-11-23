package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.domain.Booking;
import no.sandvika.springbreak.dto.BookableItemDto;
import no.sandvika.springbreak.dto.BookingDto;

class DtoMapperUtils {

    static BookingDto toBookingDto(Booking booking) {
        BookableItemDto bookableItemDto = toBookableItemDto(booking.getBookableItem());
        return new BookingDto(booking.getBooker(), bookableItemDto, booking.getStart(), booking.getEnd());
    }

    private static BookableItemDto toBookableItemDto(BookableItem bookableItem) {
        return new BookableItemDto(bookableItem.getItemName(), bookableItem.getItemLocation().getLocationName());
    }
}
