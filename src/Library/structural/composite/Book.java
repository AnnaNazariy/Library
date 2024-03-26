package Library.structural.composite;

public class Book implements LibraryComponent {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Book: " + title);
    }
    }

