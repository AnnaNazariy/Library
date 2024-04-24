package Library.behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

public class Library3 {
    private List<Observer> observers = new ArrayList<>();
    private List<String> newBooks = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void addNewBook(String bookTitle) {
        newBooks.add(bookTitle);
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(newBooks);
        }
    }
}
