package Library.behavioral.TemplateMethod;
// AudioBookProcessor.java
public class AudioBookProcessor extends DocumentProcessor {
    @Override
    protected void readDocument() {
        System.out.println("Listening to the audio book (MP3)...");
    }

    @Override
    protected void analyzeDocument() {
        System.out.println("Analyzing the audio book content...");
    }

    @Override
    protected void formatDocument() {
        System.out.println("No formatting needed for audio books...");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Saving the audio book...");
    }
}
