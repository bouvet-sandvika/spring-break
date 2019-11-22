package no.sandvika.springbreak.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Booking {
    @Id
    private String id;
    private String booker;

    private LocalDate start;
    private LocalDate end;

    public Booking(String booker, LocalDate start, LocalDate end) {
        this.booker = booker;
        this.start = start;
        this.end = end;
    }

    public Booking() {
    }

    public String getBooker() {
        return booker;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }
}