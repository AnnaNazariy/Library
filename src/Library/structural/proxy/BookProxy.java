package Library.structural.proxy;

public class BookProxy implements АncientВooks {
    private final BookDatabase bookDatabase;
    private final int userId;

    public BookProxy(int userId) {
        this.userId = userId;
        this.bookDatabase = new BookDatabase();
    }

    @Override
    public void read() {
        if (hasAccess()) {
            System.out.println("Reading ancient book: " + bookDatabase.getAncientBook(userId));
        } else {
            System.out.println("Access denied to ancient book.");
        }
    }

    private boolean hasAccess() {
        return userId == 1 || userId == 2; // Припустимо, що доступ дозволений лише користувачам з id = 1 або id = 2
    }
}
