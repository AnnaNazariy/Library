package Library.behavioral.TemplateMethod;
// BookProcessor.java
public class BookProcessor extends DocumentProcessor {
    @Override
    protected void readDocument() {
        System.out.println("Reading the book (PDF)...");
    }

    @Override
    protected void analyzeDocument() {
        System.out.println("Analyzing the book content...");
    }

    @Override
    protected void formatDocument() {
        System.out.println("Formatting the book pages...");
    }

    @Override
    protected void saveDocument() {
        System.out.println("Saving the book...");
    }
}
