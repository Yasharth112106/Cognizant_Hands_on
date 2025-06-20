// FactoryMethodPatternExample.java

public class FactoryMethodPatternExample {

    // ===== Step 2: Document interface =====
    interface Document {
        void open();
    }

    // ===== Step 3: Concrete Document classes =====
    static class WordDocument implements Document {
        public void open() {
            System.out.println("Opening a Word Document.");
        }
    }

    static class PdfDocument implements Document {
        public void open() {
            System.out.println("Opening a PDF Document.");
        }
    }

    static class ExcelDocument implements Document {
        public void open() {
            System.out.println("Opening an Excel Document.");
        }
    }

    // ===== Step 4: Abstract Factory =====
    abstract static class DocumentFactory {
        public abstract Document createDocument();
    }

    // ===== Step 4: Concrete Factories =====
    static class WordDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // ===== Step 5: Test class =====
    public static void main(String[] args) {
        // Create Word document using factory
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        // Create PDF document using factory
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        // Create Excel document using factory
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}
