
package Library.behavioral.State;

public class LibraryItem3 {
    private LibraryItemState currentState;

    public LibraryItem3() {
        // Початковий стан - доступно
        this.currentState = new AvailableState();
    }

    // Метод для встановлення стану
    public void setState(LibraryItemState state) {
        this.currentState = state;
    }

    // Метод для отримання поточного стану
    public LibraryItemState getState() {
        return currentState;
    }

    // Метод для відображення поточного стану
    public void displayState() {
        currentState.displayState();
    }
}
