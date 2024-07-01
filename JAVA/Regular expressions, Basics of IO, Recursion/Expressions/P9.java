public class P9 {
    public static void main(String[] args) {
        double a = 4,b=5,c=6;
        double s = (a+b+c)/2;
        double var = s*(s-a)*(s-b)*(s-c);
        double area = Math.sqrt(var);

        System.out.println("area of tringle is :"+area);
    }
}
