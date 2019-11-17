package no.sandvika.springbreak.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Conflict! Booking exists")
public class BookingConflictException extends Throwable {
}
