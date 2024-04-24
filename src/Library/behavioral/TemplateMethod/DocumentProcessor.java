package Library.behavioral.TemplateMethod;
public abstract class DocumentProcessor {
    public final void processDocument() {
        readDocument();
        analyzeDocument();
        formatDocument();
        saveDocument();
    }

    protected abstract void readDocument();

    protected abstract void analyzeDocument();

    protected abstract void formatDocument();

    protected abstract void saveDocument();
}
