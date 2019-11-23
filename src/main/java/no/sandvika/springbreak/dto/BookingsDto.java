package no.sandvika.springbreak.dto;

import java.util.List;

public class BookingsDto {
    private List<BookingDto> bookingDtos;

    public BookingsDto(List<BookingDto> bookingDtos) {
        this.bookingDtos = bookingDtos;
    }

    public List<BookingDto> getBookingDtos() {
        return bookingDtos;
    }

    public void setBookingDtos(List<BookingDto> bookingDtos) {
        this.bookingDtos = bookingDtos;
    }
}
