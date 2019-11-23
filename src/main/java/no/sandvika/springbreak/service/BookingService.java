package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.domain.Booking;
import no.sandvika.springbreak.domain.ItemLocation;
import no.sandvika.springbreak.dto.BookingDto;
import no.sandvika.springbreak.dto.BookingsDto;
import no.sandvika.springbreak.repository.BookableItemRepository;
import no.sandvika.springbreak.repository.BookingRepository;
import no.sandvika.springbreak.repository.ItemLocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static no.sandvika.springbreak.service.DtoMapperUtils.toBookingDto;

@Service
public class BookingService {

    private BookingRepository bookingRepository;
    private BookableItemRepository bookableItemRepository;
    private ItemLocationRepository itemLocationRepository;

    public BookingService(BookingRepository bookingRepository,
                          BookableItemRepository bookableItemRepository,
                          ItemLocationRepository itemLocationRepository) {
        this.bookingRepository = bookingRepository;
        this.bookableItemRepository = bookableItemRepository;
        this.itemLocationRepository = itemLocationRepository;
    }

    @Transactional
    public void lagreNyLocation(String location) {
        itemLocationRepository.save(new ItemLocation(location));
    }

    @Transactional
    public void lagreBookableItems(String location) {
        ItemLocation lagretLocation = itemLocationRepository.findByLocationName(location);
        bookableItemRepository.save(lagBookableItemMedNavnOgLocation("Sjøelefanten", lagretLocation));
        bookableItemRepository.save(lagBookableItemMedNavnOgLocation("Printer", lagretLocation));
        bookableItemRepository.save(lagBookableItemMedNavnOgLocation("Partyløva", lagretLocation));
    }

    private static BookableItem lagBookableItemMedNavnOgLocation(String navn, ItemLocation itemLocation) {
        return new BookableItem(navn, itemLocation);
    }

    public BookingDto saveNewBookng(BookingDto bookingDto) throws BookableItemNotFoundException {
        Optional<BookableItem> bookableItem = bookableItemRepository
                .findByItemLocation_LocationNameAndItemName(
                        bookingDto.getItem().getLocation(),
                        bookingDto.getItem().getName());

        if (bookableItem.isPresent()) {
            Booking newBooking = new Booking(
                    bookingDto.getBooker(),
                    bookableItem.get(),
                    bookingDto.getStart(),
                    bookingDto.getEnd()
            );

            return toBookingDto(bookingRepository.save(newBooking));

        } else {
            throw new BookableItemNotFoundException();
        }
    }

    public BookingDto getBooking(Long id) throws BookingNotFoundException {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            return toBookingDto(booking.get());
        } else {
            throw new BookingNotFoundException();
        }
    }

    public BookingDto replaceBooking(Long id, BookingDto bookingDto) throws BookingNotFoundException {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            Booking updatedBooking = booking.get();
            updatedBooking.setBooker(bookingDto.getBooker());
            updatedBooking.setStart(bookingDto.getStart());
            updatedBooking.setEnd(bookingDto.getEnd());
            return toBookingDto(bookingRepository.save(updatedBooking));
        } else {
            throw new BookingNotFoundException();
        }
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public BookingsDto getBookings(String itemName, String location, String booker) {
        List<Booking> relevanteBookings = new ArrayList<>();
        if (itemName != null) {
            relevanteBookings.addAll(bookingRepository.findAllByBookableItem_ItemName(itemName));
        }
        if (location != null) {
            relevanteBookings.addAll(bookingRepository.findAllByBookableItem_ItemLocation_LocationName(location));
        }
        if (booker != null) {
            relevanteBookings.addAll(bookingRepository.findAllByBooker(booker));
        }

        List<BookingDto> bookings = relevanteBookings.stream()
                .filter(b -> itemName == null || b.getBookableItem().getItemName().equals(itemName))
                .filter(b -> location == null || b.getBookableItem().getItemLocation().getLocationName().equals(location))
                .filter(b -> booker == null || b.getBooker().equals(booker))
                .map(DtoMapperUtils::toBookingDto)
                .collect(Collectors.toList());
        return new BookingsDto(bookings);
    }
}
