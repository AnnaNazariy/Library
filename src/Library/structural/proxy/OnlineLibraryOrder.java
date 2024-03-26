package Library.structural.proxy;
import java.util.Date;

public class OnlineLibraryOrder extends Order {
    @Override
    public void makeOrder() {
        System.out.println(this.getClass().getSimpleName() + " was made at " + new Date());
    }
}
