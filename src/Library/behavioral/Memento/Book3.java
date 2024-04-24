package Library.behavioral.Memento;
public class Book3 {
    private String title;
    private int userId;

    public Book3(String title, int userId) {
        this.title = title;
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BookMemento save() {
        return new BookMemento(title, userId);
    }

    public void restore(BookMemento memento) {
        this.title = memento.getTitle();
        this.userId = memento.getUserId();
    }

    @Override
    public String toString() {
        return "Book: " + title + " (User ID: " + userId + ")";
    }
}
