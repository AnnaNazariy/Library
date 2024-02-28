package Library.creational.Factory.method;

import Library.creational.Factory.*;
import Library.creational.Factory.BookTypeFactory;
import Library.creational.Factory.NOVEL;
import Library.creational.Factory.ROMANCE;
import Library.creational.Factory.FANTASY;

public class PopularFactory extends BookTypeFactory {
    @Override
    public Collection createBook(BookType bookType) {
        switch (bookType) {
            case NOVEL:
                return new NOVEL();
            case ROMANCE:
                return new ROMANCE();
            case FANTASY:
                return new FANTASY();
            default:
                return null;
        }
    }
}
