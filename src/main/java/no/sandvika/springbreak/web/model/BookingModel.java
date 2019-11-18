package no.sandvika.springbreak.web.model;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDate;

import static no.sandvika.springbreak.web.Rels.BOOKINGS;

@Relation(collectionRelation = BOOKINGS)
public class BookingModel extends RepresentationModel<BookingModel> {
    private String booker;
    private BookableItemModel item;
    private LocalDate start;
    private LocalDate end;

    public BookingModel(String booker, BookableItemModel item, LocalDate start, LocalDate end) {
        this.booker = booker;
        this.item = item;
        this.start = start;
        this.end = end;
    }

    public String getBooker() {
        return booker;
    }

    public void setBooker(String booker) {
        this.booker = booker;
    }

    public BookableItemModel getItem() {
        return item;
    }

    public void setItem(BookableItemModel item) {
        this.item = item;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}
