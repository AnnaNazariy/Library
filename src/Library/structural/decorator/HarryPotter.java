package Library.structural.decorator;

public class HarryPotter implements BookCharacter {
    @Override
    public void describe() {
        System.out.println("I am a character from the Harry Potter series.");
    }
}
