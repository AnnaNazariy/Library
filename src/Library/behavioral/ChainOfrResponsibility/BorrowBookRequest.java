package Library.behavioral.ChainOfrResponsibility;

public class BorrowBookRequest {
    private String bookTitle;
    private int userId;

    public BorrowBookRequest(String bookTitle, int userId) {
        this.bookTitle = bookTitle;
        this.userId = userId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getUserId() {
        return userId;
    }
}
