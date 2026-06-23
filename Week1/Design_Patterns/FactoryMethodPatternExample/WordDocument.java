/**
 * WordDocument — a concrete implementation of Document.
 * Represents a Microsoft Word-style document.
 */
public class WordDocument extends Document {

    @Override
    public void open() {
        System.out.println("Opening Word document...");
    }

    @Override
    public void close() {
        System.out.println("Closing Word document...");
    }

    @Override
    public void save() {
        System.out.println("Saving Word document as .docx file...");
    }
}
