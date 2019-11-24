package no.sandvika.springbreak.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long id;
    private String booker;

    @ManyToOne(cascade = CascadeType.ALL)
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

    public Long getId() {
        return id;
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

    public void setBooker(String booker) {
        this.booker = booker;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }
}