interface Resizable  {
    void resize();
}

class ResizableCircle implements Resizable {

    @Override
    public void resize() {}
    
}

public class P4 {
    public static void main(String[] args) {
        ResizableCircle rc = new ResizableCircle();
        rc.resize();
    }
}
