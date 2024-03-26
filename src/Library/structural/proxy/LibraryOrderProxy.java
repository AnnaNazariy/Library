package Library.structural.proxy;
import java.util.Date;

public class LibraryOrderProxy {
    private LibraryOrder libraryOrder;

    public LibraryOrderProxy() {
        System.out.println("Taking order at library at " + new Date());
    }

    public void makeOrder() {
        if (libraryOrder == null) {
            libraryOrder = new LibraryOrder();
        }
        libraryOrder.makeOrder();
    }
}
