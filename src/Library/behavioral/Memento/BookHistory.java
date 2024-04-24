package Library.behavioral.Memento;
import java.util.Stack;

public class BookHistory {
    private Stack<BookMemento> history = new Stack<>();

    public void save(BookMemento memento) {
        history.push(memento);
    }

    public BookMemento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
