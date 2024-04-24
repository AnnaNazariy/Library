package Library.behavioral.Iterator;

import java.util.List;

public class LibraryCollection {
    private List<String> books;

    public LibraryCollection(List<String> books) {
        this.books = books;
    }

    public LibraryIterator createIterator() {
        return new BookIterator();
    }

    private class BookIterator implements LibraryIterator {
        private int position;

        @Override
        public boolean hasNext() {
            return position < books.size();
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return books.get(position++);
            }
            return null;
        }
    }
}
