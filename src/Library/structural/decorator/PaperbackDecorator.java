package Library.structural.decorator;

public class PaperbackDecorator extends BookDecorator {
    public PaperbackDecorator(BookCharacter character) {
        super(character);
    }

    @Override
    public void describe() {
        character.describe();
        System.out.println("I have a paperback cover.");
    }
}
