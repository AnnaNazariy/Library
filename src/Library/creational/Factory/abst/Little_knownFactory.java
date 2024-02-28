package Library.creational.Factory.abst;

import Library.creational.Factory.BookType;
import Library.creational.Factory.BookTypeFactory;
import Library.creational.Factory.Collection;
    public class Little_knownFactory extends BookTypeFactory {

public Collection createBook(BookType bookType) {
        switch (bookType) {
            case HISTORY -> {
                return new Histore();
            }
            case SELF_HELP -> {
                return new Self_help();
            }
            case BIOGRAPHY -> {
                return new Biography();
            }
            default -> {
                return null;
            }
        }
    }
}