interface Drawable {
    void draw();
}

class CircleDrawer implements Drawable {
    @Override
    public void draw() {}
}

public class P2 {
    public static void main(String[] args) {
        CircleDrawer cd = new CircleDrawer();
        cd.draw();
    }
}
