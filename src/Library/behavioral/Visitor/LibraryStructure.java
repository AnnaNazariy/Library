package Library.behavioral.Visitor;

import java.util.ArrayList;
import java.util.List;

public class LibraryStructure {
    private List<LibraryItem> items = new ArrayList<>();

    public void add(LibraryItem item) {
        items.add(item);
    }

    public void accept(LibraryVisitor visitor) {
        for (LibraryItem item : items) {
            item.accept(visitor);
        }
    }
}
