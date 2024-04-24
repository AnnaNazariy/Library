package Library.behavioral.Command;

public class LibraryReceiver {
    public void borrowBook(String bookTitle, int userId) {
        System.out.println("Book '" + bookTitle + "' is borrowed by user ID " + userId);
        // Логіка видачі книги
    }

    public void returnBook(String bookTitle) {
        System.out.println("Book '" + bookTitle + "' is returned");
        // Логіка повернення книги
    }
}
