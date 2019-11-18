package no.sandvika.springbreak.web.modelAssembler;

import no.sandvika.springbreak.domain.BookableItem;
import no.sandvika.springbreak.domain.ItemLocation;
import no.sandvika.springbreak.web.model.BookableItemModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class BookableItemModelAssembler extends RepresentationModelAssemblerSupport<BookableItem, BookableItemModel> {

    public BookableItemModelAssembler() {
        super(BookableItem.class, BookableItemModel.class);
    }

    @Override
    public BookableItemModel toModel(BookableItem entity) {
        return new BookableItemModel(entity.getItemName(), entity.getItemLocation().getLocationName());
    }

    public BookableItem toEntity(BookableItemModel model) {
        ItemLocation itemLocation = new ItemLocation(model.getLocation());
        return new BookableItem(model.getName(), itemLocation);
    }
}
