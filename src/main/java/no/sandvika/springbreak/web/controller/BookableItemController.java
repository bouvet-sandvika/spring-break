package no.sandvika.springbreak.web.controller;

import no.sandvika.springbreak.service.BookableItemService;
import no.sandvika.springbreak.web.model.BookableItemModel;
import no.sandvika.springbreak.web.modelAssembler.BookableItemModelAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
public class BookableItemController {

    private BookableItemService bookableItemService;
    private BookableItemModelAssembler bookableItemModelAssembler;

    public BookableItemController(BookableItemService bookableItemService, BookableItemModelAssembler bookableItemModelAssembler) {
        this.bookableItemService = bookableItemService;
        this.bookableItemModelAssembler = bookableItemModelAssembler;
    }

    @GetMapping("/bookableItems")
    public CollectionModel<BookableItemModel> getBookableItems() {
        return bookableItemModelAssembler.toCollectionModel(bookableItemService.getBookableItems());
    }

    @GetMapping("/bookableItems/{id}")
    public BookableItemModel getBookableItem(@PathVariable("id") Long id) {
        try {
            return bookableItemModelAssembler.toModel(bookableItemService.getBookableItem(id));
        }
        catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "bookableItem not found", e);
        }
    }
}
