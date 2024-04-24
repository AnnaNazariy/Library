package Library.behavioral.Visitor;
public class BookItem implements LibraryItem {
    private String title;

    public BookItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void accept(LibraryVisitor visitor) {
        visitor.visitBook(this);
    }
}
