interface Image {
    public void display();
}

class RealImage implements Image {
    private String realImage;

    RealImage(String img) {
        this.realImage = img;
    }

    public void display() {
        System.out.println(realImage);
    }
}

class ProxyImage implements Image {
    private String realImage;

    ProxyImage(String img) {
        this.realImage = img;
    }

    public void display() {
        if(checkImageAvailable()) {
            System.out.println(realImage);
        }
    }

    boolean checkImageAvailable() {
        return true;
    }
}

class One {
    public static void main(String args[]) {
        Image img = new ProxyImage("Sun between the cloud");
        img.display();
    }
}