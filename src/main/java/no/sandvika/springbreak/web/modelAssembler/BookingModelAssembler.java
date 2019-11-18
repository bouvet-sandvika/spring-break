package no.sandvika.springbreak.web.modelAssembler;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.web.controller.BookableItemController;
import no.sandvika.springbreak.web.controller.BookingController;
import no.sandvika.springbreak.domain.Booking;
import no.sandvika.springbreak.web.model.BookableItemModel;
import no.sandvika.springbreak.web.model.BookingModel;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static no.sandvika.springbreak.web.Rels.BOOKABLE_ITEM;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BookingModelAssembler extends RepresentationModelAssemblerSupport<Booking, BookingModel> {

    private BookableItemModelAssembler bookableItemModelAssembler;

    public BookingModelAssembler(BookableItemModelAssembler bookableItemModelAssembler) {
        super(Booking.class, BookingModel.class);
        this.bookableItemModelAssembler = bookableItemModelAssembler;
    }

    @Override
    public BookingModel toModel(Booking entity) {
        BookingModel bookingModel = new BookingModel(entity.getBooker(), null, entity.getStart(), entity.getEnd());
        BookableItemModel bookableItemModel = bookableItemModelAssembler.toModel(entity.getItem());

        bookingModel.add(linkTo(methodOn(BookableItemController.class).getBookableItem(entity.getItem().getId())).withRel(BOOKABLE_ITEM));
        bookingModel.add(linkTo(methodOn(BookingController.class).getBooking(entity.getId())).withSelfRel());

        bookingModel.embed(LinkRelation.of(BOOKABLE_ITEM), bookableItemModel, false);

        return bookingModel;
    }

    public Booking toEntity(BookingModel model) {
        BookableItem bookableItem = bookableItemModelAssembler.toEntity(model.getItem());
        return new Booking(model.getBooker(), bookableItem, model.getStart(), model.getEnd());
    }

    private BookingModel getBookingModel(Booking entity) {
        BookableItemModel bookableItemModel = bookableItemModelAssembler.toModel(entity.getItem());
        return new BookingModel(entity.getBooker(), bookableItemModel, entity.getStart(), entity.getEnd());
    }


}
