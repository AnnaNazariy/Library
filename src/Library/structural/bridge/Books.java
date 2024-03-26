package Library.structural.bridge;

public class Books implements LibraryItem {
    private String title;
    private String author;
    private Service service;

    public Books(String title, String author, Service service) {
        this.title = title;
        this.author = author;
        this.service = service;
    }

    @Override
    public void borrowItem() {
        System.out.println("Book \"" + title + "\" by " + author + " is borrowed.");
    }

    @Override
    public void returnItem() {
        System.out.println("Book \"" + title + "\" by " + author + " is returned.");
    }

    @Override
    public Service getService() {
        return service;
    }
}
