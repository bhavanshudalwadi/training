interface Document {
    public void print();
}

class PDFDocument implements Document {
    public void print() {
        System.out.println("Print PDF Document");
    }
}

class WordDocument implements Document {
    public void print() {
        System.out.println("Print WORD Document");
    }
}

class DocumentFactory {
    public Document getDocument(String str) {
        if(str.equals("PDF")) {
            return new PDFDocument();
        }else if(str.equals("WORD")) {
            return new WordDocument();
        }else {
            return new PDFDocument();
        }
    }
}

class One {
    public static void main(String args[]) {
       DocumentFactory df = new DocumentFactory();
       Document doc = df.getDocument("PDF");
       doc.print();
       doc = df.getDocument("WORD");
       doc.print();
    }
}