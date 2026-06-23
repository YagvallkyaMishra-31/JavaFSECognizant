/**
 * DocumentFactory — the abstract "Creator" in the Factory Method pattern.
 * 
 * The whole point of this pattern is that the factory decides WHICH concrete
 * class to instantiate. The client code just calls createDocument() and
 * works with the abstract Document type — it doesn't need to know the
 * specific class being created.
 */
public abstract class DocumentFactory {

    // Subclasses will override this to return their specific document type
    public abstract Document createDocument();
}
