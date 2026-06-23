/**
 * PdfDocument — a concrete implementation of Document.
 * Represents a PDF file.
 */
public class PdfDocument extends Document {

    @Override
    public void open() {
        System.out.println("Opening PDF document...");
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document...");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document as .pdf file...");
    }
}
