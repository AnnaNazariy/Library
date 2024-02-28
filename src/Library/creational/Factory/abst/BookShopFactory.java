package Library.creational.Factory.abst;

import Library.creational.Factory.BookTypeFactory;
import Library.creational.Factory.Collection;
import Library.creational.Factory.method.PopularFactory;

public class BookShopFactory {
    public BookTypeFactory createBook(BookTypeFactoryType bookTypeFactoryType) {
        switch (bookTypeFactoryType) {
            case Popular_book:
                return new PopularFactory();
            case Little_known_books:
                return new Little_knownFactory();
            default:
                return null;
        }
    }
}
