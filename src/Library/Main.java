package Library;

import Library.behavioral.ChainOfrResponsibility.BorrowBookRequest;
import Library.behavioral.ChainOfrResponsibility.Library2;
import Library.behavioral.Command.*;
import Library.behavioral.Iterator.LibraryCollection;
import Library.behavioral.Iterator.LibraryIterator;
import Library.behavioral.Mediator.ConcreteColleague;
import Library.behavioral.Mediator.ConcreteMediator;
import Library.behavioral.Memento.Book3;
import Library.behavioral.Memento.BookHistory;
import Library.behavioral.Memento.BookMemento;
import Library.behavioral.Observer.Library3;
import Library.behavioral.Observer.User;
import Library.behavioral.State.IssuedState;
import Library.behavioral.State.LibraryItem3;
import Library.behavioral.State.SelectedState;
import Library.behavioral.Strategy.BubbleSortStrategy;
import Library.behavioral.Strategy.Library4;
import Library.behavioral.Strategy.MergeSortStrategy;
import Library.behavioral.Strategy.QuickSortStrategy;
import Library.behavioral.TemplateMethod.AudioBookProcessor;
import Library.behavioral.TemplateMethod.BookProcessor;
import Library.behavioral.TemplateMethod.DocumentProcessor;
import Library.behavioral.TemplateMethod.MagazineProcessor;
import Library.behavioral.Visitor.*;
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
import Library.structural.proxy.BookProxy;
import Library.structural.proxy.АncientВooks;

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
        System.out.println("Proxy");
        АncientВooks bookProxy1 = new BookProxy(1);
        bookProxy1.read(3);
        // Створення проксі для користувача з id = 3
        АncientВooks bookProxy2 = new BookProxy(3);
        bookProxy2.read(2);
        System.out.println("___________________________________________________");


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

        // Chain of Responsibility
        System.out.println("Chain of Responsibility:");
        // Створення об'єктів запитів на видачу книг
        BorrowBookRequest studentRequest = new BorrowBookRequest("Harry Potter", 1234);
        BorrowBookRequest teacherRequest = new BorrowBookRequest("Java Programming", 2500);
        // Створення об'єкту бібліотеки
        Library2 library3 = new Library2();
        // Обробка запитів у бібліотеці
        library3.processRequest(studentRequest);
        library3.processRequest(teacherRequest);
        System.out.println("_______________________________________________");

        // Command
        System.out.println("Command:");
        // Створення отримувача команд
        LibraryReceiver libraryReceiver = new LibraryReceiver();
        // Створення команд видачі та повернення книги
        Command borrowCommand = new BorrowBookCommand(libraryReceiver, "Harry Potter", 1234);
        Command returnCommand = new ReturnBookCommand(libraryReceiver, "Java Programming");
        // Створення користувача та виклик команд
        LibraryUser user = new LibraryUser(borrowCommand, returnCommand);
        user.borrowBook();
        user.returnBook();
        System.out.println("_______________________________________________________________");

        // Iterator
        System.out.println("Iterator:");
        // Створення колекції книг
        List<String> booksList = new ArrayList<>();
        booksList.add("Harry Potter");
        booksList.add("Lord of the Rings");
        booksList.add("Game of Thrones");
        // Створення об'єкту колекції
        LibraryCollection libraryCollection = new LibraryCollection(booksList);
         // Отримання ітератора для колекції
        LibraryIterator iterator = libraryCollection.createIterator();
       // Перегляд книг за допомогою ітератора
        System.out.println("Books in the library:");
        while (iterator.hasNext()) {
            String currentBook = (String) iterator.next();
            System.out.println(currentBook);
        }
        System.out.println("_______________________________________________________________");

        //Visitor
        System.out.println("Visitor:");
        // Створення об'єкту структури бібліотеки
        LibraryStructure libraryStructure = new LibraryStructure();

        // Додавання різних елементів до структури бібліотеки
        libraryStructure.add(new BookItem("Harry Potter"));
        libraryStructure.add(new MagazineItem("National Geographic"));

        // Створення об'єкта відвідувача
        LibraryVisitor visitor = new ConcreteVisitor();

        // Виклик методу accept для відвідувача
        System.out.println("Visiting library items: Anna");
        libraryStructure.accept(visitor);
        System.out.println("_______________________________________________________________");


       //TemplateMethod
        System.out.println("TemplateMethod:");
        System.out.println("Processing a book:");
        DocumentProcessor bookProcessor = new BookProcessor();
        bookProcessor.processDocument();

        System.out.println("\nProcessing a magazine:");
        DocumentProcessor magazineProcessor = new MagazineProcessor();
        magazineProcessor.processDocument();

        System.out.println("\nProcessing an audio book:");
        DocumentProcessor audioBookProcessor = new AudioBookProcessor();
        audioBookProcessor.processDocument();
        System.out.println("_______________________________________________________________");

        //Mediator
        System.out.println("Mediator:");
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleague colleague1 = new ConcreteColleague(mediator);
        ConcreteColleague colleague2 = new ConcreteColleague(mediator);

        mediator.addColleague(colleague1);
        mediator.addColleague(colleague2);

        colleague1.sendRequest("Hello from colleague 1");
        colleague2.sendRequest("Hello from colleague 2");
        System.out.println("_______________________________________________________________");

        // Memento
        System.out.println("Memento:");
        Book3 book3 = new Book3("Harry Potter", 1879);
        BookHistory history = new BookHistory();
        history.save(book3.save());
        System.out.println("Initial state: " + book3);
        book3.setTitle("Lord of the Rings");
        book3.setUserId(5678);
        System.out.println("Updated state: " + book3);
        BookMemento initialMemento = history.undo();
        if (initialMemento != null) {
            book3.restore(initialMemento);
            System.out.println("Restored state: " + book3);
        } else {
            System.out.println("No more states to undo.");
        }
        System.out.println("_______________________________________________________________");

        // Observer
        System.out.println("Observer:");
        Library3 libraryObserver = new Library3(); // Змінено ім'я на 'libraryObserver'
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        libraryObserver.addObserver(user1);
        libraryObserver.addObserver(user2);
        libraryObserver.addNewBook("Harry Potter");
        libraryObserver.addNewBook("Lord of the Rings");
        System.out.println("_______________________________________________________________");

        //State
        System.out.println("State:");
        LibraryItem3 newBook = new LibraryItem3();
        System.out.println("Initial State:");
        newBook.displayState();
        System.out.println("\nBook is selected:");
        newBook.setState(new SelectedState());
        newBook.displayState();
        System.out.println("\nBook is issued:");
        newBook.setState(new IssuedState());
        newBook.displayState();
        System.out.println("_______________________________________________________________");

        //Strategy
        System.out.println("Strategy :");
        Library4 newLibrary = new Library4();
        newLibrary.setSortStrategy(new BubbleSortStrategy());
        newLibrary.performSort();
        newLibrary.setSortStrategy(new MergeSortStrategy());
        newLibrary.performSort();
        newLibrary.setSortStrategy(new QuickSortStrategy());
        newLibrary.performSort();
        System.out.println("_______________________________________________________________");




    }



    }









