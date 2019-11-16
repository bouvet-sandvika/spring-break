package no.sandvika.springbreak.service;

import no.sandvika.springbreak.domain.BookableItem;

public interface BookableItemService {
    BookableItem getByName(String name);
}
