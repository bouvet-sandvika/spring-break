package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.BookableItem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private final BookableItemServiceImpl bookableItemServiceImpl;

    public MyController(BookableItemServiceImpl bookableItemServiceImpl) {
        this.bookableItemServiceImpl = bookableItemServiceImpl;
    }

    @GetMapping("/getSomething")
    public void getSomething(){
        BookableItem theItem = bookableItemServiceImpl.getByName("Printer");
    }
}
