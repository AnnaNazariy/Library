package Library.behavioral.TemplateMethod;
public class LibraryDocumentProcessor {
    public static void main(String[] args) {
        // Обробка книги (PDF)
        DocumentProcessor bookProcessor = new BookProcessor();
        bookProcessor.processDocument();

        System.out.println();

        // Обробка журналу (Word)
        DocumentProcessor magazineProcessor = new MagazineProcessor();
        magazineProcessor.processDocument();

        System.out.println();

        // Обробка аудіокниги (MP3)
        DocumentProcessor audioBookProcessor = new AudioBookProcessor();
        audioBookProcessor.processDocument();
    }
}
