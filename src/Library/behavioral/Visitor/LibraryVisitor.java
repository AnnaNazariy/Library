package Library.behavioral.Visitor;
public interface LibraryVisitor {
    void visitBook(BookItem book);
    void visitMagazine(MagazineItem magazine);
}
