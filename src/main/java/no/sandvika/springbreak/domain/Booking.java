package no.sandvika.springbreak.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long id;
    private String booker;

    @ManyToOne
    private BookableItem bookableItem;
    private LocalDate start;
    private LocalDate end;

    public Booking(String booker, BookableItem bookableItem, LocalDate start, LocalDate end) {
        this.booker = booker;
        this.bookableItem = bookableItem;
        this.start = start;
        this.end = end;
    }

    public Booking() {
    }

    public String getBooker() {
        return booker;
    }

    public BookableItem getBookableItem() {
        return bookableItem;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }
}