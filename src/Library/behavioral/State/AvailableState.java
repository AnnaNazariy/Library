package Library.behavioral.State;
class AvailableState implements LibraryItemState {
    @Override
    public void displayState() {
        System.out.println("Book is available for borrowing.");
    }
}