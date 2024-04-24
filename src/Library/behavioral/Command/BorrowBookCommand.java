package Library.behavioral.Command;

public class BorrowBookCommand implements Command {
    private LibraryReceiver library;
    private String bookTitle;
    private int userId;

    public BorrowBookCommand(LibraryReceiver library, String bookTitle, int userId) {
        this.library = library;
        this.bookTitle = bookTitle;
        this.userId = userId;
    }

    @Override
    public void execute() {
        library.borrowBook(bookTitle, userId);
    }
}
