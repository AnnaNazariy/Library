package Library.structural.bridge;

public class BookService implements Service {
    @Override
    public void provideService() {
        System.out.println("Book service is provided.");
    }
}
