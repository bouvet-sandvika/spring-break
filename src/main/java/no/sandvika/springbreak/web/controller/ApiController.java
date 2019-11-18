package no.sandvika.springbreak.web.controller;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static no.sandvika.springbreak.web.Rels.BOOKINGS;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class ApiController {
    @GetMapping("/api")
    public RepresentationModel getApi() {
        RepresentationModel api = new RepresentationModel();
        api.add(linkTo(methodOn(ApiController.class).getApi()).withSelfRel());
        api.add(linkTo(methodOn(BookingController.class).getBookings(null,null,null)).withRel(BOOKINGS));
        return api;
    }
}
