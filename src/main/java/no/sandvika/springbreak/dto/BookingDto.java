package no.sandvika.springbreak.dto;

import java.time.LocalDate;

public class BookingDto {
    private Long id;
    private String booker;
    private BookableItemDto item;
    private LocalDate start;
    private LocalDate end;

    public BookingDto(Long id, String booker, BookableItemDto item, LocalDate start, LocalDate end) {
        this.id = id;
        this.booker = booker;
        this.item = item;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBooker() {
        return booker;
    }

    public void setBooker(String booker) {
        this.booker = booker;
    }

    public BookableItemDto getItem() {
        return item;
    }

    public void setItem(BookableItemDto item) {
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
