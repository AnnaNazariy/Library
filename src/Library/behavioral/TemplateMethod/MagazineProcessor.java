package Library.behavioral.TemplateMethod;
// MagazineProcessor.java
public class MagazineProcessor extends DocumentProcessor {
    @Override
    protected void readDocument() {
        System.out.println("Reading the magazine (Word)...");
    }

    @Override
    protected void analyzeDocument() {
        System.out.println("Analyzing the magazine content...");
    }

    @Override
    protected void formatDocument() {
        System.out.println("Formatting the magazine layout...");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Saving the magazine...");
    }
}


