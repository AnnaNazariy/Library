package Library.behavioral.Visitor;
public class MagazineItem implements LibraryItem {
    private String name;

    public MagazineItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(LibraryVisitor visitor) {
        visitor.visitMagazine(this);
    }
}
