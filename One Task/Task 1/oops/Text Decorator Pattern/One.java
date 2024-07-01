interface Text {
    String getContent();
}

class SimpleText implements Text {
    private String content;

    public SimpleText(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

abstract class TextDecorator implements Text {
    protected Text text;

    public TextDecorator(Text text) {
        this.text = text;
    }

    public String getContent() {
        return text.getContent();
    }
}

class BoldTextDecorator extends TextDecorator {
    public BoldTextDecorator(Text text) {
        super(text);
    }

    public String getContent() {
        return "<b>" + super.getContent() + "</b>";
    }
}

class ItalicTextDecorator extends TextDecorator {
    public ItalicTextDecorator(Text text) {
        super(text);
    }

    public String getContent() {
        return "<i>" + super.getContent() + "</i>";
    }
}

class One {
    public static void main(String[] args) {
        Text simpleText = new SimpleText("Hello, this is a simple text.");

        Text italicText = new ItalicTextDecorator(simpleText);
        Text boldText = new BoldTextDecorator(simpleText);
        Text boldItalicText = new ItalicTextDecorator(new BoldTextDecorator(simpleText));

        System.out.println("Simple Text: " + simpleText.getContent());
        System.out.println("Italic Text: " + italicText.getContent());
        System.out.println("Bold Text: " + boldText.getContent());
        System.out.println("Bold Italic Text: " + boldItalicText.getContent());
    }
}