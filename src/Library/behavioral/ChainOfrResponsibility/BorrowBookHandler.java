package Library.behavioral.ChainOfrResponsibility;

public abstract class BorrowBookHandler {
    private BorrowBookHandler nextHandler;

    public void setNextHandler(BorrowBookHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(BorrowBookRequest request) {
        if (canHandle(request)) {
            processRequest(request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }

    protected abstract boolean canHandle(BorrowBookRequest request);

    protected abstract void processRequest(BorrowBookRequest request);
}
