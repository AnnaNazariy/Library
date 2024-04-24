package Library.behavioral.ChainOfrResponsibility;

public class Library2 {
    private BorrowBookHandler handler;

    public Library2() {
        // Створення ланцюжка обробників
        handler = new StudentHandler();
        BorrowBookHandler teacherHandler = new TeacherHandler();
        handler.setNextHandler(teacherHandler);
    }

    public void processRequest(BorrowBookRequest request) {
        // Обробка запиту
        handler.handleRequest(request);
    }
}