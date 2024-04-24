
package Library.behavioral.State;

public class IssuedState implements LibraryItemState {
    @Override
    public void displayState() {
        System.out.println("Book is issued.");
    }
}
