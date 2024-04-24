package Library.behavioral.Visitor;
public class ConcreteVisitor implements LibraryVisitor {
    @Override
    public void visitBook(BookItem book) {
        System.out.println("Visiting book: " + book.getTitle());
    }

    @Override
    public void visitMagazine(MagazineItem magazine) {
        System.out.println("Visiting magazine: " + magazine.getName());
    }
}
