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
    @JoinColumn(name = "bookings")
    private BookableItem item;
    private LocalDate start;
    private LocalDate end;

    public Booking(String booker, BookableItem item, LocalDate start, LocalDate end) {
        this.booker = booker;
        this.item = item;
        this.start = start;
        this.end = end;
    }

    public Booking() {
    }

    public String getBooker() {
        return booker;
    }

    public BookableItem getItem() {
        return item;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public Long getId() {
        return id;
    }
}