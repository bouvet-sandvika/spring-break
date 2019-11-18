package no.sandvika.springbreak.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import no.sandvika.springbreak.web.HalEntityModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDate;

import static no.sandvika.springbreak.web.Rels.BOOKINGS;

@Relation(collectionRelation = BOOKINGS)
public class BookingModel extends HalEntityModel<BookingModel> {
    private String booker;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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
