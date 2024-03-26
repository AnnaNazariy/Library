package Library.structural.bridge;

public interface LibraryItem {
    void borrowItem();
    void returnItem();
    Service getService();
}
