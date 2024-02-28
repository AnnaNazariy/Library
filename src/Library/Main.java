package Library;

import Library.creational.Singleton.Library;
import Library.creational.Factory.BookType;
import Library.creational.Factory.Collection;
import Library.creational.Factory.abst.BookShopFactory;
import Library.creational.Factory.abst.BookTypeFactoryType;
import Library.creational.Factory.method.PopularFactory;
import Library.creational.Factory.BookTypeFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Singleton
        Library library = Library.getInstance();
        Library library2 = Library.getInstance();
        System.out.println("Singleton:");
        System.out.println("Library 1 location: " + library.getLocation());
        System.out.println("Library 2 location: " + library2.getLocation());
        library2.setLocation("вул. Головна, 4Б");
        System.out.println("Library 1 location after changing: " + library.getLocation());
        System.out.println("Library 2 location after changing: " + library2.getLocation());
        System.out.println("Are they the same instance? " + (library == library2));
        System.out.println();

        // Factory Method
        System.out.println("Factory Method:");
        PopularFactory popularFactory = new PopularFactory();
        List<Collection> books = new ArrayList<>();
        for (BookType bookType : BookType.values()) {
            Collection book = popularFactory.createBook(bookType);
            books.add(book);
        }
        books.forEach(book -> {
            book.giveItem();
            book.returnItem();
        });
        System.out.println();

        // Abstract Factory
        System.out.println("Abstract Factory:");
        BookShopFactory bookShopFactory = new BookShopFactory();
        BookTypeFactory popular_bookFactory1 = bookShopFactory.createBook(BookTypeFactoryType.Popular_book);
        BookTypeFactory little_known_booksFactory = bookShopFactory.createBook(BookTypeFactoryType.Little_known_books);
        List<Collection> books1 = new ArrayList<>();
        for (BookType bookType : BookType.values()) {
            Collection book;
            if (bookType.ordinal() < 3) {
                book = popular_bookFactory1.createBook(bookType);
            } else {
                book = little_known_booksFactory.createBook(bookType);
            }
            books1.add(book);
        }
        books1.forEach(book -> {
            book.giveItem();
            book.returnItem();
        });
        System.out.println();
    }
}
