package Library.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Bookshelf implements LibraryComponent {
    private List<LibraryComponent> components = new ArrayList<>();
    private String shelfName;

    public Bookshelf(String shelfName) {
        this.shelfName = shelfName;
    }

    public void addComponent(LibraryComponent component) {
        components.add(component);
    }

    public void removeComponent(LibraryComponent component) {
        components.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Bookshelf: " + shelfName);
        for (LibraryComponent component : components) {
            component.display();
        }
    }
}
