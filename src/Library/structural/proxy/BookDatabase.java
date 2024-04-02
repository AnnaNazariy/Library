package Library.structural.proxy;

import java.util.HashMap;
import java.util.Map;

public class BookDatabase {
    private Map<Integer, String> ancientBooks = new HashMap<>();

    public BookDatabase() {
        // Імітація додавання стародавніх книг до бази даних
        ancientBooks.put(1, "The Iliad");
        ancientBooks.put(2, "The Odyssey");
        ancientBooks.put(3, "The Art of War");
    }

    public String getAncientBook(int bookId) {
        return ancientBooks.getOrDefault(bookId, "Unknown");
    }
}
