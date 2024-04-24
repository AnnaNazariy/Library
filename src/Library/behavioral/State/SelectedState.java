
package Library.behavioral.State;

public class SelectedState implements LibraryItemState {
    @Override
    public void displayState() {
        System.out.println("Book is selected.");
    }
}
