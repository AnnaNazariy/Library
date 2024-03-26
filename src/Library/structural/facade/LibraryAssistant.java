package Library.structural.facade;

public class LibraryAssistant {
private final TakeOrder takeOrder;
    private final ChooseBook chooseBook;
    private final ReturnBook returnBook;

    public LibraryAssistant(TakeOrder takeOrder, ChooseBook chooseBook, ReturnBook returnBook) {
        this.takeOrder = takeOrder;
        this.chooseBook = chooseBook;
        this.returnBook = returnBook;
    }

    public String workDay() {
        return takeOrder.TakeOrder() + " " + chooseBook.ChooseBook() + " " + returnBook.ReturnBook();
    }
}
