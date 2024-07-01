package Exceptions;

public class P3 {
    public void finalize() {
        System.out.println("Objects are cleaned");
    }

    public static void main(String[] args) {
        try {
            P3 p = new P3();
            p = null;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.gc();
        }
    }
}
