package Library.behavioral.Command;

public class ReturnBookCommand implements Command {
    private LibraryReceiver library;
    private String bookTitle;

    public ReturnBookCommand(LibraryReceiver library, String bookTitle) {
        this.library = library;
        this.bookTitle = bookTitle;
    }

    @Override
    public void execute() {
        library.returnBook(bookTitle);
    }
}
