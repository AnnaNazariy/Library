package Library.creational.Builder;

    public class Book {
        private final  Boolean title;
        private final Boolean author;
        private final Boolean year;
        private final Boolean genre;
        public Book(BookBuilder bookBuilder) {
            this.title = bookBuilder.title;
            this.author = bookBuilder.author;
            this.year = bookBuilder.year;
            this.genre = bookBuilder.genre;
        }

        @Override
        public String toString() {
            return "Book {" +
                    "title = " + title +
                    ", author = " + author +
                    ",year = " + year +
                    ", genre = " + genre +
                    '}';
        }

        public static class BookBuilder {
            private Boolean title;
            private Boolean author;
            private Boolean year;
            private Boolean genre;
            public BookBuilder(){}

            public BookBuilder setTitle(Boolean title) {
                this.title = title;
                return this;
            }
            public BookBuilder setAuthor(Boolean author) {
                this.author = author;
                return this;
            }
            public BookBuilder setYear(Boolean year) {
                this.year = year;
                return this;
            }
            public BookBuilder setGenre(Boolean genre) {
                this.genre = genre;
                return this;
            }
            public Book build() {
                return new Book(this);
            }
            }
    }
    



