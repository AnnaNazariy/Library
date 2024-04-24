package Library.behavioral.ChainOfrResponsibility;

public class StudentHandler extends BorrowBookHandler {
    @Override
    protected boolean canHandle(BorrowBookRequest request) {
        return request.getUserId() >= 1000 && request.getUserId() < 2000;
    }

    @Override
    protected void processRequest(BorrowBookRequest request) {
        System.out.println("Student with ID " + request.getUserId() + " can borrow the book: " + request.getBookTitle());
    }
}
