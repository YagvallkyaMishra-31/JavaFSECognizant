/**
 * Factory for creating Word documents.
 * Each concrete factory knows exactly which product (document type) to create.
 */
public class WordDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
