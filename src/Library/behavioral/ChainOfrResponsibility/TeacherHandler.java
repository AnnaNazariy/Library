package Library.behavioral.ChainOfrResponsibility;

public class TeacherHandler extends BorrowBookHandler {
    @Override
    protected boolean canHandle(BorrowBookRequest request) {
        return request.getUserId() >= 2000 && request.getUserId() < 3000;
    }

    @Override
    protected void processRequest(BorrowBookRequest request) {
        System.out.println("Teacher with ID " + request.getUserId() + " can borrow the book: " + request.getBookTitle());
    }
}
