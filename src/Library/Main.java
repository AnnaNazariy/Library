package Library;

import Library.creational.Singleton.Library;
import Library.creational.Factory.BookType;
import Library.creational.Factory.Collection;
import Library.creational.Factory.abst.BookShopFactory;
import Library.creational.Factory.abst.BookTypeFactoryType;
import Library.creational.Factory.method.PopularFactory;
import Library.creational.Factory.BookTypeFactory;
import Library.creational.Builder.LibraryDepartment;
import Library.creational.Prototype.Reader;


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
        library2.setLocation("вул. Головна, 12");
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
            if (book != null) {
                book.giveItem();
                book.returnItem();
            }
        });



        // Prototype
        System.out.println("Prototype:");
        Reader originalReader = new Reader("Anna Nazariy", 98765);
        Reader clonedReader = (Reader) originalReader.doClone();
        System.out.println("Original Reader: " + originalReader);
        System.out.println("Cloned Reader: " + clonedReader);
        System.out.println();

        // Builder
        System.out.println("Builder:");
        LibraryDepartment historicalDepartment = new LibraryDepartment.Builder("Historical Department")
                .setDescription("Books on historical topics")
                .setHasSpecialCollection(true)
                .build();
        LibraryDepartment childrensDepartment = new LibraryDepartment.Builder("Children's Department")
                .setDescription("Books for children")
                .setHasSpecialCollection(false)
                .build();
        LibraryDepartment ITDepartment = new LibraryDepartment.Builder("IT Department")
                .setDescription("Books on IT topics")
                .setHasSpecialCollection(true)
                .build();

        System.out.println(historicalDepartment);
        System.out.println(childrensDepartment);
        System.out.println(ITDepartment);
        System.out.println();
    }
}
