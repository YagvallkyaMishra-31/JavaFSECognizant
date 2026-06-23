/**
 * Abstract Document class — this is the "Product" in the Factory Method pattern.
 * 
 * It defines what every document can do (open, close, save) but leaves
 * the actual implementation to concrete subclasses like WordDocument, PdfDocument, etc.
 */
public abstract class Document {

    // Each subclass must define how it opens
    public abstract void open();

    // Each subclass must define how it closes
    public abstract void close();

    // Each subclass must define how it saves
    public abstract void save();

    /**
     * Returns the type of document based on the class name.
     * This is a concrete method — all subclasses share this behavior.
     */
    public String getDocumentType() {
        return this.getClass().getSimpleName();
    }
}
