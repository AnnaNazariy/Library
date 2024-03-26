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
import Library.structural.adapter.AudioBook;
import Library.structural.adapter.AudioToTextAdapter;
import Library.structural.bridge.BookService;
import Library.structural.bridge.Magazine;
import Library.structural.bridge.MagazineService;
import Library.structural.bridge.Books;
import Library.structural.composite.Book;
import Library.structural.composite.Bookshelf;
import Library.structural.decorator.BookCharacter;
import Library.structural.decorator.HardcoverDecorator;
import Library.structural.decorator.HarryPotter;
import Library.structural.decorator.PaperbackDecorator;
import Library.structural.facade.ChooseBook;
import Library.structural.facade.LibraryAssistant;
import Library.structural.facade.ReturnBook;
import Library.structural.facade.TakeOrder;
import Library.structural.flyweight.Flyweight;
import Library.structural.flyweight.FlyweightFactory;
import Library.structural.proxy.LibraryOrderProxy;
import Library.structural.proxy.OnlineLibraryOrder;


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
        library2.setLocation("вул. Буковинська, 12");
        System.out.println("Library 1 location after changing: " + library.getLocation());
        System.out.println("Library 2 location after changing: " + library2.getLocation());
        System.out.println("Are they the same instance? " + (library == library2));
        System.out.println("________________________________________________________");

        // Factory Method
        System.out.println("Factory Method:");
        PopularFactory popularFactory = new PopularFactory();
        Collection novel = popularFactory.createBook(BookType.NOVEL);
        Collection romance = popularFactory.createBook(BookType.ROMANCE);
        Collection fantasy = popularFactory.createBook(BookType.FANTASY);
        List<Collection> books = new ArrayList<>();
        books.add(novel);
        books.add(romance);
        books.add(fantasy);
        books.forEach(book -> {
            book.giveItem();
            book.returnItem();
        });
        System.out.println("_________________________________________________");

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
            System.out.println("_____________________________________________________");
        });

        // Prototype
        System.out.println("Prototype:");
        Reader originalReader = new Reader("Anna Nazariy", 98765);
        Reader clonedReader = (Reader) originalReader.doClone();
        System.out.println("Original Reader: " + originalReader);
        System.out.println("Cloned Reader: " + clonedReader);
        System.out.println("___________________________________________________________________");

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
        System.out.println("_____________________________________________________________________________________________________");

        //Facade
        System.out.println("Facade");
        var takeOrder = new TakeOrder();
        var chooseBook = new ChooseBook();
        var returnBook = new ReturnBook();
        var libraryAssistant = new LibraryAssistant(takeOrder, chooseBook, returnBook);
        System.out.println(libraryAssistant.workDay());
        System.out.println("____________________________________________________________-");

        //Flyweight
        System.out.println("Flyweight");
        FlyweightFactory flyweightFactory = FlyweightFactory.getInstance();
        for (int i = 0; i < 2; i++) {
            Flyweight tale = flyweightFactory.getBook("Mermaid", "Hans Christian Andersen", "Children's Department");
            tale.display();
            Flyweight scienceBook = flyweightFactory.getBook("Java Design Patterns: A Hands-On Experience with Real-World Examples", " Vaskaran Sarcar", "IT Department");
            scienceBook.display();
        }
        System.out.println("______________________________________________________________________________________________________________________________________");

        //Adapter
        System.out.println("Adapter");
        AudioBook audioBook = new AudioBook("MP3 audio data");
        AudioToTextAdapter adapter = new AudioToTextAdapter(audioBook);
        String textData = adapter.getContent();
        System.out.println("Text data: " + textData);
        System.out.println("_____________________________________________________________");

        //Proxy
       /* System.out.println("Proxy");
        LibraryOrderProxy libraryOrderProxy = new LibraryOrderProxy();
        OnlineLibraryOrder onlineLibraryOrder = new OnlineLibraryOrder();
        onlineLibraryOrder.makeOrder();
        libraryOrderProxy.makeOrder();
        System.out.println("___________________________________________________");*/

        //Composite
        System.out.println("Composite");
        Book historyBook1 = new Book("The Rise and Fall of the Roman Empire");
        Book historyBook2 = new Book("Guns, Germs, and Steel");
        Bookshelf historyShelf = new Bookshelf("History Shelf");
        historyShelf.addComponent(historyBook1);
        historyShelf.addComponent(historyBook2);
        historyBook1.display();
        historyBook2.display();
        historyShelf.display();
        System.out.println("_______________________________________________________");

        //Bridge
        System.out.println("Bridge");
                System.out.println(" >> Bridge start");
                System.out.println("Borrowing a book:");
                var bookService = new BookService();
                var book = new Books("The Great Gatsby", "F. Scott Fitzgerald", bookService);
                book.borrowItem();
                book.returnItem();
                System.out.println("Borrowing a magazine:");
                var magazineService = new MagazineService();
                var magazine = new Magazine("National Geographic", "Science", magazineService);
                magazine.borrowItem();
                magazine.returnItem();
                System.out.println("_______________________________________________________________________");

        //Decorator
        System.out.println("Decorator");
        BookCharacter harryPotter = new HarryPotter();
        harryPotter.describe();

        System.out.println("In hardcover:");
        BookCharacter hardcoverHarryPotter = new HardcoverDecorator(harryPotter);
        hardcoverHarryPotter.describe();

        System.out.println("In paperback:");
        BookCharacter paperbackHarryPotter = new PaperbackDecorator(harryPotter);
        paperbackHarryPotter.describe();
        System.out.println("_______________________________________________");

    }
        }








