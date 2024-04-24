package Library.behavioral.Memento;
public class BookMemento {
    private String title;
    private int userId;

    public BookMemento(String title, int userId) {
        this.title = title;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public int getUserId() {
        return userId;
    }
}