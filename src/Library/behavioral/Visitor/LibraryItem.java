package Library.behavioral.Visitor;
public interface LibraryItem {
    void accept(LibraryVisitor visitor);
}
