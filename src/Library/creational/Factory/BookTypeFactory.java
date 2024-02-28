package Library.creational.Factory;

import Library.creational.Factory.BookType;
import Library.creational.Factory.Collection;

public abstract class BookTypeFactory {
    public abstract Collection createBook(BookType bookType);
}

