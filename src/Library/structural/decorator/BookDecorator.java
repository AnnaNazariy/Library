package Library.structural.decorator;

public abstract class BookDecorator implements BookCharacter {
    BookCharacter character;

    public BookDecorator(BookCharacter character) {
        this.character = character;
    }
}
