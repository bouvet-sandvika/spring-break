package no.sandvika.springbreak.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Booking not found")
public class BookingNotFoundException extends Throwable {
}
