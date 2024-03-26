package Library.structural.bridge;

public class MagazineService implements Service {
    @Override
    public void provideService() {
        System.out.println("Magazine service is provided.");
    }
}
