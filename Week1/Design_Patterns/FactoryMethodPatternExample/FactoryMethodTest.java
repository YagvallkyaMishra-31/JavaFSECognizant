/**
 * Test class to demonstrate the Factory Method pattern.
 * 
 * Notice how the client code (this class) works with the abstract
 * DocumentFactory and Document types. It doesn't directly call
 * "new WordDocument()" — instead it asks the factory to create
 * the document. This makes it easy to add new document types
 * without changing the client code.
 */
public class FactoryMethodTest {

    public static void main(String[] args) {
        System.out.println("=== Factory Method Pattern Test ===\n");

        // Create the factories
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        // --- Word Document ---
        System.out.println("--- Creating document via WordDocumentFactory ---");
        Document wordDoc = wordFactory.createDocument();
        System.out.println("Document type: " + wordDoc.getDocumentType());
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();

        System.out.println();

        // --- PDF Document ---
        System.out.println("--- Creating document via PdfDocumentFactory ---");
        Document pdfDoc = pdfFactory.createDocument();
        System.out.println("Document type: " + pdfDoc.getDocumentType());
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();

        System.out.println();

        // --- Excel Document ---
        System.out.println("--- Creating document via ExcelDocumentFactory ---");
        Document excelDoc = excelFactory.createDocument();
        System.out.println("Document type: " + excelDoc.getDocumentType());
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();

        System.out.println("\nAll documents created and managed through their factories!");
    }
}
