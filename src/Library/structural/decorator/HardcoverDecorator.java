package Library.structural.decorator;

public class HardcoverDecorator extends BookDecorator {
    public HardcoverDecorator(BookCharacter character) {
        super(character);
    }

    @Override
    public void describe() {
        character.describe();
        System.out.println("I have a hardcover.");
    }

}
