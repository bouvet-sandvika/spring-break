package no.sandvika.springbreak.domain;

import java.time.LocalDate;

public class Booking {
    private Long id;
    private String booker;
    private BookableItem item;
    private LocalDate start;
    private LocalDate end;

    public Booking(Long id, String booker, BookableItem item, LocalDate start, LocalDate end) {
        this.id = id;
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